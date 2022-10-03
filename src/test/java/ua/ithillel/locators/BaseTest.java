package ua.ithillel.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.browser.WebDriverFactory;
import ui.utils.ConfigProvider;

import java.time.Duration;
import java.util.List;


import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class BaseTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void beforeTest() {

        driver = WebDriverFactory.getDriver();
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
