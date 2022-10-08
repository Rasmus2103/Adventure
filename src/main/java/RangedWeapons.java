public class RangedWeapons extends Weapons {

    private int ammo = 3;
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

}
