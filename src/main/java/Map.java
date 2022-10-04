
public class Map {
    private Room starterRoom = new Room();


    //Fjernet new adventure objektet, da det ikke er relateret til adventure objektet der blev brugt til at sætte map.currentRoom værdien.
    //Da det var to forskellige objekter, har vi fjernet det ene, så vi altid bruger det samme adventure objekt.
    //Derfor er det tilføjet som en parameter i mapRooms metoden
    //Husk altid at metoder starter med småt.
    public void mapRooms() {
        Room room1 = new Room("Room 1", "room with no distinct features, except two doors");
        Room room2 = new Room("Room 2", "room that has a lamp and hat, only one other door");
        Room room3 = new Room("Room 3", "room with a lot a skeletons and an old axe, and only one other door");
        Room room4 = new Room("Room 4", "room with a giant ready to kill you, fight it with the sword on the ground or run to the door");
        Room room5 = new Room("Room 5", "room with a bag of gold lying on the ground, there are no other doors to go through");
        Room room6 = new Room("Room 6", "room that has a shield hanging on the wall, take it or proceed to the next room");
        Room room7 = new Room("Room 7", "room that has pictures of Kings and Queens, only one door");
        Room room8 = new Room("Room 8", "room with two doors, what could they lead too?");
        Room room9 = new Room("Room 9", "room with a minotaur that are the strongest creature, fight it or flee to the door");

        room1.setRoom(null, room4, null, room2);
        room2.setRoom(null, null, room1, room3);
        room3.setRoom(null, room6, room2, null);
        room4.setRoom(room1, room7, null, null);
        room5.setRoom(null, room8, null, null);
        room6.setRoom(room3, room9, null, null);
        room7.setRoom(room4, null, null, room8);
        room8.setRoom(room5, null, room7, room9);
        room9.setRoom(room6, null, room8, null);

        room2.addItem("lamp", "A old lamp hanging at the wall");
        room3.addItem("health potion", "A potion that seems to have healing powers");
        room4.addItem("sword", "A shiny sword that help you fight the giant");
        room5.addItem("bag of gold", "A shiny bag bag of gold");
        room6.addItem("map", "An old map, seems like it could lead to something valuable");
        room7.addItem("torch", "A torch hanging at the wall, that could help light up dark places");
        room8.addItem("shield", "A shield that seems to have a royal crest on it");

        starterRoom = room1;
    }

    public void removeItems(Item item) {
        starterRoom.removeItem(item, starterRoom);
    }

    /*public void showInventoryPlayer(UserInterface UI) {
        if(player.getInventory().size() == 0) {
            UI.noInventory(player);
        } else {
            for(int i =0; i < player.getInventory().size(); i++) {
                UI.printInventory(player.getInventory(), i);
            }
        }
    }*/


    public Room getStarterRoom() {
        return starterRoom;
    }
}

