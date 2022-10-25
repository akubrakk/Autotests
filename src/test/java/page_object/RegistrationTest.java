package page_object;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ui.model.User;
import ui.pages.MainPage;
import ui.utils.WaitUtils;


public class RegistrationTest extends BaseTest {


    @Test
    public void registerWithValidData() {

        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.open();

        MainPage.RegisterForm registerForm = mainPage.clickRegisterLink();
        WaitUtils.waitUntilElementIsVisible(getWebDriver(), By.id("register-modal"));

        registerForm.fillRegisterForm(User.builder().buildRandomUser());

        Assertions.assertThat(mainPage.isUserLoggedIn()).isTrue();
    }

}
