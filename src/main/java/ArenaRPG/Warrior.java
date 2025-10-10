package ArenaRPG;

public class Warrior {
    String name;
    int health;
    int baseStrength;
    int baseDefense;
    int weaponStrength;
    private Weapon weapon;



    public Warrior() {
        this.name = "???";
        this.health = 100;
        this.baseStrength = 5;
        this.baseDefense = 6;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        this.weaponStrength = weapon.weaponStrength;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int playerPower() {
        return baseStrength + (weapon != null ? weapon.weaponStrength : 0);
    }


    public boolean isAlive() {
        if (health >= 1) {
            return true;
        }
        return false;
    }

    public void takeHit(int enemyPower) {
        int playerDmg = (enemyPower - baseDefense);
        if (playerDmg < 0){
            playerDmg = 0;
        }
        health -= playerDmg;
        if (health <= 0) {
        health = 0;
        }

        System.out.println("You took " + playerDmg + " damage!");
        System.out.println("Your current health is " + health);
    }

    public void reducedHit(int enemyPower) {
        int reducedDmg = enemyPower / 3; //reduces incoming power before defense
        if (reducedDmg < 0){
            reducedDmg = 0;
        }

        health -= reducedDmg;
        if (health <= 0) {
            health = 0;
        }
        System.out.println("You braced for impact and take " + reducedDmg + " reduced damage.");
        System.out.println("Your current health is " + health);
    }
}
