package ArenaRPG;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.util.Scanner;

public class TextBattleSimulator {
    public Warrior fighter;
    Armory armory;
    Arena arena;
    public Enemy opponent;
    TextArea statsTextArea;
    TextField basePowerTextField;
    TextField baseDefenseTextField;
    TextField weaponTextField;
    TextField healthTextField;
    TextField enemeyHealthTextField;
    TextField enemyBasePowerTextField;
    TextField enemyBaseDefenseTextField;
    ImageView enemyImageView;


    public TextBattleSimulator(TextArea statsTextArea, TextField basePowerTextField,
                               TextField baseDefenseTextField, TextField weaponTextField, TextField healthTextField, TextField enemeyHealthTextField
    , TextField enemyBasePowerTextField, TextField enemyBaseDefenseTextField, ImageView enemyImageView) {
        this.statsTextArea = statsTextArea;
        this.basePowerTextField = basePowerTextField;
        this.baseDefenseTextField = basePowerTextField;
        this.weaponTextField = weaponTextField;
        this.healthTextField = healthTextField;
        this.enemeyHealthTextField = enemeyHealthTextField;
        this.enemyBasePowerTextField = enemyBasePowerTextField;
        this.enemyBaseDefenseTextField = enemyBaseDefenseTextField;
        this.enemyImageView = enemyImageView;


        fighter = new Warrior();
        opponent = new Enemy();
        arena = new Arena(fighter, opponent, statsTextArea, basePowerTextField, baseDefenseTextField, weaponTextField,
                healthTextField, enemeyHealthTextField, enemyBasePowerTextField, enemyBaseDefenseTextField, enemyImageView);
        armory = new Armory();



    }

    public void playGame() {
        armed();
        gearUp();
    }

    public void makeFightMove(String action) {
        arena.makeBattleMove(action);
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
        arena.battle();

    }

}