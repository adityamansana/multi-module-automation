package com.api;

import javax.inject.Inject;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java8.En;

public class Hooks implements En{

	@Inject
	private ScenarioContext scenarioContext;
	public static Scenario scn;
	
	@Before
	public void setup(final Scenario scenario) {
		scn=scenario;
		scenario.log(">> Validating "+scn.getName()+ " Api");
		scenarioContext.setScenario(scenario);
	}
	
	@After
	public void tearDown() {
		scn.log(">> Test status of "+ scn.getName() + " is "+scn.getStatus());
	}
//	public Hooks() {
//		Before("@SmokeTest",(final Scenario scenario) ->{
//		});
//	}
}
