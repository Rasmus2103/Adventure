public class MeleeWeapon extends Weapon {

    public MeleeWeapon(String weaponName, String weaponDescription, int damage) {
        super(weaponName, weaponDescription, damage);
    }

    @Override
    public ReturnMessage attack() {
        return ReturnMessage.MELEE_ATTACK;
    }

    public String toString () {
        return super.toString();
    }
}
