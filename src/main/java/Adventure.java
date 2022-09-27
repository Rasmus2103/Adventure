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

        public void createMap() {
            room1.setRoom(null, room4, null, room2);
            room2.setRoom(null, null, room1, room3);
            room3.setRoom(null, room6, room2, null);
            room4.setRoom(room1, room7, null, null);
            room5.setRoom(null, room8, null, null);
            room6.setRoom(room3, room9, null, null);
            room7.setRoom(room4, null, null, room8);
            room8.setRoom(room5, null, room7, room9);
            room9.setRoom(room6, null, room8, null);
        }


        public void run() {
            currentRoom = room1;

            Scanner input = new Scanner(System.in);
            System.out.println("Welcome to the Adventure Game");
            createMap();
            while (true) {
                String choice = input.nextLine();
                if (choice.equalsIgnoreCase("Go north")) {
                    //System.out.println("Going north");
                    goNorth();
                }
                else if (choice.equalsIgnoreCase("Go south")) {
                    //System.out.println("Going south");
                    goSouth();
                }
                else if (choice.equalsIgnoreCase("Go east")) {
                    //System.out.println("Going east");
                    goEast();
                }
                else if (choice.equalsIgnoreCase("Go west")) {
                    //System.out.println("Going west");
                    goWest();
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

        public void goNorth() {
            if(currentRoom.getNorth() == null) {
                System.out.println("You cannot go north");
            } else {
                currentRoom = currentRoom.getNorth();
                System.out.println(currentRoom.getDescription());
            }
        }

        public void goSouth() {
            if(currentRoom.getSouth() == null) {
                System.out.println("You cannot go south");
            } else {
                currentRoom = currentRoom.getSouth();
                System.out.println(currentRoom.getDescription());
            }
        }

        public void goWest() {
            if(currentRoom.getWest() == null) {
                System.out.println("You cannot go west");
            } else {
                currentRoom = currentRoom.getWest();
                System.out.println(currentRoom.getDescription());
            }
        }

        public void goEast() {
            if(currentRoom.getEast() == null) {
                System.out.println("You cannot go east");
            } else {
                currentRoom = currentRoom.getEast();
                System.out.println(currentRoom.getDescription());
            }
        }

    }

