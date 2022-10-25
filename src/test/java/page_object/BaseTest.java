package page_object;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ui.browser.WebDriverFactory;
import ui.constants.TestConstants;

public class BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);
    public static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    @BeforeMethod(description = "creating WebDriver")
    public void beforeMethod(ITestContext iTestContext) {
        WebDriver driver = new WebDriverFactory().getDriver();
        setWebDriver(driver);
        setDriverToContext(iTestContext, driver);
    }

    @AfterMethod(description = "closing WebDriver")
    public void afterMethod(ITestResult result) {
//        if (!result.isSuccess()) {
//            File screenshot = ScreenshotUtils.getScreenshot(getWebDriver());
//            try {
//                Allure.getLifecycle().addAttachment("screenshot", null, null, Files.newInputStream(screenshot.toPath()));
//            } catch (IOException e) {
//                LOGGER.warn("Could not take screenshot");
//            }
//        }
        getWebDriver().quit();
    }

    private void setWebDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    public WebDriver getWebDriver() {
        return driverThreadLocal.get();
    }

    public void setDriverToContext(ITestContext iTestContext, WebDriver driver) {
        iTestContext.setAttribute(TestConstants.WEB_DRIVER, driver);
    }
}
