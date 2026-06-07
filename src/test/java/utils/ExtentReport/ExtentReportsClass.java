package utils.ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsClass {

    ExtentReports extent;
    ExtentTest logger;

    public void startTest() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(
                System.getProperty("user.dir") + "/test-output/STMExtentReport.html");
        reporter.config().setReportName("Facebook Group Test Report");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Host Name", "Bangla software test");
        extent.setSystemInfo("Environment", "Selenium web flink");
        extent.setSystemInfo("User Name", "MMZaman QA");
    }
}
