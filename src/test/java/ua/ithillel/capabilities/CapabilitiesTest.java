package ua.ithillel.capabilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.browser.WebDriverFactory;
import ui.utils.ConfigProvider;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class CapabilitiesTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void beforeTest() {

     ChromeOptions options = new ChromeOptions();
     options.setCapability("acceptInsecureCerts", true);

     driver = new ChromeDriver(options);

        options.asMap().forEach((k,v) -> System.out.println(k + "-" +v));

     wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }

    @Test
    public void test() {
        driver.get(ConfigProvider.BASE_URL);
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElements(By.name("btnK")).get(1).click();
        wait.until(titleIs("webdriver - Поиск в Google"));
        Assert.assertEquals(driver.getTitle(),"webdriver - Поиск в Google");
    }

    @AfterTest
    public void stop() {
        driver.close();
        driver.quit();
    }

}
