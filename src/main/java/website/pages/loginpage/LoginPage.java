package website.pages.loginpage;

import core.basepage.WebPage;

import static urls.Urls.LOGIN_PAGE;

public class LoginPage extends WebPage<LoginPageMap, LoginPageAssertions> {

    @Override
    protected String Url() {
        return LOGIN_PAGE;
    }

    public void loginUser(PersonalInformation user) {
        elements().typeText(elements().usernameEmailAddressInputField(), user.email);
        elements().typeText(elements().passwordInputField(), user.password);
        elements().loginButton().click();
    }
}