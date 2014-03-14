package jwong.factual.implementation;

import com.factual.driver.Factual;
import com.factual.driver.Query;
import com.factual.driver.ReadResponse;

import jwong.factual.Settings;
import jwong.factual.base.FactualData;
import jwong.factual.base.FactualQuery;

// TODO: extract interface and create factory
public class LocalQuery extends FactualQuery {	
	// FIELDS
	String business_name;
	
	// Constructors
	public LocalQuery(String business_name, FactualData data, Factual connection){
		this.business_name = business_name;
		this.data = data;
		this.connection = connection;
	}

	// GET/SET Methods
	public FactualData getData() {
		return data;
	}
	
	// Public Methods
	public void runQuery(){
		constructQuery();
		performQuery();
	}

	private void constructQuery() {
		query = new Query();
		query.field("name").search(business_name);
		query.within(Settings.LocalQuery.GEO_CRITERIA);
		query.limit(Settings.LocalQuery.LIMIT);
		query.only(data.fields());
	}
	
	private void performQuery() {
		ReadResponse response = connection.fetch(Settings.LocalQuery.FACTUAL_TABLE, query);
		if (response.size() > 0)
			data.parseResponse(response);
	}
}
