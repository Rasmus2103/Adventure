public class MeleeWeapons extends Weapons {

    public MeleeWeapons(String weaponName, String weaponDescription, int damage) {
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
