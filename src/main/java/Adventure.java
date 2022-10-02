import java.util.Scanner;

public class Adventure {
        Room room1 = new Room("Room 1", "room with no distinct features, except two doors");
        Room room2 = new Room("Room 2", "room that has a lamp and hat, only one other door");
        Room room3 = new Room("Room 3", "room with a lot a skeletons and an old axe, and only one other door");
        Room room4 = new Room("Room 4", "room with a giant ready to kill you, fight it with the sword on the ground or run to the door");
        Room room5 = new Room("Room 5", "room with a bag of gold lying on the ground, there are no other doors to go through");
        Room room6 = new Room("Room 6", "room that has a shield hanging on the wall, take it or proceed to the next room");
        Room room7 = new Room("Room 7", "room that has pictures of Kings and Queens, only one door");
        Room room8 = new Room("Room 8", "room with two doors, what could they lead too?");
        Room room9 = new Room("Room 9", "room with a minotaur that are the strongest creature, fight it or flee to the door");



        public void run(Adventure adventure, UserInterface userInterface) {
                Map adventureMap = new Map();
                Player player = new Player(adventureMap.currentRoom);
                //Vi kalder map metoden, som det første, så vil alle vejene i rummene blive sat. Det er vigtigt den kaldes først,
                // ellers vil "map.currentRoom" kun havde null værdier.
                adventureMap.mapRooms(adventure);
                adventureMap.itemRooms(adventure);
                adventureMap.currentRoom = adventure.room1;

                userInterface.welcome();
                //Fjernet map.Map() da den ikke skal kaldes så langt nede, ellers vil currentRoom aldrig blive sat med korrekte værdier.
                while (true) {
                        String choice = userInterface.returnUserChoice();
                        if (choice.equalsIgnoreCase("Go north")) {
                                adventureMap.goNorth(userInterface);
                        }
                        else if (choice.equalsIgnoreCase("Go south")) {
                                adventureMap.goSouth(userInterface);
                        }
                        else if (choice.equalsIgnoreCase("Go east")) {
                                adventureMap.goEast(userInterface);
                        }
                        else if (choice.equalsIgnoreCase("Go west")) {
                                adventureMap.goWest(userInterface);
                        }
                        else if (choice.equalsIgnoreCase("Exit")) {
                                userInterface.exiting();
                        }
                        else if (choice.equalsIgnoreCase("Help")) {
                                userInterface.help();
                        }
                        else if (choice.equalsIgnoreCase("Look")) {
                                userInterface.looking(adventureMap);
                        }
                        else if(choice.equalsIgnoreCase("Show items")) {
                                adventureMap.showItemsRooms(userInterface);
                        }
                        else if (choice.equalsIgnoreCase("Take item")) {
                                        Scanner sc = new Scanner(System.in);
                                        String itemName = sc.nextLine();
                                        Item i = adventureMap.currentRoom.takeItem(itemName, userInterface);
                                        player.addItemPlayer(i);
                                        userInterface.showTakenItem(i);
                                }
                        else if(choice.equalsIgnoreCase("Inventory")) {
                                adventureMap.showInventoryPlayer(userInterface);
                        }
                        else {
                                userInterface.youCannotWriteThat();
                        }
                }

        }

}