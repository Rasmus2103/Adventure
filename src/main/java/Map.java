
public class Map {
    Room currentRoom = new Room();

    //Fjernet new adventure objektet, da det ikke er relateret til adventure objektet der blev brugt til at sætte map.currentRoom værdien.
    //Da det var to forskellige objekter, har vi fjernet det ene, så vi altid bruger det samme adventure objekt.
    //Derfor er det tilføjet som en parameter i mapRooms metoden
    //Husk altid at metoder starter med småt.
    public void mapRooms(Adventure adventure) {
        adventure.room1.setRoom(null, adventure.room4, null, adventure.room2);
        adventure.room2.setRoom(null, null, adventure.room1, adventure.room3);
        adventure.room3.setRoom(null, adventure.room6, adventure.room2, null);
        adventure.room4.setRoom(adventure.room1, adventure.room7, null, null);
        adventure.room5.setRoom(null, adventure.room8, null, null);
        adventure.room6.setRoom(adventure.room3, adventure.room9, null, null);
        adventure.room7.setRoom(adventure.room4, null, null, adventure.room8);
        adventure.room8.setRoom(adventure.room5, null, adventure.room7, adventure.room9);
        adventure.room9.setRoom(adventure.room6, null, adventure.room8, null);
    }

    public void itemRooms(Adventure adventure) {
        adventure.room1.addItems("Shield", "A shield that seems to have a royal crest on it");
        adventure.room2.addItems("Lamp", "A old lamp hanging at the wall");
        adventure.room3.addItems("Health Potion", "A potion that seems to have healing powers");
        adventure.room4.addItems("Sword", "A shiny sword is laying on the ground");
        adventure.room5.addItems("Bag of gold", "A shiny bag bag of gold");
        adventure.room6.addItems("Map", "An old map, seems like it could lead to something valuable");
        adventure.room7.addItems("Torch", "A torch hanging at the wall, that could help light up dark places");
        adventure.room8.addItems(null, null);
        adventure.room9.addItems(null, null);
    }

    public void removeItems(Adventure adventure) {

    }


    public void showItemsRooms() {
            for(int i =0; i <currentRoom.getItems().size(); i++) {
                System.out.println(currentRoom.getItems().get(i).getItemName());
                System.out.println(currentRoom.getItems().get(i).getItemDescription());
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

