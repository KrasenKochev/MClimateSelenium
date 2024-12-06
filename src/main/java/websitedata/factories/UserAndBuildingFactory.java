package websitedata.factories;

import com.github.javafaker.Faker;
import website.pages.myhomepage.BuildingInformation;
import website.pages.loginpage.PersonalInformation;

public class UserAndBuildingFactory {

    public static final Faker faker = new Faker();

    protected static PersonalInformation.PersonalInformationBuilder<?, ?> generateCorePersonalInformation() {
        return PersonalInformation.builder()
//                .firstName(faker.name().firstName())
                .email(faker.internet().emailAddress());
    }

    public static PersonalInformation loginUser(String email, String password) {
        return PersonalInformation.builder()
                .email(email)
                .password(password)
                .build();

    }
    public static BuildingInformation generateBuildingAddress(String addressName) {
        return BuildingInformation.builder()
                .addressName(addressName)
                .build();
    }

    public static BuildingInformation generateBuildingName(String buildingName) {
        return BuildingInformation.builder()
                .buildingName(buildingName)
                .build();
    }
    public static BuildingInformation generateTimeZone(String timeZoneName) {
        return BuildingInformation.builder()
                .timezoneName(timeZoneName)
                .build();
    }
    public static BuildingInformation generateNumberOfSpaces(String numberOfSpaces) {
        return BuildingInformation.builder()
                .numberOfSpaces(numberOfSpaces)
                .build();
    }
    public static BuildingInformation generateNumberOfRooms(String numberOfRooms) {
        return BuildingInformation.builder()
                .numberOfRooms(numberOfRooms)
                .build();
    }
    public static BuildingInformation generateNameOfRooms(String nameOfRooms) {
        return BuildingInformation.builder()
                .nameOfRooms(nameOfRooms)
                .build();
    }
    public static BuildingInformation generateNameOfSpaces(String nameOfSpaces) {
        return BuildingInformation.builder()
                .nameOfSpaces(nameOfSpaces)
                .build();
    }


}