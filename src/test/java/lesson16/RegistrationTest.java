package lesson16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ua.ithillel.ui.BaseTest;
import ui.browser.WebDriverFactory;
import ui.utils.ConfigProvider;

import java.time.Duration;
import java.util.Random;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class RegistrationTest extends BaseTest {

    @Test
    public void registerWithValidData() {
        driver.get(ConfigProvider.SITE_URL);
        driver.findElement(By.id("register")).click();
        wait.until(visibilityOfElementLocated(By.id("register-modal")));
        driver.findElement(By.id("register-username-modal")).sendKeys("username" + randomString);
        driver.findElement(By.id("register-first-modal")).sendKeys("firstname" + randomString);
        driver.findElement(By.id("register-last-modal")).sendKeys("lastname" + randomString);
        driver.findElement(By.id("register-email-modal")).sendKeys("testemail@" + randomString + "test.com");
        driver.findElement(By.id("register-password-modal")).sendKeys("password" + randomString);
        driver.findElement(By.xpath("//*[@id=\"register-modal\"]/div/div/div[2]/form/p/button")).click();
        Assert.assertEquals(driver.findElement(By.id("registration-message")).getAttribute("textContent"),"Registration and login successful.");
    }

    Random rand = new Random();

    String randomString = rand.ints(48, 123)

            .filter(num -> (num<58 || num>64) && (num<91 || num>96))

            .limit(15)

            .mapToObj(c -> (char)c).collect(StringBuffer::new, StringBuffer::append, StringBuffer::append)

            .toString();


}
