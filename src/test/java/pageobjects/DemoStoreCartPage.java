package pageobjects;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import cucumber.api.DataTable;

public class DemoStoreCartPage extends TestBase {

	public DemoStoreCartPage() {
		PageFactory.initElements(driver, this);
	}

	public void validatePageLoaded() {
		assertExists(By.xpath("//h1[text()='Conteúdo do carrinho']"), 15);
	}

	public void validateItensAddedToCart(DataTable table) {
		List<Map<String, String>> maps = table.asMaps(String.class, String.class);

		for (Map<String, String> map : maps) {
			String valueToValidate = map.get("Item");

			assertExists(By.xpath("//table//a[text()='" + valueToValidate + "']"), 15);
		}
	}

}
