import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    Scanner input = new Scanner(System.in);

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

    public void looking(Map adventureMap){
        System.out.println("Looking");
        System.out.println(adventureMap.currentRoom.getName());
        System.out.println(adventureMap.currentRoom.getDescription());
        System.out.println("You also look around to see if there is any items of value");

        if (adventureMap.currentRoom.getItems().size()==0){
            System.out.println("There is no items");
        } else {
            for (Item item : adventureMap.currentRoom.getItems()) {
                System.out.println("You see a " + item.getItemName());
            }
        }

    }

    public void youCantGoNorth(){
        System.out.println("You cannot go north");
    }
    public void goingNorth(String description){
        System.out.println(description);
    }

    public void goingSouth(String description) {
        System.out.println(description);
    }

    public void cannotGoSouth() {
        System.out.println("You cannot go south");
    }

    public void goingEast(String description) {
        System.out.println(description);
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

    public void youCannotWriteThat() {
        System.out.println("You cannot write that");
    }

}
