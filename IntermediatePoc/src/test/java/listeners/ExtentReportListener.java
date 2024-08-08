//package listeners;
//
//	import com.aventstack.extentreports.ExtentReports;
//	import com.aventstack.extentreports.ExtentTest;
//	import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//
//import data_providers.ConfigFileReader;
//import io.cucumber.java.After;
//	import io.cucumber.java.Before;
//	import io.cucumber.java.Scenario;
//	import java.io.File;
//
//	public class ExtentReportListener {
//
//	    private static ExtentReports extent;
//	    private static ExtentHtmlReporter htmlReporter;
//	    public ExtentTest test;
//
//	    @Before
//	    public void setUp() {
//	        String reportConfigPath = new ConfigFileReader().getReportConfigPath();
//	        htmlReporter = new ExtentHtmlReporter(new File("target/cucumber-reports.html"));
//	        htmlReporter.loadXMLConfig(reportConfigPath);
//
//	        extent = new ExtentReports();
//	        extent.attachReporter(htmlReporter);
//	    }
//
//	    @After
//	    public void tearDown(Scenario scenario) {
//	    	test=extent.createTest("Praveen test");
//	        if (scenario.isFailed()) {
//	            test.fail(scenario.getName() + " failed.");
//	        } else {
//	            test.pass(scenario.getName() + " passed.");
//	        }
//
//	        extent.flush();
//	    }
//	}
