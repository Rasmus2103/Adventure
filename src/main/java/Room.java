public class Room {

private String name;
private String description;

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
}
