package website.pages.myhomepage;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class BuildingInformation {
    public String buildingName;
    public String addressName;
    public String timezoneName;
    public String nameOfSpaces;
    public String numberOfSpaces;
    public String numberOfRooms;
    public String nameOfRooms;

}
