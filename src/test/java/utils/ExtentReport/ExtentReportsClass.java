package utils.ExtentReport;



import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.io.File;

public class ExtentReportsClass {
/*
    public WebDriver driver;
    public static final ExtentReports extentReports = new ExtentReports();
    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
        reporter.config().setReportName("Sample Extent Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Blog Name", "SW Test Academy");
        extentReports.setSystemInfo("Author", "Onur Baskirt");
        return extentReports;
    }

 */

    ExtentReports extent;
    ExtentTest logger;

    //@BeforeTest
    public void startTest(){

        extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);

        //extent.addSystemInfo("Environment","Environment Name")
        extent
                .addSystemInfo("Host Name", "Bangla software test")
                .addSystemInfo("Environment", "Selenium web flink")
                .addSystemInfo("User Name", "MMZaman QA");

        extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));


    }


}
