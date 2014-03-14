package jwong.factual.implementation;

import jwong.factual.Settings;

import com.factual.driver.Factual;

// Implemented as Single-Thread, Lazy Singleton
public final class FactualConnection {
	   private static Factual INSTANCE;
	   
	   private FactualConnection() {}

	   public static Factual getInstance() {
		   if (INSTANCE == null)
			   INSTANCE = new Factual(Settings.FactualAccount.ACCOUNT_KEY, Settings.FactualAccount.ACCOUNT_SECRET);
	      return INSTANCE;
	   }
}
