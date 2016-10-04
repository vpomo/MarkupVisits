package com.vpomo.reportglonass.web;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.Thread.sleep;
import static org.junit.Assert.fail;


/**
 * Created by Помогалов on 11.08.2015.
 */

public class AdminUsersTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();


    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://f1.amurobl.ru/reportglonass/";
        driver.navigate().to(baseUrl);
    }


    @Test
    public void testJavaTest1() throws Exception {
        sleep(1000);
        driver.findElement(By.id("top-image")).click();
        driver.findElement(By.linkText("Аппарат губернатора области и Правительства области")).click();
        sleep(1000);
        driver.findElement(By.id("top-image")).click();
        driver.findElement(By.linkText("Сковородинский район")).click();
        sleep(1000);
    }


    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }


    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }


}