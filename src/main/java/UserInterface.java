import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Scanner input = new Scanner(System.in);
    private Adventure adventure = new Adventure();

    public void run() {
        //Vi kalder map metoden, som det første, så vil alle vejene i rummene blive sat. Det er vigtigt den kaldes først,
        // ellers vil "map.currentRoom" kun havde null værdier.

        welcome();
        //Fjernet map.Map() da den ikke skal kaldes så langt nede, ellers vil currentRoom aldrig blive sat med korrekte værdier.
        while (true) {
            String choice = returnUserChoice();
            String userChoice = null;
            String[] userInputs = choice.split(" ");
            String command = userInputs[0];
            if (userInputs.length > 1) {
                userChoice = userInputs[1];
            }
            if (userInputs.length > 1) {
                userChoice = userInputs[1];
            }
            switch (command) {
                case "go":
                    goMove(userChoice);
                    break;
                case "exit":
                    exiting();
                    break;
                case "help":
                    help();
                    break;
                case "look":
                    looking();
                    break;
                case "take":
                    takeItem(userChoice);
                    break;
                case "drop":
                    dropItem(userChoice);
                    break;
                case "i":
                    showInventory();
                    break;
                case "eat":
                    eat(userChoice);
                    health();
                    break;
                case "health":
                    showHealth();
                    break;
                case "equip":
                    equipWeapon(userChoice);
                    break;
                case "attack":
                    attackMeleeWeapon();
                    break;
                case "fire":
                    attackRangedWeapon();
                    break;
                default:
                    youCannotWriteThat();
            }
        }

    }

    public void printItemsInRoom() {
        Room currentRoom = adventure.getCurrentRoom();
        for (Item item : currentRoom.getItems()) {
            System.out.println(item.getItemName());
            System.out.println(item.getItemDescription());
        }
    }

    public void goMove(String userChoice) {
        if (adventure.go(userChoice)) {
            System.out.println(adventure.getCurrentRoom().getDescription());
        } else {
            System.out.println("You cannot go that way");
        }
    }

    public void takeItem(String userChoice) {
        if (adventure.takeItem(userChoice)) {
            System.out.println("You have taken " + userChoice);
        } else {
            System.out.println("There is no item called " + userChoice);
        }
    }

    public void dropItem(String userChoice) {
        if (adventure.dropItem(userChoice)) {
            System.out.println("You have dropped " + userChoice);
        } else {
            System.out.println("There is no item called " + userChoice);
        }
    }

    public void showInventory() {
        System.out.println(adventure.getPlayer().getInventory());
    }

    public void welcome() {
        System.out.println("Welcome to the Adventure Game");
        System.out.println("Enter a command to proceed, and write help if your in doubt");
    }

    public String returnUserChoice() {
        return input.nextLine();
    }

    public void exiting() {
        System.out.println("Exiting Thanks for playing");
        System.exit(0);
    }

    public void help() {
        System.out.println("You can write go north, south, west or east to go in a direction" +
                "\nlook to see what room you are in, and a description" +
                "\ntake item to add the item in the room to your inventory" +
                "\ndrop item to drop an item in your inventory to currentroom you are in" +
                "\ninventory to check what's in your inventory" +
                "\neat to consume food" +
                "\nequip to arm yourself with a weapon" +
                "\nattack to strike with your melee weapon" +
                "\nfire to shoot with your ranged weapon" +
                "\nexit to leave the game");
    }

    public void itemDoesNotExist(String itemName) {
        System.out.println("There is no " + itemName);
    }

    public void looking() {
        Room currentRoom = adventure.getCurrentRoom();
        System.out.println("Looking");
        System.out.println(currentRoom.getName());
        System.out.println(currentRoom.getDescription());
        System.out.println("You also look around to see if there is any items of value");

        if (currentRoom.getItems().size() == 0) {
            System.out.println("There is no items");
        } else {
            for (Item item : currentRoom.getItems()) {
                System.out.println("You see a " + item.getItemName());
            }
        }

        if (currentRoom.getEnemies().size() == 0) {
            System.out.println("There is no enemies");
        } else {
            for (Enemy enemy : currentRoom.getEnemies()) {
                System.out.println("You see a " + enemy.getEnemyName());
                System.out.println(enemy.getEnemyDesription());
            }
        }

    }

    public void printItems(ArrayList<Item> items) {
        System.out.println(items.toString());
    }


    public void health() {
        System.out.println("Your current health is: " + adventure.getPlayer().getHealth());
    }

    public void eat(String name) {
        switch (adventure.playerEat(name)) {
            case EDIBLE:
                System.out.println("You ate some good " + name + " and you now have " + adventure.getPlayer().getHealth() + " health");
                break;
            case NOT_GOOD:
                System.out.println("You ate some bad " + name + " and you now have " + adventure.getPlayer().getHealth() + " health");
                break;
            case NOT_EDIBLE:
                System.out.println(name + " is not edible");
                break;
            case NOT_FOUND:
                System.out.println("There is no such food");
                break;
        }
    }

    public void equipWeapon(String currentWeapon) {
        switch (adventure.playerEquip(currentWeapon)) {
            case EQUIPPED:
                System.out.println("You equipped " + currentWeapon);
                break;
            case NOT_USABLE:
                System.out.println(currentWeapon + " is not a weapon");
                break;
            case NOT_FOUND:
                System.out.println("There is no such weapon");
                break;
        }
    }

    public void attackMeleeWeapon() {
        ReturnMessage attack = adventure.playerAttack();
        switch (attack) {
            case MELEE_ATTACK:
                System.out.println("You attacked with your Melee Weapon");
                break;
            case NOT_EQUIPPED:
                System.out.println("You do not have a Melee weapon equipped");
                break;
        }
    }

    public void attackRangedWeapon() {
        ReturnMessage attack = adventure.playerAttack();
        switch (attack) {
            case RANGED_ATTACK:
                System.out.println("You have fired with your Ranged weapon");
                break;
            case NO_AMMO:
                System.out.println("You have no ammo left");
                break;
            case NOT_EQUIPPED:
                System.out.println("You do not have a Ranged weapon equipped");
                break;
        }
    }


    public void showHealth() {
        int health = adventure.getPlayer().getHealth();
        if (health > 0 && 25 >= health) {
            System.out.println("Your health is " + health + " You are low in hp. Avoid fights and get food");
        }
        if (health > 25 && 50 > health) {
            System.out.println("Your health is " + health + " You are kinda low, be careful with fights and get food");
        }
        if(health == 50) {
            System.out.println("Your health is " + health + " You are in good condition");
        }
        if(health < 50) {
            System.out.println("Your health is " + health + " You are in peak condition");
        }

    }

    public void youCannotWriteThat() {
        System.out.println("You cannot write that");
    }

}
