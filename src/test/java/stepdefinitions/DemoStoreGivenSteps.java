package stepdefinitions;

import cucumber.api.java.en.Given;
import pageobjects.DemoStoreHomePage;

public class DemoStoreGivenSteps {
	
	@Given("^that the user has the demo store page loaded$")
	public void userHasDemoStorePageloaded() {
		DemoStoreHomePage pDemoStoreHomePage = new DemoStoreHomePage();
		pDemoStoreHomePage.validateDemoStorePageLoaded();
	}
}
