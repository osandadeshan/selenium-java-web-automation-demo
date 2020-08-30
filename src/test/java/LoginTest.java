import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

/**
 * Project Name    : selenium-page-object-model-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 8/30/2020
 * Time            : 9:21 AM
 * Description     :
 **/

/**
 * This test case will login in http://demo.guru99.com/V4/
 * Verify login page title as guru99 bank
 * Login to application
 * Verify the home page using Dashboard message
 **/

public class LoginTest {

    WebDriver driver;

    LoginPage loginPage;
    HomePage homePage;

    @BeforeSuite
    public void initializeDriver(){
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
    }

    @BeforeMethod
    public void before(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/V4/");
    }

    @Test()
    public void testValidLogin(){
        loginPage = new LoginPage(driver); //Create Login Page object

        String loginPageTitle = loginPage.getLoginPageTitle();
        Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));    //Verify login page title

        loginPage.login("mgr123", "mgr!23"); //login to application

        homePage = new HomePage(driver);   // Go the Home page
        Assert.assertTrue(homePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123")); //Verify home page
    }

    @AfterMethod
    public void after(){
        driver.quit();
    }

}
