import java.util.Scanner;

public class Adventure {

        private Map adventureMap = new Map();
        private Player player;

        public Adventure() {
                adventureMap.mapRooms();
                player = new Player(adventureMap.getStarterRoom());
        }

        public boolean go(String direction) {
                return player.move(direction);
        }

        public boolean takeItem(String itemName) {
               return player.takeItem(itemName);
        }

        public boolean dropItem(String itemName) {
                return player.dropItem(itemName);
        }

        public Player getPlayer() {
                return player;
        }

        public Eat playerEat(String itemName) {
              return player.eat(itemName);
        }

        public Room getCurrentRoom() {
                return player.getCurrentRoom();
        }
}