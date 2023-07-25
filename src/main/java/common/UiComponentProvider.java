package common;

import org.openqa.selenium.WebDriver;
import page.BasePage;
import page.uicomponent.AlertComponent;

/**
 * Project Name    : selenium-java-web-automation-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 24/7/23
 * Time            : 11:05 pm
 * Description     :
 **/

public class UiComponentProvider extends BasePage {
    public UiComponentProvider(WebDriver driver) {
        super(driver);
    }

    public AlertComponent getAlertComponent() {
        return new AlertComponent(driver);
    }
}
