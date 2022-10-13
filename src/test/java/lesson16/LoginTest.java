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

public class LoginTest extends BaseTest {


    @Test
    public void loginAsExistedUser() {

        MainPage mainPage = new MainPage(driver);
        mainPage.open();

        MainPage.RegisterForm registerForm = mainPage.clickRegisterLink();
        wait.until(visibilityOfElementLocated(By.id("register-modal")));
        User user = User.builder()
                .buildRandomUser();
        registerForm.fillRegisterForm(user);
        wait.until(visibilityOfElementLocated(By.id("logout")));
        mainPage.clickLogoutLink();
        MainPage.LoginForm loginForm = mainPage.clickLoginLink();
        wait.until(visibilityOfElementLocated(By.id("Login")));
        loginForm.fillLoginForm(user);

//        driver.findElement(By.name("username")).sendKeys(username);
//        driver.findElement(By.id("password-modal")).sendKeys(password);
//        driver.findElement(By.xpath("//*[@id=\"login-modal\"]/div/div/div[2]/form/p/button")).click();
        Assert.assertEquals(driver.findElement(By.id("login-message")).getAttribute("textContent"),"Login successful.");

    }


    public String generateRandomString() {

        Random rand = new Random();

        String randString = rand.ints(48, 123)

                .filter(num -> (num < 58 || num > 64) && (num < 91 || num > 96))

                .limit(15)

                .mapToObj(c -> (char) c).collect(StringBuffer::new, StringBuffer::append, StringBuffer::append)

                .toString();
        return randString;
    }

}
