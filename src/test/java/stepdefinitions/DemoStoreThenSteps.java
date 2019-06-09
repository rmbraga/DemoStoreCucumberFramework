package stepdefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import pageobjects.DemoStoreCartPage;
import pageobjects.DemoStoreProductPage;
import pageobjects.DemoStoreSearchResultsPage;

public class DemoStoreThenSteps {
	
	@Then("^the demo store shows the 'Resultados da pesqusisa' page loaded$")
	public void demoStoreResultadosDaPesquisaPageLoaded() {
		DemoStoreSearchResultsPage pDemoStoreSearchResultsPage = new DemoStoreSearchResultsPage();
		pDemoStoreSearchResultsPage.validatePageLoaded();
	}
	
	@Then("^the demo store shows the '(.*)' product page loaded$")
	public void demoStoreShowsTheProductPageLoaded(String item) {
		DemoStoreProductPage pDemoStoreProductPage = new DemoStoreProductPage();
		pDemoStoreProductPage.validatePageLoaded();
		pDemoStoreProductPage.validateItemOnProductPage(item);
	}
	
	
	@Then("^the demo store shows the 'O produto foi adicionado ao seu carrinho' modal$")
	public void demoStoreShowsOProdutoFoiAdicionadoAoCarrinhoModal() {
		DemoStoreProductPage pDemoStoreProductPage = new DemoStoreProductPage();
		pDemoStoreProductPage.validateModalIsDisplayed();
	}
	
	
	@Then("^the user clicks on 'CONTINUAR COMPRAS'$")
	public void userClicksOnContinuarCompras() {
		DemoStoreProductPage pDemoStoreProductPage = new DemoStoreProductPage();
		pDemoStoreProductPage.doClickOnContinuarCompras();
	}
	
	
	@Then("^the demo store shows the 'Conteudo do Carrinho' page loaded$")
	public void demoStoreShowsCartContentPageLoaded() {
		DemoStoreCartPage pDemoStoreCartPage = new DemoStoreCartPage();
		pDemoStoreCartPage.validatePageLoaded();
	}
	
	
	@Then("^the demo store shows the following items added to the cart:$")
	public void demoStoreShowsFollowingItemsAddedToCart(DataTable table) {
		DemoStoreCartPage pDemoStoreCartPage = new DemoStoreCartPage();
		pDemoStoreCartPage.validateItensAddedToCart(table);
	}

}
