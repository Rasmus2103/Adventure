public class RangedWeapon extends Weapon {

    private int ammo = 5;
    public RangedWeapon(String weaponName, String weaponDescription, int damage) {
        super(weaponName, weaponDescription, damage);
    }

    @Override
    public ReturnMessage attack() {
       if(ammo == 0) {
           return ReturnMessage.NO_AMMO;
       }
       ammo--;
       return ReturnMessage.RANGED_ATTACK;
    }

    public String toString() {
        return "Ammo: " + ammo;
    }


}
