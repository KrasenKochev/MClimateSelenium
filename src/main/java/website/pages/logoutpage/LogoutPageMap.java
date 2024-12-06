package website.pages.logoutpage;

import core.basemap.BaseMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LogoutPageMap extends BaseMap {

    public WebElement logoutButton() {
        return waitAndFindElement(By.xpath("//i [@class = \"uil uil-sign-out-alt font-size-18 salign-middle me-1 text-muted\"]"));
    }
    public WebElement myAccountNavigationBarElement() {
        return waitAndFindElement(By.xpath("//span [@class= \"d-none d-xl-inline-block ms-1 fw-medium font-size-15\" and text()=\"Interview\"]"));
    }

}