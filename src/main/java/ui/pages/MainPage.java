package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.model.User;
import ui.utils.ConfigProvider;
import ui.utils.WaitUtils;

public class MainPage extends Page{

    private By registerLink = By.id("register");
    private By loginLink = By.id("login");
    private By loginModal = By.id("Login");
    private By logoutLink = By.id("logout");
    private By loginMessage = By.id("login-message");
    private By registerModal = By.id("register-modal");


    public MainPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public void open() {
        driver.get(ConfigProvider.SITE_URL);
        ensureOpen();
    }

    @Override
    public void ensureOpen() {
        WaitUtils.waitUntilElementIsVisible(driver,registerLink);
    }

    public RegisterForm clickRegisterLink(){
        driver.findElement(registerLink).click();
        WaitUtils.waitUntilElementIsVisible(driver, registerModal);

      return new RegisterForm();
    }

    public LoginForm clickLoginLink(){
        driver.findElement(loginLink).click();
        WaitUtils.waitUntilElementIsVisible(driver, loginModal);
        return new LoginForm();
    }

    public LoginForm clickLogoutLink(){
        driver.findElement(logoutLink).click();
        return new LoginForm();
    }
    public String getLoginLabel() {
        return driver.findElement(loginMessage).getAttribute("textContent");
    }


    public class RegisterForm{
        private By username = By.id("register-username-modal");
        private By firstname = By.id("register-first-modal");
        private By lastname = By.id("register-last-modal");
        private By email = By.id("register-email-modal");
        private By password = By.id("register-password-modal");
        private By registerButton = By.xpath("//*[@id=\"register-modal\"]/div/div/div[2]/form/p/button");

        public void fillRegisterForm(User user){

            driver.findElement(username).sendKeys(user.getUsername());
            driver.findElement(firstname).sendKeys(user.getFirstname());
            driver.findElement(lastname).sendKeys(user.getLastname());
            driver.findElement(email).sendKeys(user.getEmail());
            driver.findElement(password).sendKeys(user.getPassword());
            driver.findElement(registerButton).click();
            WaitUtils.waitUntilElementIsVisible(driver, logoutLink);
        }

        }
    public class LoginForm{
        private By username = By.name("username");
        private By password = By.id("password-modal");
        private By loginButton = By.xpath("//*[@id=\"login-modal\"]/div/div/div[2]/form/p/button");

        public void fillLoginForm(User user){

            driver.findElement(username).sendKeys(user.getUsername());
            driver.findElement(password).sendKeys(user.getPassword());
            driver.findElement(loginButton).click();
        }

    }
}
