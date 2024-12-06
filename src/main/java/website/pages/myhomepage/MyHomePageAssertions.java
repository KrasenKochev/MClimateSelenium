package website.pages.myhomepage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static constants.Constants.*;

public class MyHomePageAssertions extends BaseAssertions<MyHomePageMap> {

    /*
    Look for in locators for building names, that contains the newly created building name(after finishing creating),
    and asserts if that name is the same as the name used for generation
     */
    public void asserBuildingIsSuccessfullyCreated(BuildingInformation buildingName) {
        var expectedResult = buildingName.buildingName;
        var actualResult = elementsT().createdBuildingName().getText();
        var FoundBuildingMessage = formatMessage(ERROR_MESSAGE_BUILDING_NOT_FOUND,actualResult, expectedResult );
        Assertions.assertEquals(expectedResult, actualResult, FoundBuildingMessage);
    }
    /*
    Find locator that display the name of the created Spaces and the number of them(Of a selected building).
    Then assert if they correspondent to the requested ones.
    toLowerCase, trim and replaceAll are needed, because the value contained and the xpath of the locator differ in these aspects,
    nevertheless, they are not shared with other locators.
     */
    public void assertBuildingHasTwoSpaces(BuildingInformation nameOfSpaces, BuildingInformation numberOfSpaces) {
        var expectedResult = String.format("%s:%s",nameOfSpaces.getNameOfSpaces(),numberOfSpaces.getNumberOfSpaces());
        var actualResult = elementsT().numberOfSpacesSelectionIcon(nameOfSpaces.getNameOfSpaces(),numberOfSpaces.getNumberOfSpaces())
                .getText()
                .toLowerCase()
                .trim()
                .replaceAll("\\s+", "");
        var FoundSpacesMessage = formatMessage(ERROR_MESSAGE_NUMBER_OF_SPACES_NOT_CORRECT, actualResult, expectedResult);
        Assertions.assertEquals(actualResult.toLowerCase(),expectedResult.toLowerCase(), FoundSpacesMessage);
    }
    /*
    Find locator that display the name of the created Rooms and the number of them(Of a selected building).
    Then assert if they correspondent to the requested ones.
    toLowerCase, trim and replaceAll are needed, because the value contained and the xpath of the locator differ in these aspects,
    nevertheless, they are not shared with other locators.
     */
    public void assertBuildingHasTwoRooms(BuildingInformation nameOfRooms, BuildingInformation numberOfRooms) {
        var expectedResult = String.format("%s:%s",nameOfRooms.getNameOfRooms(),numberOfRooms.getNumberOfRooms())
                .toLowerCase()
                .trim().
                replaceAll("\\s+", "");
        var actualResult = elementsT().numberOfRoomsSelectionIcon(nameOfRooms.getNameOfRooms(),numberOfRooms.getNumberOfRooms())
                .getText()
                .toLowerCase()
                .trim()
                .replaceAll("\\s+", "");
        var FoundRoomsMessage = formatMessage(ERROR_MESSAGE_NUMBER_OF_ROOMS_NOT_CORRECT,actualResult,expectedResult);
        Assertions.assertEquals(expectedResult, actualResult, FoundRoomsMessage);

    }
    /*
    This assertion checks if the element is visible, by locator.
     */
    public void assertBuildingHasNoFloors(String expectedResult) {
        boolean isElementPresent;
        try {
            WebElement element = elementsT().searchForBuildingFloorsIcon();
            isElementPresent = element != null;
        } catch (NoSuchElementException e) {
            isElementPresent = false;
        }
        Assertions.assertFalse(isElementPresent,ERROR_MESSAGE_NUMBER_OF_FLOOR_NOT_CORRECT);

    }
    /*
    search for a locator that contains the building name, and assert that it's not present
     */
    public void assertBuildingWasDeleted(BuildingInformation buildingName) {
        var expectedResult = buildingName.buildingName;
        boolean isElementPresent;
        try {
            WebElement element = elementsT().searchForDeletedBuildingName(expectedResult);
            isElementPresent = element != null;
        } catch (NoSuchElementException e) {
            isElementPresent = false;
        }
        Assertions.assertFalse(isElementPresent,ERROR_MESSAGE_BUILDING_FOUND);
    }

}