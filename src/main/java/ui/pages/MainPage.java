package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.model.User;
import ui.utils.ConfigProvider;
import ui.utils.WaitUtils;


public class MainPage extends Page{

    private static final Logger LOGGER = LoggerFactory.getLogger(MainPage.class);

    private By registerLink = By.id("register");
    private By loginLink = By.id("login");
    private By loginModal = By.id("Login");
    private By logoutLink = By.id("logout");
    private By loginMessage = By.id("login-message");
    private By registerModal = By.id("register-modal");
    public By loggedUserLink = By.xpath("//li[@id='howdy']/a");


    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Main Page")
    @Override
    public void open() {
        LOGGER.info("Attempt to open Main page");
        driver.get(ConfigProvider.SITE_URL);
        ensureOpen();
        LOGGER.info("Main page is open");
    }

    @Override
    public void ensureOpen() {
        WaitUtils.waitUntilElementIsVisible(driver,registerLink);
    }

    @Step("Click on register link")
    public RegisterForm clickRegisterLink(){
        driver.findElement(registerLink).click();
        WaitUtils.waitUntilElementIsVisible(driver, registerModal);
        LOGGER.info("Click on register link");

        return new RegisterForm();
    }
    @Step("Click on login link")
    public LoginForm clickLoginLink(){
        driver.findElement(loginLink).click();
        LOGGER.info("Click on login link");
        WaitUtils.waitUntilElementIsVisible(driver, loginModal);
        return new LoginForm();
    }
    public boolean isUserLoggedIn() {
        driver.findElement(logoutLink);
        LOGGER.info("User is logged in");
        return true;
    }
    @Step("Click on logout link")
    public LoginForm clickLogoutLink(){
        driver.findElement(logoutLink).click();
        LOGGER.info("Click on logout link");
        return new LoginForm();
    }


    public class RegisterForm{
        private By username = By.id("register-username-modal");
        private By firstname = By.id("register-first-modal");
        private By lastname = By.id("register-last-modal");
        private By email = By.id("register-email-modal");
        private By password = By.id("register-password-modal");
        private By registerButton = By.xpath("//*[@id=\"register-modal\"]/div/div/div[2]/form/p/button");

        @Step("Fill the register form with data: username - '{user.username}',firstname - '{user.firstname}', lastname - '{user.lastname}', email- '{user.email}', password '{user.password}'")
        public void fillRegisterForm(User user){
            driver.findElement(username).sendKeys(user.getUsername());
            LOGGER.info("Fill input 'username' with value: {}",user.getUsername());
            driver.findElement(firstname).sendKeys(user.getFirstname());
            LOGGER.info("Fill input 'firstname' with value: {}",user.getFirstname());
            driver.findElement(lastname).sendKeys(user.getLastname());
            LOGGER.info("Fill input 'lastname' with value: {}",user.getLastname());
            driver.findElement(email).sendKeys(user.getEmail());
            LOGGER.info("Fill input 'email' with value: {}",user.getEmail());
            driver.findElement(password).sendKeys(user.getPassword());
            LOGGER.info("Fill input 'password' with value: {}",user.getPassword());
            driver.findElement(registerButton).click();
            LOGGER.info("Click on register button");
            WaitUtils.waitUntilElementIsVisible(driver, logoutLink);
        }

    }
    public class LoginForm{
        private By username = By.name("username");
        private By password = By.id("password-modal");
        private By loginButton = By.xpath("//*[@id=\"login-modal\"]/div/div/div[2]/form/p/button");

        public void fillLoginForm(User user){

            driver.findElement(username).sendKeys(user.getUsername());
            LOGGER.info("Fill input 'username' with value: {}",user.getUsername());
            driver.findElement(password).sendKeys(user.getPassword());
            LOGGER.info("Fill input 'password' with value: {}",user.getPassword());
            driver.findElement(loginButton).click();
            LOGGER.info("Click on Login button");
        }

    }
}