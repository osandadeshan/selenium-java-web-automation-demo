package util.driver;

import org.openqa.selenium.WebDriver;

/**
 * Project Name    : selenium-java-web-automation-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 21/7/23
 * Time            : 10:26 pm
 * Description     :
 **/

public interface WebDriverService {
    void spinUpDriver();

    void closeDriver();

    WebDriver getDriver();
}
