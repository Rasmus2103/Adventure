
public class Map {
    Room currentRoom = new Room();
    Adventure adventure = new Adventure();

    public void Map() {
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

