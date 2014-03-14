package jwong.factual.base;

import java.util.ArrayList;
import com.factual.driver.ReadResponse;

public interface FactualData {
	public abstract String[] fields();

	// GET/SET Methods
	public abstract ArrayList<?> getResults();

	public abstract int length();

	// Methods
	public abstract void parseResponse(ReadResponse response);

}