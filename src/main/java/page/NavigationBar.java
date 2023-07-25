package page;

import common.constant.NavigationBarOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Project Name    : selenium-java-web-automation-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 21/7/23
 * Time            : 10:26 pm
 * Description     :
 **/

public class NavigationBar extends BasePage {
    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public WebElement getNavigationOptionElement(NavigationBarOption navigationBarOption) {
        return getElement(
                By.xpath(
                        "//a[@class='nav-link'][contains(.,'" + navigationBarOption.getName() + "')]"
                )
        );
    }

    public void clickOnNavOption(NavigationBarOption navigationBarOption) {
        getNavigationOptionElement(navigationBarOption).click();
    }

    public String getGreetingMessage() {
        return getText(By.id("nameofuser"));
    }
}
