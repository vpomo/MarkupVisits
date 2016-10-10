package com.vpomo.markupvisits.os.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * Created by Pomogalov on 10.10.2016.
 */
public class WebService {

    public int getBaseURL(String proxyAddressPort, String baseUrl, String titlePage) throws InterruptedException {
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
    }

    public int clickLinkURL(String proxyAddressPort, String baseUrl, String urlClick, String titlePage) throws Exception {
        String newTitlePage = "";
        Random timeWaiting = new Random();
        int koefTimeWaiting;

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
            if (titlePage.equals(newTitlePage)) {
                driver.findElement(By.linkText(urlClick)).click();
                koefTimeWaiting = timeWaiting.nextInt(5);
                sleep(3000 + koefTimeWaiting * 1000);
                newTitlePage = driver.getTitle();
                System.out.println("newTitlePage = " + newTitlePage);
                koefTimeWaiting = timeWaiting.nextInt(5);
                sleep(2000 + koefTimeWaiting * 1000);
                driver.quit();
                return 1;
            } else {
                System.out.print("newTitlePage = " + newTitlePage);
                driver.quit();
                return 2;
            }
        } else {
            return 0;
        }
    }

    public WebDriver initDriver(String PROXY) {
        System.setProperty("webdriver.chrome.driver", "D:/Java/WebDriver/chromedriver.exe");

        org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
        proxy.setHttpProxy(PROXY)
                .setFtpProxy(PROXY)
                .setSslProxy(PROXY);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, proxy);

        ChromeOptions option = new ChromeOptions();
        option.addArguments(getCurrentSizeWindow());
        capabilities.setCapability(ChromeOptions.CAPABILITY, option);
        WebDriver driver = new ChromeDriver(capabilities);

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

        return driver;
    }

    public String getCurrentSizeWindow() {
        String sizeWindow;
        Random currentSizeWindow = new Random();
        int typeSizeWindow;
        typeSizeWindow = currentSizeWindow.nextInt(4);
        switch (typeSizeWindow) {
            case 0:
                sizeWindow = "start-maximized";
                break;
            case 1:
                sizeWindow = "--window-size=800,600";
                break;
            case 2:
                sizeWindow = "--window-size=1024,768";
                break;
            case 3:
                sizeWindow = "--window-size=500,400";
                break;
            default:
                sizeWindow = "start-maximized";
                break;
        }
        return sizeWindow;
    }
}
