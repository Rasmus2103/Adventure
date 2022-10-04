import java.util.Scanner;

public class Adventure {

        private Map adventureMap = new Map();
        private Player player;

        public Adventure() {
                adventureMap.mapRooms();
                player = new Player(adventureMap.getStarterRoom());
        }

        public boolean goNorth() {
               return player.goNorth();
        }

        public boolean goSouth() {
                return player.goSouth();
        }

        public boolean goWest() {
                return player.goWest();
        }

        public boolean goEast() {
                return player.goEast();
        }

        public Player getPlayer() {
                return player;
        }

        public Room getCurrentRoom() {
                return player.getCurrentRoom();
        }
}