package com.api.stepdefinitions;

import javax.inject.Inject;

import com.api.ScenarioContext;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SampleStepDefinitions {
	@Inject
	public ScenarioContext scn;

	@Given("I have Jira get task details api")
	public void I_have_Jira_get_task_details_api() {
		scn.log("Given is printed");

	}

	@When("I send request to fetch task details")
	public void I_send_request_to_fetch_task_details(DataTable datatable) {
		scn.log("When is printed");
	}

	@Then("I should get the task details")
	public void I_should_get_the_task_details() {
		scn.log("Then is printed");
	}
}
