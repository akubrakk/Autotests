package page_object;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.ithillel.ui.BaseTest;
import ui.model.User;
import ui.pages.MainPage;
import ui.pages.MainPageConstants;

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
