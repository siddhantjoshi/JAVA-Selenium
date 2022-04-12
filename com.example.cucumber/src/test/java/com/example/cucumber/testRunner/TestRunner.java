package com.example.cucumber.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\2108053\\eclipse-workspace\\com.page.object.model.cucumber\\src\\main\\java\\com\\page\\object\\model\\cucumber\\feature\\project.feature", // the path of the feature files
		glue = { "com\\example\\cucumber\\step" }, // the path of the step definition files
//		plugin = { "pretty", "html:test_outout/cucumber.html", "json:report_json/cucumber.json","junit:report_xml/cucumber.xml" },
		monochrome = true,
		dryRun = true
		)

public class TestRunner {

}
