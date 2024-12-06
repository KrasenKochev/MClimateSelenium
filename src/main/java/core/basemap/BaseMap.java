package core.basemap;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import core.driver.Driver;

import java.time.Duration;

public abstract class BaseMap {
    public static final int WAIT_FOR_TIMEOUT = 10;
    protected WebDriver browser;
    protected Actions actions;
    protected WebDriverWait browserWait;

    /*
    This class contains different web element commands(such as click on a locator),  that will be used with locators
     */

    public BaseMap() {
        browser = Driver.getBrowser();
        browserWait = Driver.getBrowserWait();
    }

    protected WebElement waitAndFindElement(By locator) {
        browserWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return browser.findElement(locator);
    }

    protected WebElement clickElement(By locator){
        return browser.findElement(locator);

    }
    protected WebElement onlyFindElement(By locator){
        return browser.findElement(locator);
    }


    public void waitUntilPageLoadsCompletely() {
        JavascriptExecutor js = (JavascriptExecutor) browser;
        browserWait.until(wd -> js.executeScript("return document.readyState").toString().equals("complete"));
    }

    public void scrollToVisibleJS(WebElement element) {
        try {
            ((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (ElementNotInteractableException ex) {
        }
    }

    public void clickButtonJS(WebElement element) {
        try {
            ((JavascriptExecutor) browser).executeScript("arguments[0].click();", element);
        } catch (ElementNotInteractableException ex) {
        }
    }


    public void clickDropDown(WebElement element,String text,WebElement element2) {
        try {
            ((JavascriptExecutor) browser).executeScript("arguments[0].click();", element2);
            element.sendKeys(text);
            element.sendKeys(Keys.ENTER);

        } catch (ElementNotInteractableException ex) {
        }

    }
    /*
    This method was needed specifically for interaction for the timezone selection
     */
    public void selectFromDropDown(String text) {
        try {
            WebElement dropdown = browser.findElement(By.xpath("//div[@class=\"select2-selection__control css-13cymwt-control\"]"));
            dropdown.click();
            WebElement inputField = browser.findElement(By.xpath("//input[contains(@id, 'react-select-')]"));

            inputField.sendKeys(text);
            inputField.sendKeys(Keys.ENTER);

        } catch (ElementNotInteractableException ex) {
        }
    }

    public void typeText(WebElement element,String text){
        element.click();
        element.sendKeys(text);
    }

    public void sendKeyBackSpaceTypeText(WebElement element,String text){
        element.click();
        element.sendKeys(Keys.BACK_SPACE);
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }

    public void typeTextAndSendEnter(WebElement element,String text){
        element.clear();
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }
    public void sendKeyEnter(WebElement element){
        element.sendKeys(Keys.ENTER);
    }
    public void sendText(WebElement element,String text){
        element.sendKeys(text);
    }

    public void hover(WebElement element) {
        actions = new Actions(browser);
        actions.moveToElement(element).perform();
    }

    protected WebElement waitElementToBeClickable(By locator) {
        browserWait = new WebDriverWait(browser, Duration.ofSeconds(WAIT_FOR_TIMEOUT));
        return browserWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}