package page_object;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.ithillel.ui.BaseTest;
import ui.model.User;
import ui.pages.MainPage;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class RegistrationTest extends BaseTest {


    @Test
    public void registerWithValidData() {

        MainPage mainPage = new MainPage(driver);
        mainPage.open();

        MainPage.RegisterForm registerForm = mainPage.clickRegisterLink();
        wait.until(visibilityOfElementLocated(By.id("register-modal")));
        registerForm.fillRegisterForm(User.builder().buildRandomUser());

        Assertions.assertThat(mainPage.isUserLoggedIn()).isTrue();
    }

}
