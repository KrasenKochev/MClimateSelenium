package website.pages.myhomepage;

import core.basepage.WebPage;

import static urls.Urls.HOME_PAGE;

public class MyHomePage extends WebPage<MyHomePageMap, MyHomePageAssertions> {


    @Override
    protected String Url() {
        return HOME_PAGE;
    }


    public void startCreateNewBuilding(){
        elements().createNewBuildingButton().click();
    }

    public void createBuildingNameAndType(BuildingInformation building,BuildingInformation address,BuildingInformation timezone) {
        elements().typeText(elements().createNameBuildingField(), building.buildingName);
        elements().typeTextAndSendEnter(elements().createAddressBuildingField(), address.addressName);
        elements().sendKeyEnter(elements().createAddressBuildingField());
        elements().selectFromDropDown(timezone.timezoneName);
        elements().clickButtonJS(elements().nextButton());
    }

    public void createBuildingSize(){
        elements().clickButtonJS(elements().buildingSizeCoolingTypeButton());
        elements().clickButtonJS(elements().buildingSizeHeatingTypeButton());
        elements().clickButtonJS(elements().nextButton());
    }
    public void selectNoFloors(){
        elements().clickButtonJS(elements().floorsNoCreateButton());
        elements().clickButtonJS(elements().floorsConfirmNextButton());    }

    public void selectSpaces(){
        elements().clickButtonJS(elements().spacesYesCreateButton());
        elements().clickButtonJS(elements().spacesOfficesTypeSelection());
        elements().clickButtonJS(elements().nextButton());
    }

    public void createNumberOfSpaces( BuildingInformation numberOfSpaces){
        elements().sendKeyBackSpaceTypeText(elements().spacesCountField(), numberOfSpaces.numberOfSpaces);
        elements().clickButtonJS(elements().nextButton());


    }
    public void createRooms(){
        elements().clickButtonJS(elements().roomsYesCreateButton());
        elements().clickButtonJS(elements().roomsCollapseDownButton());
        elements().clickButtonJS(elements().roomsCollapseDownButton());
        elements().clickButtonJS(elements().roomsCreateFirstButton());
        elements().clickButtonJS(elements().roomsCreateSecondButton());
        elements().clickButtonJS(elements().nextButton());
    }

    public void exitCreatePupUpMenu(){
        elements().clickButtonJS(elements().buildingCreatedPopUpEscapeButton());
    }

    public void locateCreatedBuilding(){
        elements().clickButtonJS(elements().createdBuildingButton());
    }
    public void editSelectedBuilding(){
        elements().clickButtonJS((elements().editSelectedBuildingButton()));
    }
    public void deleteSelectedBuilding(){
        elements().clickButtonJS(elements().deleteSelectedBuildingButton());
        elements().clickButtonJS(elements().deleteSelectedBuildingConfirmationButton());
        elements().createNewBuildingButton();
    }

}

