public class Food extends Item {

    private int healthPoints;

    // Når man extender skal man implementerer en construktor der macher den i super klassen. Super i denne sammenhæng er Item, da vi extender den.
    //Ydermere har vi til food tilføjet healthpoint hvilket er muligt når man "overloader" en constructor
    //Altså bruger super constructoren men tilføjer noget ekstra = Overload
    public Food(String itemName, String itemDescription, int healthPoints) {
        super(itemName, itemDescription);
        this.healthPoints = healthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }
}
