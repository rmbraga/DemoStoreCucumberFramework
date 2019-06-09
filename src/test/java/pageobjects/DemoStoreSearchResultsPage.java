package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class DemoStoreSearchResultsPage extends TestBase {
	String parametro = null;
	
	// Decidi fazer desta maneira porque então, não precisaremos ficar criando um xpath para cada item
	public WebElement itemToBeAddedToTheCart(String parametro) {
		return driver.findElement(By.xpath("//bdi//a[text()='"+parametro+"']"));
	}
	
	public DemoStoreSearchResultsPage() {
		PageFactory.initElements(driver, this);
	}

	public void validatePageLoaded() {
		assertExists(By.xpath("//span[text()='Resultados da pesquisa']"), 15);
	}

	public void doClickOnItem(String item) {
		WebElement myItem = itemToBeAddedToTheCart(item);
		myItem.click();
	}

}
