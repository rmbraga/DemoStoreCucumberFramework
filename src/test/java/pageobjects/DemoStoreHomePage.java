package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class DemoStoreHomePage extends TestBase {
	
//	@FindBy(xpath = "//img[@src='http://demo.cs-cart.com/stores/0441c61cb7e26414/images/logos/1/cart_feg3-lv.png']")
//	WebElement demoStoreLogo;
	
	@FindBy(xpath = "//input[@id='search_input']")
	WebElement searchField;	

	public DemoStoreHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateDemoStorePageLoaded() {
		assertExists(By.xpath("//div[@class='ty-logo-container']"), 15);
	}

	public void doSearchItem(String item) {
		searchField.clear();
		searchField.sendKeys(item);
		searchField.submit();
	}

}
