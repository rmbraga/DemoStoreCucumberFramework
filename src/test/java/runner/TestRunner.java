package runner;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cucumber.listener.Reporter;

import base.Report;
import base.TestBase;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(features = "src/test/java/features", glue = { "stepdefinitions" }, tags = { "@runthis" }, plugin = {
		"com.cucumber.listener.ExtentCucumberFormatter:output/report.html" })
public class TestRunner extends TestBase {

	public TestRunner() {
		super();
	}

	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	@DataProvider
	public Object[][] features() {
		return testNGCucumberRunner.provideFeatures();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		Reporter.loadXMLConfig(new File(Report.getReportConfigPath()));
		testNGCucumberRunner.finish();
	}
	
	@BeforeMethod
	public static void setUp() {
		initialization();
	}

	@AfterMethod
	public static void tearDown() {
		finalization();
	}

}
