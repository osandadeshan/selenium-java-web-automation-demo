package page.uicomponent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.BasePage;

/**
 * Project Name    : selenium-java-web-automation-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 24/7/23
 * Time            : 11:02 pm
 * Description     :
 **/

public class AlertComponent extends BasePage {
    public AlertComponent(WebDriver driver) {
        super(driver);
    }

    public Alert switchToAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }
}
