public class Main {
    public static void main(String[] args) {
        //Fjernet adventure objektet da det ikke bliver brugt
        Adventure adventure = new Adventure();
        UserInterface userInterface = new UserInterface();
        adventure.run(adventure, userInterface);
    }
}
