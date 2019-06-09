package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");

		switch (browserName) {
		case "chrome":

			System.setProperty("webdriver.chrome.driver", ".\\src\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();

			break;
		case "ff":

			System.setProperty("webdriver.gecko.driver", ".\\src\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

			break;
		case "ie":

			System.setProperty("webdriver.gecko.driver", ".\\src\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

			break;

		default:
			// exibir mensagem de erro caso o driver não tenha sido encontrado
			break;
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

	public static void finalization() {
		driver.quit();
	}

	public void assertExists(By by, int timeout) {
		try {
			new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (TimeoutException t) {
			String erro = "assertExists: Elemento selecionaro pelo " + by.toString() + " não foi encontrado na tela.";
			System.out.println(erro);
		}
	}

}
