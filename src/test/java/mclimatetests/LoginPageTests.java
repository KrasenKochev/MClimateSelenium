package mclimatetests;

import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import website.pages.loginpage.PersonalInformation;
import websitedata.factories.UserAndBuildingFactory;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;

public class LoginPageTests extends BaseTest {

    PersonalInformation loginUser;
    PersonalInformation invalidEmail;
    PersonalInformation invalidPassword;
    PersonalInformation emptyCredentials;
    PersonalInformation emptyEmail;
    PersonalInformation emptyPassword;

    @BeforeEach
    public void setup() {
        loginUser = UserAndBuildingFactory.loginUser(EMAIL_ADDRESS_USERNAME, PASSWORD);
        invalidEmail = UserAndBuildingFactory.loginUser(INVALID_EMAIL, PASSWORD);
        invalidPassword = UserAndBuildingFactory.loginUser(EMAIL_ADDRESS_USERNAME, INVALID_PASSWORD);
        emptyCredentials = UserAndBuildingFactory.loginUser("", "");
        emptyEmail = UserAndBuildingFactory.loginUser(" ", PASSWORD);
        emptyPassword = UserAndBuildingFactory.loginUser(EMAIL_ADDRESS_USERNAME, " ");
    }


    /*
    Assertions for different Log in scenarios
     */
    @Test
    public void loginIntoSystem_when_validEmailAddressAndPasswordProvided_and_userSuccessfulAuthorized() {
        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);

        webSite.loginPage.assertUrlPage();

        webSite.logoutPage.assertions().assertAccountSuccessfullyDisplayed();
        webSite.logoutPage.clickOnMyAccount();

        webSite.logoutPage.assertions().assertLogoutButtonDisplayed();
        webSite.logoutPage.logoutUser();
    }

    @Test
    public void loginIntoSystem_when_tryToLoginWithInvalidEmailAddress_and_errorMessageDisplayed() {
        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(invalidEmail);

        webSite.loginPage.assertUrlPage();
        webSite.loginPage.assertions().WebElementWarningMessageInvalidUserEmailOrPassword();
    }

    @Test
    public void loginIntoSystem_when_tryToLoginWithInvalidPassword_and_errorMessageDisplayed() {
        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(invalidPassword);

        webSite.loginPage.assertUrlPage();
        webSite.loginPage.assertions().WebElementWarningMessageInvalidUserEmailOrPassword();
    }

    @Test
    public void loginIntoSystem_when_tryToLoginWithEmptyCredentials_and_errorMessageDisplayed() {
        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(emptyCredentials);

        webSite.loginPage.assertUrlPage();
        webSite.loginPage.assertions().assertErrorMessageBlankUserEmail();
        webSite.loginPage.assertions().assertErrorMessageBlankCredentialsPassword();
    }

    @Test
    public void loginIntoSystem_when_tryToLoginWithEmptyEmailAddressField_and_errorMessageDisplayed() {
        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(emptyEmail);

        webSite.loginPage.assertUrlPage();
        webSite.loginPage.assertions().assertErrorMessageBlankUserEmail();
    }

    @Test
    public void loginIntoSystem_when_tryToLoginWithEmptyPasswordField_and_errorMessageDisplayed() {
        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(emptyPassword);

        webSite.loginPage.assertUrlPage();
        webSite.loginPage.assertions().assertErrorMessageBlankCredentialsPassword();
    }
}