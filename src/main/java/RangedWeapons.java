public class RangedWeapons extends Weapons {

    private int ammuition;
    Integer ammo = 1;
    public RangedWeapons(String weaponName, String weaponDescription, int damage, int ammuition) {
        super(weaponName, weaponDescription, damage);
        this.ammuition = ammuition;
    }

    @Override
    public ReturnMessage attack() {
        if(ammo > 0) {
            ammo += -1;
            return ReturnMessage.RANGED_ATTACK;
        }
        else {
            return ReturnMessage.NO_AMMO;
        }
    }

    public int getAmmuition() {
        return ammuition;
    }

    public void setAmmuition(int leftAmmuition) {
        ammuition = leftAmmuition;
    }

}
