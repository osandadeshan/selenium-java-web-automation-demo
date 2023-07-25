package common.constant;

import static util.Reader.getEnvironmentConfig;

/**
 * Project Name    : selenium-java-web-automation-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 24/7/23
 * Time            : 4:15 pm
 * Description     :
 **/

public class ApplicationConstants {
    public static final String APPLICATION_URL = getEnvironmentConfig("application_url");
    public static final String LOGIN_USERNAME = getEnvironmentConfig("username");
    public static final String LOGIN_PASSWORD = getEnvironmentConfig("password");
}
