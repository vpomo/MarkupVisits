package com.vpomo.markupvisits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * Created by Pomogalov on 05.10.2016.
 */
public class GoogleSuggest {
    private static String baseUrl;

    public static void main(String[] args) throws Exception {
        // Драйвер Firefox поддерживает javascript
        String proxyAddressPort;
        String PROXY = "104.237.228.56:1080";
        System.setProperty("webdriver.chrome.driver", "D:/Java/WebDriver/chromedriver.exe");

        org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
        proxy.setHttpProxy(PROXY)
                .setFtpProxy(PROXY)
                .setSslProxy(PROXY)
                .setSocksProxy(PROXY);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, proxy);

        ChromeOptions option = new ChromeOptions();
        option.addArguments("start-maximized");
        capabilities.setCapability(ChromeOptions.CAPABILITY, option);

        WebDriver driver = new ChromeDriver(capabilities);

/*        proxyAddressPort = "104.237.228.56:1080"; 92.46.122.98:3128
        System.out.print("proxy = " + proxyAddressPort);
        ChromeOptions option = new ChromeOptions();
        option.addArguments("start-maximized");
        option.addArguments("--no-sandbox");
        option.addArguments("--proxy-server=socks4://" + proxyAddressPort);
*/
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        baseUrl = "http://speed-tester.info/check_ip.php";

        try {
            driver.get(baseUrl);
            sleep(3000);
            driver.quit();
        } catch (Exception e) {
            driver.quit();
        }
    }
}

