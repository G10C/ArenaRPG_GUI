package ArenaRPG;

public class Enemy {
    String name;
    int health;
    int baseStrength;
    int baseDefense;
    int enemyWeaponStrength;


    public Enemy() {
        this.name = "Zark";
        this.health = 100;
        this.baseStrength = 7;
        this.baseDefense = 6;
    }

    public String getName() {
        return name;
    }

    public void setEnemyWeaponStrength(int enemyWeaponStrength) {
        this.enemyWeaponStrength = enemyWeaponStrength;
    }

    public int getEnemyWeaponStrength() {
        return enemyWeaponStrength;
    }

    public int enemyPower() {
        setEnemyWeaponStrength(6);
        int enemyPower = (baseStrength + getEnemyWeaponStrength());
        return enemyPower;
    }


    public boolean isAlive() {
        if (health >= 1) {
            return true;
        }
        return false;
    }

    public void takeHit(int playerPower) {
        int enemyDmg = (playerPower - baseDefense);
        if (enemyDmg < 0){
            enemyDmg = 0;
        }
        health = (health - enemyDmg);
        if (health < 0) {
            health = 0;
        }
        System.out.println("You attacked your opponent and dealt " + enemyDmg + " damage!");
        System.out.println(name + "'s current health: " + health);

    }
}
