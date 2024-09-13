package com.swaglabs;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseTest {
    protected WebDriver driver;
    protected ExtentReports extentReports;
    protected ExtentTest extentTest;
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeClass
    public void setUpClass() {

ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extentReports.html");
        
        // Optionally set configuration options
        sparkReporter.config().setDocumentTitle("Sauce Demo Automation Report"); // Set document title
        sparkReporter.config().setReportName("Sauce Demo Test Report"); // Set report name
        
        // Create an instance of ExtentReports
        extentReports = new ExtentReports();
        
        // Attach the reporter to ExtentReports
        extentReports.attachReporter(sparkReporter);
    }

    @BeforeMethod
    public void setUp() {
        logger.info("Setting up WebDriver.");
        WebDriverManager.chromedriver().setup();  
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Closing WebDriver.");
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterClass
    public void tearDownClass() {
        extentReports.flush();
    }
}

