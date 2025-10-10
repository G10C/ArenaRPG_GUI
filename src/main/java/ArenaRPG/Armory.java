package ArenaRPG;


public class Armory {
    int lastArmsIndex = 0;
    Weapon[] weapons = new Weapon[5];



    public void addToArmory(String weaponName, int weaponStrength) {
        if (lastArmsIndex >= 5) {
            System.out.println("Here are the weapons available");
        }

        weapons[lastArmsIndex] = new Weapon (weaponName, weaponStrength);
        lastArmsIndex++;
    }

    public void addWeapons(String weaponName, int weaponStrength){
        Weapon wep = new Weapon(weaponName, weaponStrength);
        addToArmory(wep.weaponName, wep.weaponStrength);

    }


    public void createAllWeapons() {
        addWeapons("sword", 8);
        addWeapons("axe", 12);
        addWeapons("lance", 9);
        addWeapons("ironKnuckles", 6);
        addWeapons("noWeapon", 1);

    }

    public void displayArmory(){
        System.out.println("This is the Arena's armory,\nhere are the weapons Available: ");
       for (int i = 0; i < lastArmsIndex; i++){
           System.out.println((weapons[i].toString()));
       }
    }

}


