//package org.example.hooks;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import io.cucumber.java.Before;
//import io.cucumber.java.After;
//import io.cucumber.java.Scenario;
//import org.example.utils.DriverManager;
//
//public class Hooks {
//    private static ExtentReports extent;
//    private static ExtentTest test;
//    private final DriverManager driverManager;
//
//    public Hooks(DriverManager driverManager) {
//        this.driverManager = driverManager;
//    }
//
//    @Before
//    public void beforeScenario(Scenario scenario) throws Exception {
//        // Initialize ExtentReports on first scenario
//        if (extent == null) {
//            ExtentSparkReporter spark = new ExtentSparkReporter("target/extent-reports/ExtentReport.html");
//            spark.config().setReportName("Flipkart Automation Test Report");
//            spark.config().setDocumentTitle("Automation Test Results");
//            extent = new ExtentReports();
//            extent.attachReporter(spark);
//        }
//
//        // Create test entry for this scenario
//        test = extent.createTest(scenario.getName());
//        test.info("Scenario: " + scenario.getName());
//
//        // Setup driver and initialize page objects (but don't navigate yet)
//        driverManager.setup();
//    }
//
//    @After
//    public void afterScenario(Scenario scenario) {
//        // Log scenario result to extent report
//        if (scenario.isFailed()) {
//            test.fail("Scenario failed: " + scenario.getName());
//        } else {
//            test.pass("Scenario passed: " + scenario.getName());
//        }
//
//        // Close driver
//        if (driverManager.driver != null) {
//            driverManager.driver.quit();
//        }
//
//        // Flush extent report if all scenarios are done
//        // (ExtentReports will write the report when JVM exits or explicitly flushed)
//    }
//
//    public static void flushReport() {
//        if (extent != null) {
//            extent.flush();
//        }
//    }
//}
//
//
