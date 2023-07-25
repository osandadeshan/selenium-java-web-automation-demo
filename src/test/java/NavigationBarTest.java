import common.constant.NavigationBarOption;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static common.constant.ApplicationConstants.APPLICATION_URL;
import static common.constant.NavigationBarOption.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Project Name    : selenium-java-web-automation-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 21/7/23
 * Time            : 10:26 pm
 * Description     :
 **/

public class NavigationBarTest extends BaseTest {
    @DataProvider(name = "navigationBarOptionsDataProvider")
    public Object[][] getNavigationBarOptions() {
        return new Object[][]{
                {HOME, APPLICATION_URL + "index.html"},
                {CONTACT, APPLICATION_URL + "#"},
                {ABOUT_US, APPLICATION_URL + "#"},
                {CART, APPLICATION_URL + "cart.html"},
                {LOG_IN, APPLICATION_URL + "#"},
                {SIGN_UP, APPLICATION_URL + "#"}
        };
    }

    @Test(description = "Verify that a user can see the Navigation Bar options",
            dataProvider = "navigationBarOptionsDataProvider")
    public void testNavigationBarOptionsVisibility(NavigationBarOption navigationBarOption, String url) {
        assertTrue(
                pages().getNavigationBar()
                        .getNavigationOptionElement(navigationBarOption)
                        .isDisplayed()
        );
    }

    @Test(description = "Verify that a user can go to the sub pages by clicking on Navigation Bar options",
            dataProvider = "navigationBarOptionsDataProvider")
    public void testNavigationBarOptionRoutines(NavigationBarOption navigationBarOption, String url) {
        assertEquals(
                pages().getNavigationBar()
                        .getNavigationOptionElement(navigationBarOption)
                        .getAttribute("href"),
                url
        );
    }
}
