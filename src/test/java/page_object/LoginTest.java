package page_object;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import ui.model.User;
import ui.pages.MainPage;
import ui.utils.WaitUtils;

public class LoginTest extends BaseTest {


    @Test(description = "Login as existed user")
    public void loginAsExistedUser() {
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.open();

        MainPage.RegisterForm registerForm = mainPage.clickRegisterLink();

        User user = User.builder().buildRandomUser();
        registerForm.fillRegisterForm(user);
        mainPage.clickLogoutLink();

        MainPage.LoginForm loginForm = mainPage.clickLoginLink();
        loginForm.fillLoginForm(user);
        WaitUtils.waitUntilElementIsVisible(getWebDriver(), mainPage.loggedUserLink);

        Assertions.assertThat(getWebDriver().findElement(mainPage.loggedUserLink).getAttribute("textContent"))
                .isEqualTo("Logged in as %s %s", user.getFirstname(), user.getLastname());

    }

}
