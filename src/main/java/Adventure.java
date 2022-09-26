import java.util.Scanner;

public class Adventure {

    Room currentRoom = new Room();
    Room room1 = new Room("Room 1", "room with no distinct features, except two doors");
    Room room2 = new Room();
    Room room3 = new Room();
    Room room4 = new Room();
    Room room5 = new Room();
    Room room6 = new Room();
    Room room7 = new Room();
    Room room8 = new Room();
    Room room9 = new Room();

    public void run() {
        currentRoom = room1;

        Scanner input = new Scanner(System.in);
        while (true) {
            String choice = input.nextLine();
            if (choice.equalsIgnoreCase("Go north")) {
                System.out.println("Going north");
            }
            if (choice.equalsIgnoreCase("Go south")) {
                System.out.println("Going south");
            }
            if (choice.equalsIgnoreCase("Go east")) {
                System.out.println("Going east");
            }
            if (choice.equalsIgnoreCase("Go west")) {
                System.out.println("Going west");
            }
            if (choice.equalsIgnoreCase("Exit")) {
                System.out.println("Exiting");
            }
            if (choice.equalsIgnoreCase("Help")) {
                System.out.println("Helping");
            }
            if (choice.equalsIgnoreCase("Look")) {
                System.out.println("Looking");
                System.out.println(currentRoom.getName());
                System.out.println(currentRoom.getDescription());
            }

        }
    }

}
