package com.ui.runner;

import java.io.IOException;

import org.junit.AfterClass;

import com.ui.page.actions.CommonActions;

import io.cucumber.junit.platform.engine.Cucumber;

@Cucumber
public class CucumberTest {
	@AfterClass
	public static void afterClass() throws IOException {
		CommonActions.tearDown();
	}

}
