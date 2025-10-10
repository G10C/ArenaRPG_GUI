package ArenaRPG;

import java.util.Scanner;
import java.util.Random;

public class Arena {
    private final Scanner input = new Scanner(System.in);
    private final Random rng = new Random();

    // Tweak these to balance combat
    private static final int CRIT_CHANCE_PERCENT = 20; // 20% = triple damage
    private static final int MISS_CHANCE_PERCENT = 10; // 10% = no damage

    private boolean roll(int percent) {
        return rng.nextInt(100) < percent;
    }

    // Apply miss/crit and print feedback for the attacker
    private int applyHitModifiers(int basePower, String attackerLabel) {
        if (roll(MISS_CHANCE_PERCENT)) {
            System.out.println(attackerLabel + " missed!");
            return 0;
        }
        int power = basePower;
        if (roll(CRIT_CHANCE_PERCENT)) {
            System.out.println("Critical hit by " + attackerLabel + "!");
            power *= 3;
        }
        return power;
    }

    public void battle(Warrior fighter, Enemy opponent) {

        while (fighter.isAlive() && opponent.isAlive()) {
            System.out.println("Your stats: " +
                    "\nBase Power: " + fighter.baseStrength +
                    ", Base Endurance: " + fighter.baseDefense +
                    ", Battle Power: " + fighter.playerPower() +
                    ", Equipped Weapon: " + (fighter.getWeapon() != null ? fighter.getWeapon().weaponName : "None"));
            System.out.println("Enemy's stats: " +
                    "\nBase Power: " + opponent.baseStrength +
                    ", Base Endurance: " + opponent.baseDefense +
                    ", Battle Power: " + opponent.enemyPower());

            System.out.println("Player Turn.");
            System.out.println("Your opponent Stands before you, what will you do?\n(on your keyboard type: z to attack, x to defend, or c to forfeit)");
            String action = input.nextLine();

            if (action.equals("z")) {
                // Player attacks
                int playerBase = fighter.playerPower();
                int playerMod = applyHitModifiers(playerBase, "you");
                opponent.takeHit(playerMod);

                // Enemy retaliates if alive
                if (opponent.isAlive()) {
                    System.out.println("Enemy Turn");
                    int enemyBase = opponent.enemyPower();
                    int enemyMod = applyHitModifiers(enemyBase, "the enemy");
                    fighter.takeHit(enemyMod); // updated signature
                }

            } else if (action.equals("x")) {
                // Player defends; enemy attacks with reduced effect
                int enemyBase = opponent.enemyPower();
                int enemyMod = applyHitModifiers(enemyBase, "the enemy");
                fighter.reducedHit(enemyMod); // updated signature

            } else if (action.equals("c")) {
                System.out.println("There is always next time, I suppose...\n(if you wish to play again, please rerun the code.)");
                return;

            } else {
                System.out.println("Invalid input. Please choose z, x, or c.");
            }

            if (fighter.health <= 0) {
                System.out.println("You have fallen in battle and lost...\n(if you wish to play again, please rerun the code.)");
            }
            if (opponent.health <= 0) {
                System.out.println("You have bested your opponent and won!!\n(if you wish to play again, please rerun the code.)");
            }
        }
    }
}