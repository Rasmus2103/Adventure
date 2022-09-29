import java.util.Scanner;

public class UserInterface {

    Scanner input = new Scanner(System.in);

    public void welcome() {
        System.out.println("Welcome to the Adventure Game");
    }

    public String returnUserChoice(){
        return input.nextLine();
    }

    public void exiting(){
        System.out.println("Exiting Thanks for playing");
    }

    public void help(){
        System.out.println("You can write go north, south, west or east to go in a direction" +
                " \nlook to see what room you are in, and a description" +
                " \nexit to leave the game");
    }

    public void lokking(){
        System.out.println("Looking");
    }

    public void cr(){

    }

}
