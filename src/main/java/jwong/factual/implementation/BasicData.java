package jwong.factual.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import com.factual.driver.ReadResponse;
import jwong.factual.base.FactualData;

public class BasicData implements FactualData {
	// Constants
	String[] fields = {"factual_id", "name", "tel", "address", "postcode"};

	// Fields
	public ArrayList<Data> results;
	
	// Constructors
	public BasicData(){
	}
	
	// GET/SET Methods
	public String[] fields() { 
		return fields; 
	}

	public ArrayList<Data> getResults(){ 
		return results; 
	}

	public int length() {
		return results.size();
	}
	
	// Methods
	public void parseResponse(ReadResponse response) {
		ArrayList<Data> dataList = new ArrayList<Data>();
		
		List<Map<String,Object>> input = response.getData();
		for(ListIterator<Map<String,Object>> i = input.listIterator(); i.hasNext();){			
			dataList.add(parseMap(i.next()));
		}
		
		results = dataList;		
	}
	
	private Data parseMap(Map<String,Object> input){
		Data data = new Data();
		data.factual_id = (String)input.get("factual_id");
		data.name = (String)input.get("name");
		data.telephone = (String)input.get("tel");
		data.address = (String)input.get("address");
		data.postcode = (String)input.get("postcode");
		
		return data;
	}
	
	// Class implementation of fields
	public final class Data {
		// Fields
		String factual_id;
		String name;
		String telephone;
		String address;
		String postcode;
		
		// Constructors
		public Data(){
			this(null, null, null, null, null);
		}
		public Data(String factual_id) {
			this(factual_id, null, null, null, null);
		}
		public Data(String factual_id, String name, String telephone, String address, String postcode){
			this.factual_id = factual_id;
			this.name = name;
			this.telephone = telephone;
			this.address = address;
			this.postcode = postcode;
		}
	
		// Get/Set Methods
		public String[] getFields() { 
			return fields;
		}
		public String getFactual_id() {
			return factual_id;
		}
		public void setFactual_id(String factual_id) {
			this.factual_id = factual_id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getTelephone() {
			return telephone;
		}
		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPostcode() {
			return postcode;
		}
		public void setPostcode(String postcode) {
			this.postcode = postcode;
		}	
		
		// Public Methods
		@Override
		public String toString() {
			return "BasicData [factual_id=" + factual_id + ", name=" + name
					+ ", telephone=" + telephone + ", address=" + address
					+ ", postcode=" + postcode + "]";
		}
	}
}
