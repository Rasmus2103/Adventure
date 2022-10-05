
public class Adventure {

        private Map adventureMap = new Map();
        private Player player;

        public UserInterface UI = new UserInterface();

        public Adventure() {
                adventureMap.mapRooms();
                player = new Player(adventureMap.getStarterRoom());
        }

        public void run() {
                //Vi kalder map metoden, som det første, så vil alle vejene i rummene blive sat. Det er vigtigt den kaldes først,
                // ellers vil "map.currentRoom" kun havde null værdier.

                UI.welcome();
                //Fjernet map.Map() da den ikke skal kaldes så langt nede, ellers vil currentRoom aldrig blive sat med korrekte værdier.
                while (true) {
                        String choice = UI.returnUserChoice();

                        if (choice.equalsIgnoreCase("Go north")) {
                                boolean succes = goNorth();
                                if(succes) {
                                        UI.currentRoomText(getCurrentRoom());
                                } else {
                                        UI.youCantGoNorth();
                                }
                        }
                        else if (choice.equalsIgnoreCase("Go south")) {
                                boolean succes = goSouth();
                                if(succes) {
                                        UI.currentRoomText(getCurrentRoom());
                                } else {
                                        UI.cannotGoSouth();
                                }
                        }
                        else if (choice.equalsIgnoreCase("Go east")) {
                                boolean succes = goEast();

                                if(succes) {
                                        UI.currentRoomText(getCurrentRoom());
                                } else {
                                        UI.cannotGoEast();
                                }
                        }
                        else if (choice.equalsIgnoreCase("Go west")) {
                                boolean succes = goWest();;

                                if(succes) {
                                        UI.currentRoomText(getCurrentRoom());
                                } else {
                                        UI.cannotGoWest();
                                }
                        }
                        else if (choice.equalsIgnoreCase("Exit")) {
                                exiting();
                        }
                        else if (choice.equalsIgnoreCase("Help")) {
                                UI.help();
                        }
                        else if (choice.equalsIgnoreCase("Look")) {
                                UI.looking(getCurrentRoom());
                        } else if (choice.equalsIgnoreCase("Health")) {
                                UI.health(player);
                        } else if(choice.equalsIgnoreCase("Show items")||choice.equalsIgnoreCase("items")) {
                                UI.printItemsInRoom(getCurrentRoom());
                        }
                        else if (choice.equalsIgnoreCase("Take item")) {
                                String itemName = UI.returnUserChoice();
                                Item i = getPlayer().takeItem(itemName);
                                UI.showTakenItem(i);
                        }
                        else if(choice.equalsIgnoreCase("Drop item")) {
                                String itemName = UI.returnUserChoice();
                                Item i = getPlayer().dropItem(itemName);
                                UI.showDroppedItem(i);
                        }
                        else if(choice.equalsIgnoreCase("Inventory")) {
                                UI.printInventory(player);
                        } else if (choice.equalsIgnoreCase("Eat")) {
                                String name = UI.returnUserChoice();
                                player.eat(name, UI);

                        } else {
                                UI.youCannotWriteThat();
                        }
                }

        }



        public void exiting(){
                UI.exitingMessage();
                System.exit(0);
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