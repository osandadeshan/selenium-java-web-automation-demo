package common;

import org.openqa.selenium.WebDriver;
import page.BasePage;
import page.LoginPage;
import page.NavigationBar;

/**
 * Project Name    : selenium-java-web-automation-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 21/7/23
 * Time            : 10:28 pm
 * Description     :
 **/

public class PageProvider extends BasePage {
    public PageProvider(WebDriver driver) {
        super(driver);
    }

    public NavigationBar getNavigationBar() {
        return new NavigationBar(driver);
    }

    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }
}
