import java.util.ArrayList;

public class Room {

private String name;
private String description;
private Room east;
private Room north;
private Room south;
private Room west;
private ArrayList<Item> items;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        items = new ArrayList<>();
    }

    public void setRoom(Room north, Room south, Room west, Room east) {
        this.north = north;
        this.south = south;
        this.west = west;
        this.east = east;
    }

    public void addItem(String itemName, String itemDescription){
        Item item1 = new Item(itemName, itemDescription);
        items.add(item1);
    }
    //Lidt anderledes end addItem, da den instantiere en ny "food" men da food godt kan være en item, må det godt tilføjes til array'et-
    public void addFood(String itemName, String itemDescription, int health){
        Food food = new Food(itemName, itemDescription, health);
        items.add(food);
    }

    public Item takeItem(String itemName, UserInterface UI){
        Item item = findItem(itemName, this);
        if (item == null){
            UI.itemDoesNotExist(itemName);
        } else {
            removeItem(item, this);
        }

        return item;
    }

    public Item findItem(String itemName, Room currentRoom){
            for (Item item : currentRoom.getItems()) {
                if (item.getItemName().equalsIgnoreCase(itemName)){
                    return item;
                }
            }
        return null;
    }

    public void removeItem(Item item, Room currentRoom) {
        currentRoom.getItems().remove(item);
    }

    public void showItems(UserInterface UI) {
        UI.printItems(items);
    }



    //return "Item" + ;


    public Room() {
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public Room getNorth() {
        return north;
    }

    public Room getEast() {
        return east;
    }

    public Room getSouth() {
        return south;
    }

    public Room getWest() {
        return west;
    }

    public ArrayList<Item> getItems() {
        return items;
    }


}