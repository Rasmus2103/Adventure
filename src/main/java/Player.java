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

    /*public boolean goNorth() {
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
    }*/

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
        } else {
            if(itemFromInventory == null){
                return Eat.NOT_FOUND;
            } else {
                return Eat.NOT_EDIBLE;
            }
        }


        /*Item itemFromInventory = searchInventoryPlayer(name); //Hentes fra inventory kan være null
        Item itemFromRoom = currentRoom.findItem(name); //Hentes fra room kan være null
        if (itemFromInventory == null && itemFromRoom == null){ //Vi tjekker om de begge er null
            itemDoesNotExist(name); //Hvis begge er null skriver vi en tekst ud med at item ikke findes

        }else if(itemFromInventory != null){ //Hvis item findes i inventory
            if (isEdible(itemFromInventory)){ //Hvis item "kan spises" en item kan spises hvis metoden isEdible returnere true
                health += ((Food) itemFromInventory).healthPoints; //Vi caster "item" til food hvilket er muligt, da denne item er en instance of food. altså den er edible
                // vi tilføjer og sætter = livet i forhold til hvor mange healthPoints item har.
                eat(name, ((Food) itemFromInventory).healthPoints); //Vi kalder udskrivnings metoden fra UI.
                removeItemPlayer(itemFromInventory); //Vi fjerner item fra player altså efter man har spist den er den væk.
            }else {
                notEdible();//Hvis man ikke kan spise den item altså det ikke er en instance of food, udskriver vi den ikke kan spises.

            }
        }else if (itemFromRoom != null) { //Hvis item findes i rummet
            if (isEdible(itemFromRoom)){ //Hvis item er edible
                health += ((Food) itemFromRoom).healthPoints; //Vi caster item da den er edible, altså er typen "food" som nedarver fra item
                //Hvis man caster en item som ikke er typen food, vil man få en fejl.
                eat(name, ((Food) itemFromRoom).healthPoints); //Vi kalder udskrivnings metoden
                currentRoom.removeItem(itemFromRoom, currentRoom); //Vi fjerner item fra currentRoom da vi har spist den
            }else {
                notEdible(); //Vi skriver at man ikke kan spise item
            }
        }*/

    }
    //Hvis Item er en instance of Food, som betyder hvis denne item er typen food, returner dernæst true, ellers returner false.
    //Det bruger vi til at sikre, at vi ikke forsøger at cast en item som ikke er "food" da alle food er en item, men ikke alle item er en food.
    public boolean isEdible(Item item){
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
