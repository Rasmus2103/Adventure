import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Scanner input = new Scanner(System.in);
    private Adventure adventure = new Adventure();

    public void run() {
        //Vi kalder map metoden, som det første, så vil alle vejene i rummene blive sat. Det er vigtigt den kaldes først,
        // ellers vil "map.currentRoom" kun havde null værdier.

        welcome();
        //Fjernet map.Map() da den ikke skal kaldes så langt nede, ellers vil currentRoom aldrig blive sat med korrekte værdier.
        while (true) {
            String choice = returnUserChoice();
            String userChoice = null;
            String[] userInputs = choice.split(" ");
            String command = userInputs[0];
            if(userInputs.length > 1) {
                userChoice = userInputs[1];
            }
            if(userInputs.length > 1) {
                userChoice = userInputs[1];
            }
            switch (command){
                case "go":
                    if(adventure.go(userChoice)) {
                        System.out.println(adventure.getCurrentRoom().getDescription());
                    } else {
                        System.out.println("You cannot go that way");
                    }
                    break;
                case "exit":
                    exiting();
                    break;
                case "help":
                    help();
                    break;
                case "look":
                    looking();
                    break;
                case "take":
                    if(adventure.takeItem(userChoice)) {
                        System.out.println("You have taken " + userChoice);
                    } else {
                        System.out.println("There is no item called " + userChoice);
                    }
                    break;
                case "drop":
                    if(adventure.dropItem(userChoice)) {
                        System.out.println("You have dropped "+ userChoice);
                    } else {
                        System.out.println("There is no item called " + userChoice);
                    }
                    break;
                case "inventory":
                    System.out.println(adventure.getPlayer().getInventory());
                    break;
                case "eat":
                    eat(userChoice);
                    health();
                    break;
            }

            /*if (choice.equalsIgnoreCase("Go north")) {
                boolean succes = adventure.goNorth();
                if(succes) {
                    System.out.println(adventure.getCurrentRoom().getDescription());
                } else {
                    System.out.println("You cannot go that way");
                }
            }
            else if (choice.equalsIgnoreCase("Go south")) {
                boolean succes = adventure.goSouth();
                if(succes) {
                    System.out.println(adventure.getCurrentRoom().getDescription());
                } else {
                    System.out.println("You cannot go that way");
                }
            }
            else if (choice.equalsIgnoreCase("Go east")) {
                boolean succes = adventure.goEast();
                if(succes) {
                    System.out.println(adventure.getCurrentRoom().getDescription());
                } else {
                    System.out.println("You cannot go that way");
                }
            }
            else if (choice.equalsIgnoreCase("Go west")) {
                boolean succes = adventure.goWest();
                if(succes) {
                    System.out.println(adventure.getCurrentRoom().getDescription());
                } else {
                    System.out.println("You cannot go that way");
                }
            }
            if (choice.equalsIgnoreCase("Exit")) {
                exiting();
            }
            else if (choice.equalsIgnoreCase("Help")) {
                help();
            }
            else if (choice.equalsIgnoreCase("Look")) {
                looking();
            }
            else if(choice.equalsIgnoreCase("Show items")) {
                printItemsInRoom();
            }
            else if (choice.equalsIgnoreCase("Take item")) {
                Scanner sc = new Scanner(System.in);
                String itemName = sc.nextLine();
                Item i = adventure.getPlayer().takeItem(itemName);
                showTakenItem(i);
            }
            else if(choice.equalsIgnoreCase("Drop item")) {
                Scanner sc = new Scanner(System.in);
                String itemName = sc.nextLine();
                Item i = adventure.getPlayer().dropItem(itemName);
                showDroppedItem(i);
            }
            else if(choice.equalsIgnoreCase("Inventory")) {
                System.out.println(adventure.getPlayer().getInventory());
            }
            else if (choice.equalsIgnoreCase("Eat")) {
                eat(choice);
            }
            else {
                youCannotWriteThat();
            }*/
        }

    }

    public void printItemsInRoom() {
        Room currentRoom = adventure.getCurrentRoom();
        for(Item item: currentRoom.getItems()) {
            System.out.println(item.getItemName());
            System.out.println(item.getItemDescription());
        }
    }

    public void welcome() {
        System.out.println("Welcome to the Adventure Game");
        System.out.println("Enter a command to proceed, and write help if your in doubt");
    }

    public String returnUserChoice(){
        return input.nextLine();
    }

    public void exiting(){
        System.out.println("Exiting Thanks for playing");
        System.exit(0);
    }

    public void help(){
        System.out.println("You can write go north, south, west or east to go in a direction" +
                "\nlook to see what room you are in, and a description" +
                "\ntake item to add the item in the room to your inventory" +
                "\ndrop item to drop an item in your inventory to currentroom you are in" +
                "\ninventory to check what's in your inventory" +
                "\nexit to leave the game");
    }

    public void itemDoesNotExist(String itemName){
        System.out.println("There is no " + itemName);
    }

    public void looking(){
        Room currentRoom = adventure.getCurrentRoom();
        System.out.println("Looking");
        System.out.println(currentRoom.getName());
        System.out.println(currentRoom.getDescription());
        System.out.println("You also look around to see if there is any items of value");

        if (currentRoom.getItems().size()==0){
            System.out.println("There is no items");
        } else {
            for (Item item : currentRoom.getItems()) {
                System.out.println("You see a " + item.getItemName());
            }
        }

    }

    public void youCantGoNorth(){
        System.out.println("You cannot go north");
    }

    public void cannotGoSouth() {
        System.out.println("You cannot go south");
    }

    public void cannotGoEast() {
        System.out.println("You cannot go east");
    }

    public void cannotGoWest() {
        System.out.println("You cannot go west");
    }

    public void goingWest(String description) {
        System.out.println(description);
    }

    /*public void printItemsInRoom(int i, Room currentRoom) {
        System.out.println(currentRoom.getItems().get(i).getItemName());
        System.out.println(currentRoom.getItems().get(i).getItemDescription());
    }*/

    public void printItems(ArrayList<Item> items) {
        System.out.println(items.toString());
    }

    public void showTakenItem(Item i) {
        if(i == null) {
            System.out.println("No such item");
        } else {
            System.out.println("You have taken a " + i.getItemName());
        }
    }

    public void showDroppedItem(Item i) {
        if(i == null) {
            System.out.println("You have no item to drop");
        } else {
            System.out.println("You have dropped " + i.getItemName());
        }
    }

    public void health() {
        System.out.println("Your current health is: " + adventure.getPlayer().getHealth());
    }

    public void notEdible(Player player){
        System.out.println("You can't eat that");
    }

    public void eat(String name){
        switch (adventure.playerEat(name)) {
            case EDIBLE:
                System.out.println("You ate " + name + " and gained " + adventure.getPlayer().getHealth() + " health");
                break;
            case NOT_EDIBLE:
                System.out.println(name + " is not edible");
                break;
            case NOT_FOUND:
                System.out.println("There is no such food");
                break;
        }
    }

    public void youCannotWriteThat() {
        System.out.println("You cannot write that");
    }

}
