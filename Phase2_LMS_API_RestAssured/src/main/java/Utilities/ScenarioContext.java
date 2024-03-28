package Utilities;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.gherkin.model.Scenario;

public class ScenarioContext {
	
	private Map<String, String> scenarioData;
	private Scenario scenario;

	    public ScenarioContext() {
	        scenarioData = new HashMap<String, String>();
	    }

	    public String setContext(String key, String value) {
	        scenarioData.put(key, value);
			return value;
	    }

	    public String getContext(String key, String token) {
	         return scenarioData.get(key);
	    }

	    public void setScenario(Scenario scenario) {
	        this.scenario = scenario;
	    }

		public String getContext(String string) {
			return scenarioData.get(string);
		}

}
