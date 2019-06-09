package stepdefinitions;

import cucumber.api.java.en.When;
import pageobjects.DemoStoreHomePage;
import pageobjects.DemoStoreProductPage;
import pageobjects.DemoStoreSearchResultsPage;

public class DemoStoreWhenSteps {

	@When("^the user searches for '(.*)'$")
	public void userHasDemoStorePageloaded(String item) {
		DemoStoreHomePage pDemoStoreHomePage = new DemoStoreHomePage();
		pDemoStoreHomePage.doSearchItem(item);
	}
	
	
	@When("^the user clicks on '(.*)' item on the search results page$")
	public void userClicksOnItem(String item) {
		DemoStoreSearchResultsPage pDemoStoreSearchResultsPage = new DemoStoreSearchResultsPage();
		pDemoStoreSearchResultsPage.doClickOnItem(item);
	}
	
	
	@When("^the user clicks on 'ADICIONAR AO CARRINHO'$")
	public void userClicksOnAdicionarAoCarrinho() {
		DemoStoreProductPage pDemoStoreProductPage = new DemoStoreProductPage();
		pDemoStoreProductPage.doClickOnAdicionarAoCarrinho();
	}
	
	
	@When("^the user clicks on 'MY CART'$")
	public void userClicksOnMyCart() {
		DemoStoreProductPage pDemoStoreProductPage = new DemoStoreProductPage();
		pDemoStoreProductPage.doClickOnMyCart();
	}

	
	@When("^the user clicks on 'VER CARRINHO'$")
	public void userClicksOnVerCarrinho() {
		DemoStoreProductPage pDemoStoreProductPage = new DemoStoreProductPage();
		pDemoStoreProductPage.doClickOnVerCarrinho();
	}
	
}
