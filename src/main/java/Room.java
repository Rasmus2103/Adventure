public class Room {

private String name;
private String description;
/*private String east;
private String north;
private String south;
private String west;*/

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Room() {
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    /*public String getNorth() {
        return north;
    }

    public String getSouth() {
        return south;
    }

    public String getEast() {
        return east;
    }

    public String getWest() {
        return west;
    }*/

}
