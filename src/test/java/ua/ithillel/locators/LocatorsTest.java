package ua.ithillel.locators;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.ithillel.ui.BaseTest;
import ui.utils.ConfigProvider;


import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class LocatorsTest extends BaseTest {


    @Test
    public void test() {
        driver.get(ConfigProvider.BASE_URL);
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElements(By.name("btnK")).get(1).click();
        wait.until(titleIs("webdriver - Поиск в Google"));
        Assert.assertEquals(driver.getTitle(),"webdriver - Поиск в Google");
    }



}
