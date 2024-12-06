package website.pages.loginpage;

import core.basemap.BaseMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPageMap extends BaseMap {
    public WebElement emailAddressInput() {
        return waitAndFindElement(By.xpath("input-email"));
    }

    public WebElement usernameEmailAddressInputField() {
        return waitAndFindElement(By.xpath("// input [@ type = \"email\"]"));
    }
    public WebElement passwordInputField() {
        return waitAndFindElement(By.xpath("// input [@ data-testid=\"password\"]"));
    }

    public WebElement loginButton() {
        return waitAndFindElement(By.xpath("// button [@type=\"submit\"]"));
    }

    public WebElement forgotPasswordButton() {
        return waitAndFindElement(By.xpath("//a[text()= \"Forgot password?\" ]"));
    }

    public WebElement warningMessageBlankUserEmail() {
        return waitAndFindElement(By.xpath("//p [@class=\"errorMsg\" and text()= \"Invalid Email\"]"));
    }
    public WebElement warningMessageBlankPassword(){
        return waitAndFindElement(By.xpath("//p [@class=\"errorMsg\" and text()= \"Invalid Password\"]"));
    }
    public WebElement warningMessageInvalidUserEmailOrPassword(){
        return waitAndFindElement(By.xpath("//div[@class=\"alert alert-danger fade show\" and text() = \"Invalid username and password combination\"]"));
    }

}