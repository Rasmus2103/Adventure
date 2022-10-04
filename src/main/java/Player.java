import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private String name;
    private int health;
    private ArrayList<Item> inventory;

    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
        this.name = "";
        inventory = new ArrayList<>();
    }

    public boolean goNorth() {
        if(currentRoom.getNorth() == null) {
            return false;
        } else {
            currentRoom = currentRoom.getNorth();
            return true;
        }
    }

    public boolean goSouth() {
        if(currentRoom.getSouth() == null) {
            return false;
        } else {
            currentRoom = currentRoom.getSouth();
            return true;
        }
    }

    public boolean goWest() {
        if(currentRoom.getWest() == null) {
            return false;
        } else {
            currentRoom = currentRoom.getWest();
            return true;
        }
    }

    public boolean goEast() {
        if(currentRoom.getEast() == null) {
            return false;
        } else {
            currentRoom = currentRoom.getEast();
            return true;
        }
    }

    public String look() {
        return currentRoom.getName() + currentRoom.getDescription();
    }

    public Item searchInventoryPlayer(String name) {
        for(Item i: inventory) {
            if(i.getItemName().equals(name)) {
                return i;
            }
        }
        return null;
    }

    public void removeItemPlayer(Item item) {
        this.inventory.remove(item);
    }

    public void showItemPlayer(Item item) {
        this.getInventory();
    }

    public String toString() {
        return "Inventory: " + inventory;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public Item takeItem(String itemName) {
        for(Item item: currentRoom.getItems()) {
            if(item.getItemName().equals(itemName)) {
                inventory.add(item);
                currentRoom.getItems().remove(item);
                return item;
            }
        }
        return null;
    }

    public Item dropItem(String itemName) {
        for(Item item: currentRoom.getItems()) {
            if(item.getItemName().equals(itemName)) {
                currentRoom.getItems().add(item);
                inventory.remove(item);
                return item;
            }
        }
        return null;
    }
}
