package ArenaRPG;

import javafx.animation.PauseTransition;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Random;

public class Arena {
    private final Random rng = new Random();


    private final Warrior fighter;
    private final Enemy opponent;
    private final TextArea statsTextArea;
    private final TextField basePowerTextField;
    private final TextField baseDefenseTextField;
    private final TextField enemyBasePowerTextField;
    private final TextField enemyBaseDefenseTextField;
    private final TextField weaponTextField;
    private final TextField healthTextField;
    private final TextField enemyHealthTextField;
    private final ImageView enemeyImageView;

    // Tweak these to balance combat
    private static final int CRIT_CHANCE_PERCENT = 20; // 20% = triple damage
    private static final int MISS_CHANCE_PERCENT = 10; // 10% = no damage

    public Arena(Warrior fighter, Enemy opponent, TextArea statsTextArea, TextField basePowerTextField, TextField baseDefenseTextField,
                 TextField weaponTextField, TextField healthTextField, TextField enemyHealthTextField,
                 TextField enemyBaseDefenseTextField, TextField enemyBasePowerTextField, ImageView enemyImageView) {
        this.fighter = fighter;
        this.opponent = opponent;
        this.statsTextArea = statsTextArea;
        this.basePowerTextField = basePowerTextField;
        this.baseDefenseTextField = baseDefenseTextField;
        this.weaponTextField = weaponTextField;
        this.healthTextField = healthTextField;
        this.enemyHealthTextField = enemyHealthTextField;
        this.enemyBasePowerTextField = enemyBasePowerTextField;
        this.enemyBaseDefenseTextField = enemyBaseDefenseTextField;
        this.enemeyImageView = enemyImageView;

    }

    private boolean roll(int percent) {
        return rng.nextInt(100) < percent;
    }

    // Apply miss/crit and print feedback for the attacker
    private int applyHitModifiers(int basePower, String attackerLabel) {
        if (roll(MISS_CHANCE_PERCENT)) {
            statsTextArea.appendText("\n" + attackerLabel + " missed!");
            return 0;
        }
        int power = basePower;
        if (roll(CRIT_CHANCE_PERCENT)) {
            statsTextArea.appendText("\nCritical hit by " + attackerLabel + "!");

            power *= 3;
        }
        return power;
    }

    public void battle() {

        while (fighter.isAlive() && opponent.isAlive()) {
            makeBattleMove();
        }
    }

    private void makeBattleMove() {
    }

    public void makeBattleMove(String action) {
        statsTextArea.appendText("\n== Player Turn ==");

        if (action.equals("z")) {
            // Player attacks
            statsTextArea.appendText("\nYou attack!");
            int playerBase = fighter.playerPower();
            int playerMod = applyHitModifiers(playerBase, "You");
            if (playerMod > 0) {
                statsTextArea.appendText("\nYou deal " + playerMod + " damage!");
            }
            opponent.takeHit(playerMod);
            statsTextArea.appendText("\nEnemy health: " + opponent.health);

            // Enemy retaliates if alive
            if (opponent.isAlive()) {
                statsTextArea.appendText("\n\n== Enemy Turn ==");
                statsTextArea.appendText("\nThe enemy attacks!");

                // Play Enemy attacking animation
                try {
                    Image enemyAttackGif = new Image(getClass().getResourceAsStream("/Images/EnemyAttack.gif"));
                    enemeyImageView.setImage(enemyAttackGif);

                    // 2-second animation timer
                    PauseTransition pause = new PauseTransition(Duration.seconds(2));

                    // Back to idle after animation
                    pause.setOnFinished(event -> {
                        // Reset back to default image
                        Image defaultImage = new Image(getClass().getResourceAsStream("/Images/EnemyIdle.png"));
                        enemeyImageView.setImage(defaultImage);
                    });

                    pause.play();

                } catch (Exception e) {
                    System.out.println("EnemyAttack.gif could not be loaded: " + e.getMessage());
                }

            int enemyBase = opponent.enemyPower();
                int enemyMod = applyHitModifiers(enemyBase, "The enemy");
                if (enemyMod > 0) {
                    statsTextArea.appendText("\nThe enemy deals " + enemyMod + " damage!");
                }
                fighter.takeHit(enemyMod);
                statsTextArea.appendText("\nYour health: " + fighter.health);
            }


        } else if (action.equals("x")) {
            // Player defends; enemy attacks with reduced effect
            statsTextArea.appendText("\nYou brace yourself and defend!");
            statsTextArea.appendText("\n\n== Enemy Turn ==");
            statsTextArea.appendText("\nThe enemy attacks!");

            // Play Enemy attacking animation
            try {
                Image enemyAttackGif = new Image(getClass().getResourceAsStream("/Images/EnemyAttack.gif"));
                enemeyImageView.setImage(enemyAttackGif);

                // 2-second animation timer
                PauseTransition pause = new PauseTransition(Duration.seconds(2));

                // Back to idle after animation
                pause.setOnFinished(event -> {
                    // Reset back to default image
                    Image defaultImage = new Image(getClass().getResourceAsStream("/Images/EnemyIdle.png"));
                    enemeyImageView.setImage(defaultImage);
                });

                pause.play();

            } catch (Exception e) {
                System.out.println("EnemyAttack.gif could not be loaded: " + e.getMessage());
            }

            int enemyBase = opponent.enemyPower();
            int enemyMod = applyHitModifiers(enemyBase, "The enemy");
            if (enemyMod > 0) {
                // Halves incoming damage
                statsTextArea.appendText("\nThe enemy deals " + enemyMod + " damage, but your defense reduces it!");
            }
            fighter.reducedHit(enemyMod);
            statsTextArea.appendText("\nYour health: " + fighter.health);

        } else if (action.equals("c")) {
            statsTextArea.appendText("\n\nYou have forfeited the battle.");
            statsTextArea.appendText("\nThere is always next time, I suppose...\n(Click 'Forfit/Reset' to return to the armory)");

            return;

        }

        // Update stat fields
        basePowerTextField.setText(" " + fighter.baseStrength);
        baseDefenseTextField.setText(" " + fighter.baseDefense);
        healthTextField.setText(" " + fighter.health);

        // Update Enemy Stats
        enemyHealthTextField.setText(" " + opponent.health);
        enemyBaseDefenseTextField.setText(" " +opponent.baseDefense);
        enemyBasePowerTextField.setText(" " + opponent.baseStrength);

        // Check for the end of battle
        if (fighter.health <= 0) {
            statsTextArea.appendText("\n\n== DEFEAT ==");
            statsTextArea.appendText("\nYou have fallen in battle and lost...");
        } else if (opponent.health <= 0) {
            statsTextArea.appendText("\n\n=== VICTORY ===");
            statsTextArea.appendText("\nYou have bested your opponent and won!!");
        } else {
            statsTextArea.appendText("\nYour opponent Stands before you, what will you do?");
        }
    }
}
