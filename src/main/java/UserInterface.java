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
                    goMove(userChoice);
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
                    takeItem(userChoice);
                    break;
                case "drop":
                    dropItem(userChoice);
                    break;
                case "i":
                    System.out.println(adventure.getPlayer().getInventory());
                    break;
                case "eat":
                    eat(userChoice);
                    health();
                    break;
                default:
                    youCannotWriteThat();
            }
        }

    }

    public void printItemsInRoom() {
        Room currentRoom = adventure.getCurrentRoom();
        for(Item item: currentRoom.getItems()) {
            System.out.println(item.getItemName());
            System.out.println(item.getItemDescription());
        }
    }

    public void goMove(String userChoice) {
        if(adventure.go(userChoice)) {
            System.out.println(adventure.getCurrentRoom().getDescription());
        } else {
            System.out.println("You cannot go that way");
        }
    }

    public void takeItem(String userChoice) {
        if(adventure.takeItem(userChoice)) {
            System.out.println("You have taken " + userChoice);
        } else {
            System.out.println("There is no item called " + userChoice);
        }
    }

    public void dropItem(String userChoice) {
        if(adventure.dropItem(userChoice)) {
            System.out.println("You have dropped "+ userChoice);
        } else {
            System.out.println("There is no item called " + userChoice);
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

    public void printItems(ArrayList<Item> items) {
        System.out.println(items.toString());
    }


    public void health() {
        System.out.println("Your current health is: " + adventure.getPlayer().getHealth());
    }

    public void eat(String name){
        switch (adventure.playerEat(name)) {
            case EDIBLE:
                System.out.println("You ate " + name + " and gained " + adventure.getPlayer().getHealth() + " health");
                break;
            case NOT_GOOD:
                System.out.println("You ate " + name + " and lost " + adventure.getPlayer().getHealth() + " health");
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
