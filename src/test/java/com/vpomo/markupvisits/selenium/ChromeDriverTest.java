package com.vpomo.markupvisits.selenium;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

/**
 * Created by Zver on 05.10.2016.
 */
public class ChromeDriverTest {
    //public static WebDriver driver;

    @BeforeClass
    public static void createAndStartService() throws IOException {
        //System.setProperty("webdriver.chrome.driver","D:/Java/WebDriver/chromedriver.exe");
    }

    @Before
    public void setUp() {
        //driver = new ChromeDriver();
    }

    @Test
    public void simpleTest() {

            // Optional, if not specified, WebDriver will search your path for chromedriver.
            System.setProperty("webdriver.chrome.driver", "D:/Java/WebDriver/chromedriver.exe");

            WebDriver driver = new ChromeDriver();
            driver.get("http://www.google.com/xhtml");
            //Thread.sleep(1000);  // Let the user actually see something!
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("ChromeDriver");
            searchBox.submit();
            //Thread.sleep(5000);  // Let the user actually see something!
            driver.quit();

    }

    @After
    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
    }

    @AfterClass
    public static void createAndStopService() {

    }

}
