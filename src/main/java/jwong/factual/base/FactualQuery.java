package jwong.factual.base;


import com.factual.driver.Factual;
import com.factual.driver.Query;

public abstract class FactualQuery {
	// FIELDS
	protected Factual connection;
	protected Query query;
	protected FactualData data;

	// GET/SET Methods
	public abstract FactualData getData();
	
	// Public Methods
	public abstract void runQuery();
}
