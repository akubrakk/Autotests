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
import ui.pages.MainPageConstants;
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

        User user = User.builder().buildRandomUser();
        registerForm.fillRegisterForm(user);
        mainPage.clickLogoutLink();

        MainPage.LoginForm loginForm = mainPage.clickLoginLink();
        loginForm.fillLoginForm(user);

        Assert.assertEquals(mainPage.getLoginLabel(), MainPageConstants.LOGIN_SUCCESSFUL);

    }


}
