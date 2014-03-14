package jwong.factual;

import com.factual.driver.Circle;

public class Settings {
	private Settings(){
		throw new UnsupportedOperationException();
	}
	
	public static class FactualAccount {
		public static String ACCOUNT_KEY = "XXXX";  // KEY value removed for security
		public static String ACCOUNT_SECRET = "XXXX"; // SECRET value Removed for security
	}
	
	public static class LocalQuery {
	    public static Circle GEO_CRITERIA = new Circle(34.0058995, -118.4090245, 5000);
	    public static String FACTUAL_TABLE = "places";
	    public static int LIMIT = 3;
	}
}