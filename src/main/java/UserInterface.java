import java.util.Scanner;

public class UserInterface {

    Scanner input = new Scanner(System.in);

    public void welcome() {
        System.out.println("Welcome to the Adventure Game");
    }

    public String returnUserChoice(){
        return input.nextLine();
    }

}
