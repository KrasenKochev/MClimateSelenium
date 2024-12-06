package core;

import org.openqa.selenium.WebDriver;

import website.pages.loginpage.LoginPage;
import website.pages.logoutpage.LogoutPage;
import website.pages.myhomepage.MyHomePage;


public class WebSite {

    public WebDriver _driver;
    public LoginPage loginPage;
    public LogoutPage logoutPage;
    public MyHomePage myHomePage;

    public WebSite(WebDriver driver) {
        this._driver = driver;
        this.loginPage = new LoginPage();
        this.logoutPage = new LogoutPage();
        this.myHomePage = new MyHomePage();

    }
}