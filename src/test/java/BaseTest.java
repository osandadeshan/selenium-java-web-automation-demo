import com.maxsoft.testngtestresultsanalyzer.DriverHolder;
import com.maxsoft.testngtestresultsanalyzer.TestAnalyzeReportListener;
import common.PageProvider;
import common.UiComponentProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import util.driver.WebDriverFactory;
import util.driver.WebDriverService;

import static common.constant.ApplicationConstants.APPLICATION_URL;
import static common.constant.CommonConstants.*;
import static util.driver.WebDriverHolder.getDriver;
import static util.driver.WebDriverHolder.setDriver;

/**
 * Project Name    : selenium-java-web-automation-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 21/7/23
 * Time            : 10:26 pm
 * Description     :
 **/

@Listeners(TestAnalyzeReportListener.class)
public class BaseTest {
    private final WebDriverService driverService = new WebDriverFactory().getDriverService();
    private final Logger logger = LogManager.getLogger();

    @BeforeSuite
    public void oneTimeSetup() {
        logger.debug("Test execution browser: {}", BROWSER_NAME);
        logger.debug("Test execution environment: {}", EXECUTION_ENV_NAME);
    }

    @BeforeMethod
    public void openBrowser() {
        driverService.spinUpDriver();
        setDriver(driverService.getDriver());
        DriverHolder.setDriver(getDriver());    // Setting the driver for the html-reporter library
        getDriver().manage().timeouts().implicitlyWait(IMPLICIT_WAIT_IN_SECONDS);
        getDriver().manage().window().maximize();
        getDriver().get(APPLICATION_URL);
    }

    public PageProvider pages() {
        return new PageProvider(getDriver());
    }

    public UiComponentProvider uiComponents() {
        return new UiComponentProvider(getDriver());
    }

    @AfterMethod
    public void after() {
        driverService.closeDriver();
    }
}
