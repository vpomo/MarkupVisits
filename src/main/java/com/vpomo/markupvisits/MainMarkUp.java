package com.vpomo.markupvisits;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.assertj.core.api.Fail.fail;

/**
 * Created by Pomogalov on 04.10.2016.
 */
public class MainMarkUp {

    public static void main(String[] args) throws Exception {
        int result;
        String proxy1 = "5.9.117.40:3128";
        String proxy2 = " 178.236.129.5:3128";
        String url1 = "https://whoer.net/ru";
        String url2 = "http://amit.ru";

        result = getBaseURL(url1, proxy2, "Узнать свой IP адрес");
        System.out.print("result = " + result);

        result = getBaseURL(url2, proxy1, "Амурские Информационные Технологии");
        System.out.print("result = " + result);

    }

    private static WebDriver initDriver(String PROXY) {
        System.setProperty("webdriver.chrome.driver", "D:/Java/WebDriver/chromedriver.exe");

        org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
        proxy.setHttpProxy(PROXY)
                .setFtpProxy(PROXY)
                .setSslProxy(PROXY);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, proxy);

        ChromeOptions option = new ChromeOptions();
        option.addArguments("start-maximized");
        //option.addArguments("--window-size=500,500");
        capabilities.setCapability(ChromeOptions.CAPABILITY, option);
        WebDriver driver = new ChromeDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

        return driver;

    }

    public static int getBaseURL(String baseUrl, String proxyAddressPort, String titlePage) throws InterruptedException {
        String newTitlePage = "";
        if (proxyAddressPort != null) {
            WebDriver driver = initDriver(proxyAddressPort);
            try {
                driver.get(baseUrl);
                sleep(5000);
                newTitlePage = driver.getTitle();
            } catch (Exception e) {
                driver.close();
                driver.quit();
                return 3;
            }
            newTitlePage = driver.getTitle();
            driver.quit();
            if (titlePage.equals(newTitlePage)) {
                System.out.println("newTitlePage = " + newTitlePage);
                return 1;
            } else {
                System.out.print("newTitlePage = " + newTitlePage);
                return 2;
            }
        } else {
            return 0;
        }
        //driver.findElement(By.linkText(urlClick)).click();
    }

}
