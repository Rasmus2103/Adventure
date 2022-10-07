public abstract class Weapons extends Item {

    private int damage;
    private int ammo;
    public Weapons(String itemName, String itemDescription, int damage) {
        super(itemName, itemDescription);
        this.damage = damage;
    }

    public Weapons(String itemName, String itemDescription, int damage, int ammo) {
        super(itemName, itemDescription);
        this.damage = damage;
        this.ammo = ammo;
    }

    //public abstract ReturnMessage attack();

    public int getDamage() {
        return damage;
    }

    public abstract ReturnMessage attack();
}
