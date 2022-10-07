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
        this.health = 50;
    }

    public boolean move(String direction) {
        Room requestedRoom = null;

        if(direction.charAt(0) == 'n') {
            requestedRoom = currentRoom.getNorth();
        } else if(direction.charAt(0) == 's') {
            requestedRoom = currentRoom.getSouth();
        } else if(direction.charAt(0) == 'w') {
            requestedRoom = currentRoom.getWest();
        } else if(direction.charAt(0) == 'e') {
            requestedRoom = currentRoom.getEast();
        }

        if(requestedRoom != null) {
            currentRoom = requestedRoom;
            return true;
        } else {
            return false;
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

    public Eat eat(String name){
        Item itemFromInventory = searchInventoryPlayer(name);
        if(isEdible(itemFromInventory)){
            health += ((Food)itemFromInventory).getHealthPoints();
            return Eat.EDIBLE;
        } else if(isNotGood(itemFromInventory)) {
            health += ((Food)itemFromInventory).getHealthPoints();
            return Eat.NOT_GOOD;
        }
        else {
            if(itemFromInventory == null){
                return Eat.NOT_FOUND;
            } else {
                return Eat.NOT_EDIBLE;
            }
        }

    }
    //Hvis Item er en instance of Food, som betyder hvis denne item er typen food, returner dernæst true, ellers returner false.
    //Det bruger vi til at sikre, at vi ikke forsøger at cast en item som ikke er "food" da alle food er en item, men ikke alle item er en food.
    public boolean isEdible(Item item){
        return item instanceof Food;
    }

    public boolean isNotGood(Item item) {
        return item instanceof Food;
    }

    public boolean takeItem(String itemName) {
        for(Item item: currentRoom.getItems()) {
            if(item.getItemName().equals(itemName)) {
                inventory.add(item);
                currentRoom.getItems().remove(item);
                return true;
            }
        }
        return false;
    }

    public boolean dropItem(String itemName) {
        for(Item item: inventory) {
            if(item.getItemName().equals(itemName)) {
                currentRoom.getItems().add(item);
                inventory.remove(item);
                return true;
            }
        }
        return false;
    }

}
