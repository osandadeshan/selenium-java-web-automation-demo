package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Project Name    : selenium-page-object-model-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 8/30/2020
 * Time            : 9:19 AM
 * Description     :
 **/

public class HomePage {

    WebDriver driver;

    By usernameLabel = By.xpath("//table//tr[@class='heading3']");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public String getHomePageDashboardUserName(){
        return driver.findElement(usernameLabel).getText();
    }

}
