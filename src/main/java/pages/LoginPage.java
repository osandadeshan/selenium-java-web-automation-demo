package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Project Name    : selenium-page-object-model-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 8/30/2020
 * Time            : 9:14 AM
 * Description     :
 **/

public class LoginPage {

    WebDriver driver;

    By usernameTextBox = By.name("uid");
    By passwordTextBox = By.name("password");
    By titleLabel =By.className("barone");
    By loginButton = By.name("btnLogin");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUserName(String strUserName){
        driver.findElement(usernameTextBox).sendKeys(strUserName);
    }

    public void setPassword(String strPassword){
        driver.findElement(passwordTextBox).sendKeys(strPassword);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public String getLoginPageTitle(){
        return driver.findElement(titleLabel).getText();
    }

    public void login(String strUserName,String strPasword){
        this.setUserName(strUserName); //Fill user name
        this.setPassword(strPasword); //Fill password
        this.clickLoginButton(); //Click Login button
    }

}