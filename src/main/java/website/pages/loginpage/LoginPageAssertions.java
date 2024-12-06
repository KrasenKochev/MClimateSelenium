package website.pages.loginpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;

import static constants.Constants.*;

public class LoginPageAssertions extends BaseAssertions<LoginPageMap> {

    public void assertErrorMessageBlankUserEmail() {
        boolean expectedResult = elementsT().warningMessageBlankUserEmail().isDisplayed();
        var actualResult = String.valueOf(true);
        var wrongCredentialsMessage = formatMessage(EXPECTED_MESSAGE_BLANK_CREDENTIALS_USER_EMAIL, String.valueOf(expectedResult), actualResult);
        Assertions.assertTrue(expectedResult, wrongCredentialsMessage);
    }

    public void assertErrorMessageBlankCredentialsPassword() {
        boolean expectedResult = elementsT().warningMessageBlankPassword().isDisplayed();
        var actualResult = String.valueOf(true);
        var wrongCredentialsMessage = formatMessage(EXPECTED_MESSAGE_BLANK_CREDENTIALS_PASSWORD, String.valueOf(expectedResult), actualResult);
        Assertions.assertTrue(expectedResult, wrongCredentialsMessage);
    }

    public void WebElementWarningMessageInvalidUserEmailOrPassword() {
        boolean expectedResult = elementsT().warningMessageInvalidUserEmailOrPassword().isDisplayed();
        var actualResult = String.valueOf(true);
        var wrongCredentialsMessage = formatMessage(EXPECTED_MESSAGE_WRONG_USERNAME_EMAIL_AND_PASSWORD, String.valueOf(expectedResult), actualResult);
        Assertions.assertTrue(expectedResult, wrongCredentialsMessage);
    }

}