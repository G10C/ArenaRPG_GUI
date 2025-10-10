package ArenaRPG;

public class Weapon {
    String weaponName;
    int weaponStrength;


    public Weapon(String weaponName, int weaponStrength) {
        this.weaponName = weaponName;
        this.weaponStrength = weaponStrength;
    }

    @Override
    public String toString() {
        return "Weapon: " + weaponName +
                ", Strength: " + weaponStrength +
                '.';
    }
}
