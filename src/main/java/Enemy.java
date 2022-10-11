public class Enemy {
    private String enemyName;
    private String enemyDesription;
    private Weapon currentWeapon;
    private int health;
    private int damage;

    public Enemy(String enemyName, String enemyDesription, int health, Weapon weapons) {
        this.enemyName = enemyName;
        this.enemyDesription = enemyDesription;
        this.health = health;
        this.currentWeapon = weapons;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public String getEnemyDesription() {
        return enemyDesription;
    }
    public int getHealth() {
        return health;
    }
    public int getDamage() {
        return damage;
    }

}
