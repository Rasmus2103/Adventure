
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
        // Husk at sætte den rigtige rækkefølge fra den anden tekst.
        adventure.room2.addItem("Lamp", "A old lamp hanging at the wall");
        adventure.room3.addItem("Health Potion", "A potion that seems to have healing powers");
        adventure.room4.addItem("Sword", "A shiny sword is laying on the ground");
        adventure.room5.addItem("Bag of gold", "A shiny bag bag of gold");
        adventure.room6.addItem("Map", "An old map, seems like it could lead to something valuable");
        adventure.room7.addItem("Torch", "A torch hanging at the wall, that could help light up dark places");
        adventure.room8.addItem("Shield", "A shield that seems to have a royal crest on it");
        adventure.room9.addItem(null, null);
    }

    public void removeItems(Adventure adventure) {

    }


    public void showItemsRooms(UserInterface UI) {
            for(int i =0; i <currentRoom.getItems().size(); i++) {
                UI.printItemsInRoom(i, currentRoom);
            }
    }

    public void goNorth(UserInterface UI) {
        if(currentRoom.getNorth() == null) {
            UI.youCantGoNorth();
        } else {
            currentRoom = currentRoom.getNorth();
            UI.goingNorth(currentRoom.getDescription());
        }
    }

    public void goSouth(UserInterface UI) {
        if(currentRoom.getSouth() == null) {
            UI.cannotGoSouth();
        } else {
            currentRoom = currentRoom.getSouth();
            UI.goingSouth(currentRoom.getDescription());
        }
    }



    public void goWest(UserInterface UI) {
        if(currentRoom.getWest() == null) {
            UI.cannotGoWest();
        } else {
            currentRoom = currentRoom.getWest();
            UI.goingWest(currentRoom.getDescription());
        }
    }

    public void goEast(UserInterface UI) {
        if(currentRoom.getEast() == null) {
            UI.cannotGoEast();
        } else {
            currentRoom = currentRoom.getEast();
            UI.goingEast(currentRoom.getDescription());
        }
    }

}

