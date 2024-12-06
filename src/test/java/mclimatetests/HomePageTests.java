package mclimatetests;

import core.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import website.pages.loginpage.PersonalInformation;
import website.pages.myhomepage.BuildingInformation;

import websitedata.factories.UserAndBuildingFactory;

import static constants.Constants.*;


public class HomePageTests extends BaseTest {

    BuildingInformation buildingName;
    BuildingInformation addressName;
    BuildingInformation timezoneName;
    BuildingInformation numberOfSpaces;
    BuildingInformation numberOfRooms;
    PersonalInformation loginUser;
    BuildingInformation nameOfSpaces;
    BuildingInformation nameOfRooms;


    @BeforeEach
    public void setup(){
        loginUser = UserAndBuildingFactory.loginUser(EMAIL_ADDRESS_USERNAME, PASSWORD);
        buildingName = UserAndBuildingFactory.generateBuildingName(BUILDING_NAME);
        addressName = UserAndBuildingFactory.generateBuildingAddress(ADDRESS_NAME);
        timezoneName = UserAndBuildingFactory.generateTimeZone(TIMEZONE_NAME);
        nameOfSpaces = UserAndBuildingFactory.generateNameOfSpaces(NAME_OF_SPACES);
        numberOfSpaces = UserAndBuildingFactory.generateNumberOfSpaces(NUMBER_OF_SPACES);
        numberOfRooms = UserAndBuildingFactory.generateNumberOfRooms(NUMBER_OF_ROOMS);
        nameOfRooms = UserAndBuildingFactory.generateNameOfRooms(NAME_OF_ROOMS);
    }

    @Test
    public void createBuilding(){
        webSite.loginPage.navigate();
        webSite.loginPage.loginUser(loginUser);

        webSite.myHomePage.startCreateNewBuilding();
        webSite.myHomePage.createBuildingNameAndType(buildingName,addressName,timezoneName);
        webSite.myHomePage.createBuildingSize();
        webSite.myHomePage.selectNoFloors();
        webSite.myHomePage.selectSpaces();
        webSite.myHomePage.createNumberOfSpaces(numberOfSpaces);
        webSite.myHomePage.createRooms();
        webSite.myHomePage.exitCreatePupUpMenu();

        /*
        Asserts for homepage navigated and building name present on homepage
         */
        webSite.myHomePage.assertUrlPage();
        webSite.myHomePage.assertions().asserBuildingIsSuccessfullyCreated(buildingName);

    }
    /*
    Deleting of newly created building after each building creation
     */
    @AfterEach
    public void deleteCreatedBuilding(){

        webSite.myHomePage.locateCreatedBuilding();

        /*
        Asserts of number of spaces(office type) and rooms
         */
        webSite.myHomePage.assertions().assertBuildingHasTwoSpaces(nameOfSpaces,numberOfSpaces);
        webSite.myHomePage.assertions().assertBuildingHasTwoRooms(nameOfRooms,numberOfRooms);
        webSite.myHomePage.assertions().assertBuildingHasNoFloors(NAME_OF_FLOORS);
        /*
        Continue to deletion of building
         */
        webSite.myHomePage.editSelectedBuilding();
        webSite.myHomePage.deleteSelectedBuilding();
        /*
        Assert that the building is deleted and not present on homepage
         */
       webSite.myHomePage.assertions().assertBuildingWasDeleted(buildingName);;
    }

}