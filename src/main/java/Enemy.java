public class Enemy {
    private String enemyName;
    private String enemyDesription;
    private Weapon currentWeapon;
    private int health;
    private int damage;

    public Enemy(String enemyName, String enemyDesription, int health, Weapon weapon) {
        this.enemyName = enemyName;
        this.enemyDesription = enemyDesription;
        this.health = health;
        this.currentWeapon = weapon;
        this.damage = weapon.getDamage();
    }

    public String getEnemyName() {
        return enemyName;
    }

    public String getEnemyDescription() {
        return enemyDesription;
    }
    public int getHealth() {
        return health;
    }
    public int getDamage() {
        return damage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }
}
