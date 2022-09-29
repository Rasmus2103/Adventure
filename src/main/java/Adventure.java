import java.util.ArrayList;
import java.util.Scanner;

public class Adventure {
        Room room1 = new Room("Room 1", "room with no distinct features, except two doors");
        Room room2 = new Room("Room 2", "room that has a lot things lying around, only one other door");
        Room room3 = new Room("Room 3", "room with a lot a skeletons and an old axe, and only one other door");
        Room room4 = new Room("Room 4", "room with a giant ready to kill you, fight it with the sword on the ground or run to the door");
        Room room5 = new Room("Room 5", "room with a bag of gold lying on the ground, there are no other doors to go through");
        Room room6 = new Room("Room 6", "room that has a shield hanging on the wall, take it or proceed to the next room");
        Room room7 = new Room("Room 7", "room that has pictures of Kings and Queens, only one door");
        Room room8 = new Room("Room 8", "room with two doors, what could they lead too?");
        Room room9 = new Room("Room 9", "room with a minotaur that are the strongest creature, fight it or flee to the door");


        public void run(Adventure adventure, UserInterface userInterface) {
                Map map = new Map();
                //Vi kalder map metoden, som det første, så vil alle vejene i rummene blive sat. Det er vigtigt den kaldes først,
                // ellers vil "map.currentRoom" kun havde null værdier.
                map.mapRooms(adventure);
                map.currentRoom = adventure.room1;


                userInterface.welcome();
                //Fjernet map.Map() da den ikke skal kaldes så langt nede, ellers vil currentRoom aldrig blive sat med korrekte værdier.
                while (true) {
                        String choice = userInterface.returnUserChoice();
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