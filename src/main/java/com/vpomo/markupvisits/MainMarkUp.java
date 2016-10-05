package com.vpomo.markupvisits;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static java.lang.Thread.sleep;
import static org.assertj.core.api.Fail.fail;

/**
 * Created by Pomogalov on 04.10.2016.
 */
public class MainMarkUp {
    private static WebDriver driver;
    private static String baseUrl;
    private boolean acceptNextAlert = true;
    private static StringBuffer verificationErrors = new StringBuffer();

    public static void main (String[] args) throws Exception {
        System.out.println("Right");
/*        initDriver();
        clickLinkApparat();
        downMarkUp();
*/
            // создаем новый экземпляр html unit driver
            // Обратите внимание, что последующий код не закладывается на
            // конкретную, имплементацию, а только на интерфейс WebDriver.
            WebDriver driver = new HtmlUnitDriver();

            // Открываем Google
            driver.get("http://www.google.ru");
            //driver.findElement(By.id("top-image")).click();

            // Находим по имени поле для ввода
            WebElement element = driver.findElement(By.name("q"));

            // Вводим ключевое слово для поиска
            element.sendKeys("гладиолус");

            // Отправляем форму в которой находится элемент element.
            // WebDriver сам найдет, в какой он форме.
            element.submit();

            // Выводим в консоль заголовок страницы
            //System.out.println("Page title is: " + driver.getTitle());
            System.out.println("Page Source is: " + driver.getPageSource());

    }

    public static void initDriver (){
        driver = new FirefoxDriver();
        baseUrl = "http://f1.amurobl.ru/reportglonass/";
        driver.navigate().to(baseUrl);
    }

    public static void clickLinkApparat() throws InterruptedException {
        sleep(5000);
        driver.findElement(By.id("top-image")).click();
        driver.findElement(By.linkText("Аппарат губернатора области и Правительства области")).click();
        sleep(5000);
        driver.findElement(By.id("top-image")).click();
        driver.findElement(By.linkText("Сковородинский район")).click();
        sleep(5000);
    }

    public static void downMarkUp() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
