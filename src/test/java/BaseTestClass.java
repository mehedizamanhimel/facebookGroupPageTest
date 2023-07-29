import com.relevantcodes.extentreports.ExtentReports;
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.TestData;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTestClass {

    WebDriver driver;
    static TestData testData;
    ExtentReports extent;

    /*
    Setting up before method.
    It's a library from TestNG that is being before the test case execution.
     */

    @BeforeTest
    public void beforeMethod() throws IOException {
        testData = new TestData();

        extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/testReport.html", true);
        extent
                .addSystemInfo("Host Name", "Mehedi Zaman")
                .addSystemInfo("Environment", "Facebook test group")
                .addSystemInfo("User Name", "MMZaman QA");

        extent.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
        /*
        Here we used WebDriverManager to avoid downloading and storing the browser drivers.
        We keep the browser name as a property in the property file.
        The browser that is gonna be used will be uncommented.
         */

            String browser = testData.properties.getProperty("browser");

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;

                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;
            }

            driver.manage().window().setSize(new Dimension(1600, 1100));
            driver.manage().window().setPosition(new Point(0, 0));


            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }



    /*

    Setting aftermethod.
    It's also a library from TestNG that is being used once the test case execution is done.
    it's mainly being used for the post preparation after executing a test case.

     */

        @AfterTest
        public void afterMethod () {
            driver.close();
        }
    }

