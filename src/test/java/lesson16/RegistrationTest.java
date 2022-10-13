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
import ui.model.User;
import ui.pages.MainPage;
import ui.utils.ConfigProvider;

import java.time.Duration;
import java.util.Random;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class RegistrationTest extends BaseTest {


    @Test
    public void registerWithValidData() {

        MainPage mainPage = new MainPage(driver);
        mainPage.open();

        MainPage.RegisterForm registerForm = mainPage.clickRegisterLink();
        wait.until(visibilityOfElementLocated(By.id("register-modal")));
        registerForm.fillRegisterForm(User.builder().buildRandomUser());

        Assert.assertEquals(driver.findElement(By.id("registration-message")).getAttribute("textContent"),"Registration and login successful.");
    }

}
