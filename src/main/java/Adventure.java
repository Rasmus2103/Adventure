
public class Adventure {

        private Map adventureMap = new Map();
        private Player player;

        public Adventure() {
                adventureMap.mapRooms();
                player = new Player(adventureMap.getStarterRoom());
                //player = new Player(new Weapons("axe", "a really big axe", 30));
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

        public ReturnMessage playerEquip(String itemName) {
                return player.equip(itemName);
        }

        /*public ReturnMessage playerMeleeAttack(String itemName) {
                return player.meleeAttack(itemName);
        }*/

        /*public ReturnMessage playerRangedAttack(String itemName) {
                return player.rangedAttack(itemName);
        }*/

        public ReturnMessage playerAttack() {
                return player.attack();
        }

        public Room getCurrentRoom() {
                return player.getCurrentRoom();
        }
}