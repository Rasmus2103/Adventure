public class RangedWeapons extends Weapons {

    private int ammo = 5;
    public RangedWeapons(String weaponName, String weaponDescription, int damage) {
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
