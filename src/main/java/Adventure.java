 import java.util.Scanner;

    public class Adventure {

        Room currentRoom = new Room();
        Room room1 = new Room("Room 1", "room with no distinct features, except two doors");
        Room room2 = new Room("Room 2", "room that has a lot things lying around, only one other door");
        Room room3 = new Room("Room 3", "room with a lot a skeletons and an old axe, and only one other door");
        Room room4 = new Room("Room 4", "room with a giant ready to kill you, fight or run too the door");
        Room room5 = new Room("Room 5", "room with a bag of gold lying on the ground, there are no other doors to go through");
        Room room6 = new Room("Room 6", "room that has a shield hanging at the wall, take it or proceed to the next room");
        Room room7 = new Room("Room 7", "room that has pictures of Kings and Queens, only one door");
        Room room8 = new Room("Room 8", "room with two doors, what could they lead too?");
        Room room9 = new Room("Room 9", "room with a minotaurus that are the strongest creature, fight it or flee too the door");



        public void run() {
            currentRoom = room1;

            Scanner input = new Scanner(System.in);
            System.out.println("Welcome to the Adventure Game");
            while (true) {
                String choice = input.nextLine();
                if (choice.equalsIgnoreCase("Go north")) {
                    System.out.println("Going north");
                }
                else if (choice.equalsIgnoreCase("Go south")) {
                    System.out.println("Going south");
                }
                else if (choice.equalsIgnoreCase("Go east")) {
                    System.out.println("Going east");
                }
                else if (choice.equalsIgnoreCase("Go west")) {
                    System.out.println("Going west");
                }
                else if (choice.equalsIgnoreCase("Exit")) {
                    System.out.println("Exiting Thanks for playing");
                    System.exit(0);
                }
                else if (choice.equalsIgnoreCase("Help")) {
                    System.out.println("Helping");
                }
                else if (choice.equalsIgnoreCase("Look")) {
                    System.out.println("Looking");
                    System.out.println(currentRoom.getName());
                    System.out.println(currentRoom.getDescription());
                }
                else {
                    System.out.println("You cannot write that");
                }

            }
        }
    }

