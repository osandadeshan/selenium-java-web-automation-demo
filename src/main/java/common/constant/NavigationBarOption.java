package common.constant;

/**
 * Project Name    : selenium-java-web-automation-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 21/7/23
 * Time            : 10:28 pm
 * Description     :
 **/

public enum NavigationBarOption {
    HOME("Home"),
    CONTACT("Contact"),
    ABOUT_US("About us"),
    CART("Cart"),
    LOG_IN("Log in"),
    SIGN_UP("Sign up");

    private final String navBarItemName;

    NavigationBarOption(String navBarItemName) {
        this.navBarItemName = navBarItemName;
    }

    public String getName() {
        return navBarItemName;
    }
}
