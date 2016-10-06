package com.vpomo.markupvisits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Pomogalov on 05.10.2016.
 */
public class GoogleSuggest {
    public static void main(String[] args) throws Exception {
        // Драйвер Firefox поддерживает javascript
        System.setProperty("webdriver.chrome.driver", "D:/Java/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        // Открываем страничку Google
        driver.get("http://www.google.ru");

        WebElement query = driver.findElement(By.name("q"));
        // Вводим ключевое слово
        query.sendKeys("гладиолус");

        // Получаем список подсказок
        List<WebElement> allSuggestions = driver.findElements(By.xpath("//td[@class='gssb_a gbqfsf']"));
        // А затем выводим их в консоль
        for (WebElement suggestion : allSuggestions) {
            System.out.println(suggestion.getText());
        }
        if (driver != null) {
            driver.quit();
        }
    }
}

