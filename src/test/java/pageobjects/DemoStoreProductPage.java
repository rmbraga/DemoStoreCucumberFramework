package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class DemoStoreProductPage extends TestBase {
	String parametro = null;

	@FindBy(xpath = "//button[text()='Adicionar ao carrinho']")
	WebElement btnAdicionarAoCarrinho;
	
	@FindBy(xpath = "//div[contains(@class, 'cm-notification-content')]")
	WebElement productAddedModal;
	
	@FindBy(xpath = "//a[text()='Continuar compras']")
	WebElement btnContinuarCompras;
	
	@FindBy(xpath = "//div[@id='sw_dropdown_8']//a[contains(@href,'http://demo.cs-cart.com/stores/')]")
	WebElement btnMyCart;
	
	@FindBy(xpath = "//a[text()='Ver carrinho']")
	WebElement btnVerCarrinho;

	public WebElement itemOnProductPage(String parametro) {
		return driver.findElement(By.xpath("//h1[normalize-space()='" + parametro + "']"));
	}

	public DemoStoreProductPage() {
		PageFactory.initElements(driver, this);
	}

	public void validatePageLoaded() {
		assertExists(By.xpath("//button[text()='Adicionar ao carrinho']"), 15);
	}

	public void validateItemOnProductPage(String item) {
		WebElement product = itemOnProductPage(item);
		String valueToValidate = product.getText().trim();
		Assert.assertEquals(valueToValidate, item);
	}

	public void doClickOnAdicionarAoCarrinho() {
		btnAdicionarAoCarrinho.click();
	}

	public void validateModalIsDisplayed() {
		assertExists(By.xpath("//h1[text()='O produto foi adicionado ao seu carrinho']"), 15);
		productAddedModal.isDisplayed();
	}

	public void doClickOnContinuarCompras() {
		btnContinuarCompras.click();
	}

	public void doClickOnMyCart() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", btnMyCart);
	}

	public void doClickOnVerCarrinho() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", btnVerCarrinho);
	}

}
