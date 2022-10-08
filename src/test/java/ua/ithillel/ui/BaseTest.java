package ua.ithillel.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.browser.WebDriverFactory;
import ui.utils.ConfigProvider;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeTest
    public void start() {

        driver = new WebDriverFactory().getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterTest
    public void stop() {
        driver.close();
        driver.quit();
    }

}
