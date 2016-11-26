package com.vpomo.markupvisits.os.service;

import com.vpomo.markupvisits.os.model.TrackVisit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.vpomo.markupvisits.os.model.Settings.PATH_CHROME_DRIVER;
import static java.lang.Thread.sleep;

/**
 * Created by Pomogalov on 10.10.2016.
 */
public class WebService {

    public int getBaseURL(String proxyAddressPort, TrackVisit trackVisit) throws InterruptedException {
        String newTitlePage = "";
        if (proxyAddressPort != null) {
            WebDriver driver = initDriver(proxyAddressPort);
            try {
                driver.get(trackVisit.getBaseURL());
                sleep(6000);
                newTitlePage = driver.getTitle();
            } catch (Exception e) {
                driver.close();
                driver.quit();
                return 3;
            }
            newTitlePage = driver.getTitle();
            driver.quit();
            if (trackVisit.getTitlePageBase().equals(newTitlePage)) {
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

    public int clickLinkURL(String proxyAddressPort, TrackVisit trackVisit) throws InterruptedException, NoSuchElementException {
        String newTitlePage = "";
        Random timeWaiting = new Random();
        int koefTimeWaiting;

        if (proxyAddressPort != null) {
            WebDriver driver = initDriver(proxyAddressPort);
            //WebDriver driver = initDriver();
            try {
                driver.get(trackVisit.getBaseURL());
                sleep(5000);
                newTitlePage = driver.getTitle();
            } catch (Exception e) {
                driver.close();
                driver.quit();
                return 3;
            }

            newTitlePage = driver.getTitle();
            if (trackVisit.getTitlePageBase().equals(newTitlePage)) {
                if (!trackVisit.getClickOneURL().equals("null")) {
                    try {
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("trackVisit.getClickOneURL() = " + trackVisit.getClickOneURL());
                        koefTimeWaiting = timeWaiting.nextInt(5);
                        sleep(3000 + koefTimeWaiting * 1000);
                        driver.findElement(By.linkText(trackVisit.getClickOneURL())).click();
                        koefTimeWaiting = timeWaiting.nextInt(5);
                        sleep(3000 + koefTimeWaiting * 1000);
                        newTitlePage = driver.getTitle();

                        System.out.println("newTitlePage = " + newTitlePage);
                        koefTimeWaiting = timeWaiting.nextInt(5);
                        sleep(2000 + koefTimeWaiting * 1000);
                    } catch (NoSuchElementException ex) {
                        System.out.println("============================================================");
                        System.out.println("trackVisit.getClickOneURL() = " + trackVisit.getClickOneURL());
                        driver.close();
                        driver.quit();
                        return 40;
                    } catch (WebDriverException e) {
                        driver.close();
                        driver.quit();
                        return 41;
                    }
                }
                if (!trackVisit.getClickTwoURL().equals("null")) {
                    try {
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("trackVisit.getClickTwoURL() = " + trackVisit.getClickTwoURL());
                        koefTimeWaiting = timeWaiting.nextInt(5);
                        sleep(3000 + koefTimeWaiting * 1000);
                        driver.findElement(By.linkText(trackVisit.getClickTwoURL())).click();
                        koefTimeWaiting = timeWaiting.nextInt(5);
                        sleep(3000 + koefTimeWaiting * 1000);
                        newTitlePage = driver.getTitle();

                        System.out.println("newTitlePage = " + newTitlePage);
                        koefTimeWaiting = timeWaiting.nextInt(5);
                        sleep(2000 + koefTimeWaiting * 1000);
                    } catch (NoSuchElementException ex) {
                        System.out.println("============================================================");
                        System.out.println("trackVisit.getClickTwoURL() = " + trackVisit.getClickTwoURL());
                        driver.close();
                        driver.quit();
                        return 50;
                    } catch (WebDriverException e) {
                        driver.close();
                        driver.quit();
                        return 51;
                    }
                }
                if (!trackVisit.getClickThreeURL().equals("null")) {
                    try {
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("getClickThreeURL()) = " + trackVisit.getClickThreeURL());
                        koefTimeWaiting = timeWaiting.nextInt(5);
                        sleep(3000 + koefTimeWaiting * 1000);
                        driver.findElement(By.linkText(trackVisit.getClickThreeURL())).click();
                        koefTimeWaiting = timeWaiting.nextInt(5);
                        sleep(3000 + koefTimeWaiting * 1000);
                        newTitlePage = driver.getTitle();
                        System.out.println("newTitlePage = " + newTitlePage);
                        koefTimeWaiting = timeWaiting.nextInt(5);
                        sleep(2000 + koefTimeWaiting * 1000);
                    } catch (NoSuchElementException ex) {
                        driver.close();
                        driver.quit();
                        return 60;
                    } catch (WebDriverException e) {
                        driver.close();
                        driver.quit();
                        return 61;
                    }
                }
                if (!trackVisit.getClickFourURL().equals("null")) {
                    try {
                        koefTimeWaiting = timeWaiting.nextInt(5);
                        sleep(3000 + koefTimeWaiting * 1000);
                        driver.findElement(By.linkText(trackVisit.getClickFourURL())).click();
                        newTitlePage = driver.getTitle();
                        System.out.println("newTitlePage = " + newTitlePage);
                        koefTimeWaiting = timeWaiting.nextInt(5);
                        sleep(2000 + koefTimeWaiting * 1000);
                    } catch (NoSuchElementException ex) {
                        driver.close();
                        driver.quit();
                        return 70;
                    } catch (WebDriverException e) {
                        driver.close();
                        driver.quit();
                        return 71;
                    }
                }
                driver.quit();
                return 1;
            } else {
                System.out.print("newTitlePage = " + newTitlePage);
                System.out.print("oldTitlePage = " + trackVisit.getTitlePageBase());
                driver.quit();
                return 2;
            }
        } else {
            return 0;
        }
    }

    public WebDriver initDriver(String PROXY) {
        System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);
        WebDriver driver;

        org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
        proxy.setHttpProxy(PROXY)
                .setFtpProxy(PROXY)
                .setSslProxy(PROXY);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, proxy);

        ChromeOptions option = new ChromeOptions();
        option.addArguments(getCurrentSizeWindow());
        capabilities.setCapability(ChromeOptions.CAPABILITY, option);

        try {
            driver = new ChromeDriver(capabilities);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

            return driver;
        } catch (NoClassDefFoundError error) {
            System.out.println(error);
        }
        return null;
    }

    public WebDriver initDriver() {
        System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions option = new ChromeOptions();
        option.addArguments();
        option.addArguments(getCurrentSizeWindow());
        capabilities.setCapability(ChromeOptions.CAPABILITY, option);
        WebDriver driver = new ChromeDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        return driver;
    }

    private boolean isElementPresent(By by, WebDriver driver) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
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
                sizeWindow = "--window-size=1280,1024";
                break;
            default:
                sizeWindow = "start-maximized";
                break;
        }
        return sizeWindow;
    }
}
