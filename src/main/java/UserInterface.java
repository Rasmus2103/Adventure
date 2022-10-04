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

            if (choice.equalsIgnoreCase("Go north")) {
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
                adventure.goEast();
            }
            else if (choice.equalsIgnoreCase("Go west")) {
                adventure.goWest();
            }
            else if (choice.equalsIgnoreCase("Exit")) {
                exiting();
            }
            else if (choice.equalsIgnoreCase("Help")) {
                help();
            }
            else if (choice.equalsIgnoreCase("Look")) {
                looking();
            }
            else if(choice.equalsIgnoreCase("Show items")) {
                System.out.println(adventure.getCurrentRoom().getItems());
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
            else {
                youCannotWriteThat();
            }
        }

    }

    public void welcome() {
        System.out.println("Welcome to the Adventure Game");
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
                " \nlook to see what room you are in, and a description" +
                " \nexit to leave the game");
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

    public void printItemsInRoom(int i, Room currentRoom) {
        System.out.println(currentRoom.getItems().get(i).getItemName());
        System.out.println(currentRoom.getItems().get(i).getItemDescription());
    }

    public void printItems(ArrayList<Item> items) {
        System.out.println(items.toString());
    }

    public void printInventory() {

    }

    public void noInventory(Player player) {
        System.out.println("There is nothing in your inventory");
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
            System.out.println("You have dropped a " + i.getItemName());
        }
    }

    public void youCannotWriteThat() {
        System.out.println("You cannot write that");
    }

}
