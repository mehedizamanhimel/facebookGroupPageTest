import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.TestData;

import java.io.IOException;
import java.time.Duration;

public class BaseTestClass {

    WebDriver driver;
    static TestData testData;
    ExtentReports extent;

    @BeforeTest
    public void beforeMethod() throws IOException {
        testData = new TestData();

        // com.aventstack v5 API: use ExtentSparkReporter instead of deprecated HTML reporter
        ExtentSparkReporter reporter = new ExtentSparkReporter(
                System.getProperty("user.dir") + "/test-output/testReport.html");
        reporter.config().setReportName("Facebook Group Test Report");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Host Name", "Mehedi Zaman");
        extent.setSystemInfo("Environment", "Facebook test group");
        extent.setSystemInfo("User Name", "MMZaman QA");

        String browser = testData.properties.getProperty("browser");

        switch (browser) {
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                ChromeOptions opts = new ChromeOptions();
                opts.addArguments("--no-sandbox", "--disable-dev-shm-usage");
                driver = new ChromeDriver(opts);
                break;
            }
            case "chrome-headless": {
                WebDriverManager.chromedriver().setup();
                ChromeOptions opts = new ChromeOptions();
                opts.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
                driver = new ChromeDriver(opts);
                break;
            }
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
            case "firefox-headless": {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions ffOpts = new FirefoxOptions();
                ffOpts.addArguments("-headless");
                driver = new FirefoxDriver(ffOpts);
                break;
            }
            case "ie": {
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            }
            case "edge": {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            }
            case "safari": {
                WebDriverManager.getInstance(SafariDriver.class).setup();
                driver = new SafariDriver();
                break;
            }
        }

        driver.manage().window().setSize(new Dimension(1600, 1100));
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest
    public void afterMethod() {
        extent.flush();
        driver.close();
    }
}
