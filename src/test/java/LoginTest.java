import org.testng.annotations.Test;

import static common.constant.ApplicationConstants.LOGIN_PASSWORD;
import static common.constant.ApplicationConstants.LOGIN_USERNAME;
import static common.constant.NavigationBarOption.LOG_IN;
import static org.testng.Assert.assertEquals;

/**
 * Project Name    : selenium-java-web-automation-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 21/7/23
 * Time            : 10:26 pm
 * Description     :
 **/

public class LoginTest extends BaseTest {
    @Test(description = "Verify that a user can login to the application using the correct credentials")
    public void testValidLogin() {
        pages().getNavigationBar()
                .clickOnNavOption(LOG_IN);
        pages().getLoginPage()
                .login(LOGIN_USERNAME, LOGIN_PASSWORD);
        assertEquals(
                pages().getNavigationBar().getGreetingMessage(),
                "Welcome " + LOGIN_USERNAME
        );
    }

    @Test(description = "Verify that a user cannot login to the application using incorrect credentials")
    public void testInvalidLogin() {
        pages().getNavigationBar()
                .clickOnNavOption(LOG_IN);
        pages().getLoginPage()
                .login(LOGIN_USERNAME, "abc123");
        assertEquals(
                uiComponents().getAlertComponent().switchToAlert().getText(),
                "Wrong password."
        );
    }
}
