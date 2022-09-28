import java.util.Scanner;

public class UserInterface {

    Map map = new Map();
    Adventure adventure = new Adventure();

    public void run() {
        map.currentRoom = adventure.room1;

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Adventure Game");
        map.Map();
        while (true) {
            String choice = input.nextLine();
            if (choice.equalsIgnoreCase("Go north")) {
                map.goNorth();
            }
            else if (choice.equalsIgnoreCase("Go south")) {
                map.goSouth();
            }
            else if (choice.equalsIgnoreCase("Go east")) {
                map.goEast();
            }
            else if (choice.equalsIgnoreCase("Go west")) {
                map.goWest();
            }
            else if (choice.equalsIgnoreCase("Exit")) {
                System.out.println("Exiting Thanks for playing");
                System.exit(0);
            }
            else if (choice.equalsIgnoreCase("Help")) {
                System.out.println("You can write go north, south, west or east to go in a direction" +
                        " \nlook to see what room you are in, and a description" +
                        " \nexit to leave the game");
            }
            else if (choice.equalsIgnoreCase("Look")) {
                System.out.println("Looking");
                System.out.println(map.currentRoom.getName());
                System.out.println(map.currentRoom.getDescription());
            }
            else {
                System.out.println("You cannot write that");
            }
        }

    }
}
