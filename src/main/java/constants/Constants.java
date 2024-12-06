package constants;

import java.util.Random;

import static websitedata.factories.UserAndBuildingFactory.faker;

public class Constants {
    static Random ran = new Random();
    public static final String EMAIL_ADDRESS_USERNAME = "interview.qa@mclimate.eu";
    public static final String PASSWORD = "interviewQA2024";
    public static final String BUILDING_NAME = faker.name().title();
    public static final String ADDRESS_NAME = faker.address().cityName();
    public static final String TIMEZONE_NAME = "Sofia";
    public static final String NUMBER_OF_SPACES = "2";
    public static final String NUMBER_OF_ROOMS = "2";
    public static final String NAME_OF_SPACES = "offices";
    public static final String NAME_OF_ROOMS= "Rooms";
    public static final String NAME_OF_FLOORS="Floors";

    public static final String INVALID_EMAIL = faker.internet().emailAddress();
    public static final String INVALID_PASSWORD = faker.internet().password();

    public static final String ERROR_MESSAGE_LOGOUT_BUTTON = "Logout button is not displayed";
    public static final String ERROR_MESSAGE_CONFIRMATION_EMAIL = "Your email address is not correct";
    public static final String THE_WEB_DRIVER_BROWSER_INSTANCE_WAS_NOT_INITIALIZED_YOU_SHOULD_FIRST_CALL_THE_START_METHOD = "The WebDriver browser instance was not initialized. You should first call the start() method.";
    public static final String UNSUPPORTED_BROWSER_TYPE = "Unsupported browser type: ";
    public static final String EXPECTED_MESSAGE_BLANK_CREDENTIALS_USER_EMAIL = "Invalid username and password combination";
    public static final String EXPECTED_MESSAGE_BLANK_CREDENTIALS_PASSWORD = "Invalid Password";
    public static final String EXPECTED_MESSAGE_WRONG_USERNAME_EMAIL_AND_PASSWORD = "Invalid username and password combination";

    public static final String ERROR_MESSAGE_BUILDING_NOT_FOUND = "Newly Created Building was not found";
    public static final String ERROR_MESSAGE_NUMBER_OF_SPACES_NOT_CORRECT = "Newly created building does not have requested number of spaces";
    public static final String ERROR_MESSAGE_NUMBER_OF_ROOMS_NOT_CORRECT = "Newly created building does not have requested number of rooms";
    public static final String ERROR_MESSAGE_NUMBER_OF_FLOOR_NOT_CORRECT = "Newly created building should have no floors";
    public static final String ERROR_MESSAGE_BUILDING_FOUND = "Newly created building was found, but should have been deleted";
    public static final String ERROR_MESSAGE_URL = "Expected page was not navigated.";

}