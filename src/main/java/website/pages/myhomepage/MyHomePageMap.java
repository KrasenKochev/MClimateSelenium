package website.pages.myhomepage;

import core.basemap.BaseMap;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static constants.Constants.*;

public class MyHomePageMap extends BaseMap {


    public WebElement createNewBuildingButton() {
        return waitAndFindElement(By.xpath("//button[@type=\"button\"  and text() = \"+ Create a new building\"]"));
    }

    public WebElement createBuildingHeaded() {
        return waitAndFindElement(By.xpath("//h5[@class=\"modal-title\"  and text() = \"Create a new building\"]"));
    }

    public WebElement createNameBuildingField() {
        return waitAndFindElement(By.xpath("// input [@placeholder=\"Name\"]"));
    }

    public WebElement createAddressBuildingField() {
        return waitAndFindElement(By.xpath("// input [@placeholder=\"Address\"]"));
    }

    public WebElement nextButton() {
        return waitAndFindElement(By.xpath("//button[@type=\"button\" and text() = \"Next\"]"));
    }

    public WebElement buildingSizeHeatingTypeButton() {
        return waitAndFindElement(By.xpath("//label[@for=\"heatingType-7\"]"));
    }

    public WebElement buildingSizeCoolingTypeButton() {
        return waitAndFindElement(By.xpath("//label[@for=\"coolingType-7\"]"));
    }


    public WebElement floorsNoCreateButton() {
        return waitAndFindElement(By.xpath("// button [@type = \"button\" and text() =\"No\" ]"));
    }



    public WebElement floorsConfirmNextButton() {
        return waitAndFindElement(By.xpath("(// button [@type = \"button\" and text() =\"Next\"  ])[1]"));
    }


    public WebElement spacesYesCreateButton() {
        return waitAndFindElement(By.xpath("// button [@type = \"button\" and text() =\"Yes, create\"  ]"));
    }


    public WebElement spacesOfficesTypeSelection() {
        return waitAndFindElement(By.xpath("//label [@ for = \"spaceType-2\"]"));
    }

    public WebElement spacesCountField() {
        return waitAndFindElement(By.id("number-of-spaces"));
    }


    public WebElement roomsYesCreateButton() {
        return waitAndFindElement(By.xpath("// button [@type=\"button\" and text() = \"Yes, create\"]"));
    }

    public WebElement roomsCollapseDownButton() {
        return waitAndFindElement(By.xpath("(// button [@class=\"accordion-button collapsed\" ])[1]"));
    }


    public WebElement roomsCreateFirstButton() {
        return waitAndFindElement(By.xpath("(// button [@type=\"button\" and text() = \"+ Create a new room\" ])[1]"));
    }


    public WebElement roomsCreateSecondButton() {
        return waitAndFindElement(By.xpath("(// button [@type=\"button\" and text() = \"+ Create a new room\" ])[2]"));
    }

    public WebElement buildingCreatedPopUpEscapeButton() {
        return waitAndFindElement(By.xpath("//button [@aria-label=\"Close\"]"));
    }

    public WebElement createdBuildingButton() {
        return waitAndFindElement(By.xpath("//div[contains(text(), '" + BUILDING_NAME +"')]" ));
    }
    public WebElement createdBuildingName(){
        return waitAndFindElement(By.xpath("//div[contains(text(), '" + BUILDING_NAME +"')]"));
    }
//    public WebElement searchForDeletedBuildingName(){
//        return onlyFindElement(By.xpath("//div[contains(text(), '" + BUILDING_NAME +"')]"));
//    }
//    tring pageText = driver.findElement(By.tagName("body")).getText();

    public WebElement editSelectedBuildingButton(){
        return  waitAndFindElement(By.xpath("//button [@type = \"button\" and text() = \"Edit building\"]"));
    }
    public WebElement deleteSelectedBuildingButton(){
        return waitAndFindElement(By.xpath("//button[@ type = \"button\" and text()= \"Delete\"]"));
    }
    public WebElement deleteSelectedBuildingConfirmationButton(){
        return waitAndFindElement(By.xpath("//a[@class=\"btn btn-xs btn-primary w-md btn btn-danger \" and text() = \"Yes, delete\"]"));
    }

    public WebElement selectBuildingSpacesSelectionPanelButton(){
        return waitAndFindElement(By.xpath("//a[text()= \"offices\"]"));
    }
    public WebElement numberOfRoomsSelectionIcon(String nameOfRooms, String numberOfRooms){
        return waitAndFindElement(By.xpath("//p[contains(normalize-space(.),'"+nameOfRooms+"') and contains(normalize-space(.),'"+numberOfRooms+"')]"));
    }

    public WebElement numberOfSpacesSelectionIcon(String nameOfSpaces, String numberOfSpaces){
        return waitAndFindElement(By.xpath("//p[contains(normalize-space(.),'"+nameOfSpaces+"') and contains(normalize-space(.),'"+numberOfSpaces+"')]"));
    }
    /*
    Check if the element for number of floors exist
     */
    public WebElement searchForBuildingFloorsIcon() {
        try {
            return onlyFindElement(By.xpath("//p[contains(text(), 'Floors:')]"));
        } catch (NoSuchElementException e) {
            return null;
        }
    }
    /*
    Check if an element containing the newly created building exist
    */
    public WebElement searchForDeletedBuildingName(String buildingName) {
        try {
            return onlyFindElement(By.xpath("//div[contains(text(), '" + buildingName + "')]"));
        } catch (NoSuchElementException e) {
            return null;
        }
    }


}