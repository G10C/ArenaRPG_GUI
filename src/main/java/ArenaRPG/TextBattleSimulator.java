package ArenaRPG;

import java.util.Scanner;

public class TextBattleSimulator {
    Warrior fighter;
    Armory armory;
    Arena arena;
    Enemy opponent;


    public TextBattleSimulator() {
        fighter = new Warrior();
        arena = new Arena();
        armory = new Armory();
        opponent = new Enemy();


    }

    public void playGame() {
        armed();
        gearUp();
        fight();
    }


    public void armed() {
        armory.createAllWeapons();
        armory.displayArmory();
    }

    public void gearUp() {

        Scanner input = new Scanner(System.in);
        System.out.println("Select a weapon (on your keyboard type: s for a sword, a for an axe, l for a lance, i for iron knuckles, and n for no weapon): ");
        String action = input.nextLine();

        Weapon selectedWeapon = null;

        if (action.equals("s")) {
            selectedWeapon = new Weapon("Sword", 8);
        } else if (action.equals("a")) {
            selectedWeapon = new Weapon("Axe", 12);
        } else if (action.equals("l")) {
            selectedWeapon = new Weapon("Lance", 9);
        } else if (action.equals("i")) {
            selectedWeapon = new Weapon("Iron Knuckles", 6);
        } else if (action.equals("n")) {
            selectedWeapon = new Weapon("No Weapon", 1);
        }

        if (selectedWeapon != null) {
            fighter.setWeapon(selectedWeapon);
            System.out.println("You have equipped the " + selectedWeapon.weaponName + ".");
            System.out.println("Your battle strength is now: " + fighter.playerPower());
        }

        System.out.println();
        System.out.println("Now that you have armed yourself,\nyou may embrace the thrill of battle.");
        System.out.println();

    }


    public void fight() {
        arena.battle(fighter, opponent);

    }

}