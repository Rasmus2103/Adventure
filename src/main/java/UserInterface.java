import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Scanner input = new Scanner(System.in);

    public void welcome() {
        System.out.println("Welcome to the Adventure Game");
    }

    public String returnUserChoice(){
        return input.nextLine();
    }

    public void exitingMessage() {
        System.out.println("Exiting Thanks for playing");
    }

    public void currentRoomText(Room currentRoom) {
        System.out.println(currentRoom.getDescription());
    }

    public void itemDoesNotExist(String itemName){
        System.out.println("There is no " + itemName);
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

    public void printItemsInRoom(Room currentRoom) {
        for (Item item: currentRoom.getItems()) {
            System.out.println(item.getItemName());
            System.out.println(item.getItemDescription());
        }
    }

    public void help(){
        System.out.println("You can write go north, south, west or east to go in a direction" +
                " \nlook to see what room you are in, and a description" +
                " \nexit to leave the game");
    }

    public void looking(Room currentRoom){
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

    public void printInventory(Player player) {
        for (Item item: player.getInventory()) {
            System.out.println(item.getItemName());
            System.out.println(item.getItemDescription());
        }
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

    public void health(Player player) {
        System.out.println("Your current health is: " + player.getHealth());
    }

    public void notEdible(){
        System.out.println("You can't eat that");
    }

    public void eat(String name, int healtPoints){
        System.out.println("You ate " + name + " and gained " + healtPoints + " health");
    }

}
