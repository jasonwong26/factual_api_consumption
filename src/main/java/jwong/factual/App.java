package jwong.factual;

import jwong.factual.base.FactualQuery;
import jwong.factual.implementation.BasicData;
import jwong.factual.implementation.FactualConnection;
import jwong.factual.implementation.LocalQuery;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Starting Test:" );
        System.out.println( "Run Basic Query:" );
        queryFactual();
    }

    private static void queryFactual() {
		try {
			FactualQuery query = new LocalQuery("Cafe 70 Degrees", new BasicData(), FactualConnection.getInstance());
			query.runQuery();
			printQueryResults((BasicData)query.getData());
        }
        catch(Exception e){
            printQueryFailure(e);
        }
	}

	private static void printQueryResults(BasicData data){
		for(int i = 0; i < data.length(); i++){
			System.out.println("result  #: " + i + 1);
			System.out.println("name    #: " + data.results.get(i).getName());
			System.out.println("tel     #: " + data.results.get(i).getTelephone());
			System.out.println("address #: " + data.results.get(i).getAddress());
		}
	}

	private static void printQueryFailure(Exception e) {
		System.out.println( "Query failed due to error: " + e.getMessage() );
	}
}
