package com.example.arenarpg_gui;


import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import ArenaRPG.Arena;
import ArenaRPG.Enemy;
import ArenaRPG.Warrior;
import ArenaRPG.Weapon;
import ArenaRPG.Armory;
import ArenaRPG.MainHub;
import ArenaRPG.TextBattleSimulator;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class HelloController {
    private Arena arena;
    private Armory armory;
    private Enemy enemy;
    private Warrior warrior;
    private Weapon weapon;
    private MainHub mainHub;
    private TextBattleSimulator textBattleSimulator;


    @FXML
    private TextArea gameTextArea;

    @FXML
    private TextField basePowerTextField;

    @FXML
    private TextField baseDefenseTextField;

    @FXML
    private TextField enemyBasePowerTextField;

    @FXML
    private TextField enemyBaseDefenseTextField;

    @FXML
    private TextField weaponTextField;

    @FXML
    private TextField healthTextField;

    @FXML
    private TextField enemeyHealthTextField;

    @FXML
    private VBox weaponSelectionBox;

    @FXML
    private VBox battleBox;

    @FXML
    private Button startGameButton;

    @FXML
    private Button forfeitButton;

    @FXML
    private ImageView gameImageView;

    @FXML
    private ImageView playerImageView;

    @FXML
    private ImageView enemyImageView;

    @FXML
    protected void onAttackButtonClick() {
        if (textBattleSimulator != null) {
            // Check if equipped weapon is a sword and play attack animation
            if (textBattleSimulator.fighter.getWeapon() != null &&
                    textBattleSimulator.fighter.getWeapon().weaponName.equalsIgnoreCase("Sword")) {
                try {
                    Image swordAttackGif = new Image(getClass().getResourceAsStream("/Images/SwordAttack.gif"));
                    playerImageView.setImage(swordAttackGif);

                    // 2-second animation timer
                    PauseTransition pause = new PauseTransition(Duration.seconds(2));

                    // Back to idle after animation
                    pause.setOnFinished(event -> {
                        // Reset back to default image
                        Image defaultImage = new Image(getClass().getResourceAsStream("/Images/SwordIdle.png"));
                        playerImageView.setImage(defaultImage);
                    });

                    pause.play();

                } catch (Exception e) {
                    System.out.println("SwordAttack.gif could not be loaded: " + e.getMessage());
                }
            }

            // Check if equipped weapon is an axe and play attack animation
            if (textBattleSimulator.fighter.getWeapon() != null &&
                    textBattleSimulator.fighter.getWeapon().weaponName.equalsIgnoreCase("Axe")) {
                try {
                    Image axeAttackGif = new Image(getClass().getResourceAsStream("/Images/AxeAttack.gif"));
                    playerImageView.setImage(axeAttackGif);

                    // 2-second animation timer
                    PauseTransition pause = new PauseTransition(Duration.seconds(2));

                    // Back to idle after animation
                    pause.setOnFinished(event -> {
                        // Reset back to default image
                        Image defaultImage = new Image(getClass().getResourceAsStream("/Images/AxeIdle.png"));
                        playerImageView.setImage(defaultImage);
                    });

                    pause.play();

                } catch (Exception e) {
                    System.out.println("AxeAttack.gif could not be loaded: " + e.getMessage());
                }
            }

            // Check if equipped weapon is a lance and play attack animation
            if (textBattleSimulator.fighter.getWeapon() != null &&
                    textBattleSimulator.fighter.getWeapon().weaponName.equalsIgnoreCase("Lance")) {
                try {
                    Image lanceAttackGif = new Image(getClass().getResourceAsStream("/Images/LanceAttack.gif"));
                    playerImageView.setImage(lanceAttackGif);

                    // 2-second animation timer
                    PauseTransition pause = new PauseTransition(Duration.seconds(2));

                    // Back to idle after animation
                    pause.setOnFinished(event -> {
                        // Reset back to default image
                        Image defaultImage = new Image(getClass().getResourceAsStream("/Images/LanceIdle.png"));
                        playerImageView.setImage(defaultImage);
                    });

                    pause.play();

                } catch (Exception e) {
                    System.out.println("LanceAttack.gif could not be loaded: " + e.getMessage());
                }
            }
            textBattleSimulator.makeFightMove("z");
        }
    }

    @FXML
    protected void onDefendButtonClick() {
        if (textBattleSimulator != null) {
            // Check if equipped weapon is a sword and play defend animation
            if (textBattleSimulator.fighter.getWeapon() != null &&
                    textBattleSimulator.fighter.getWeapon().weaponName.equalsIgnoreCase("Sword")) {
                try {
                    Image swordDefendGif = new Image(getClass().getResourceAsStream("/Images/SwordDefend.png"));
                    playerImageView.setImage(swordDefendGif);

                    // 2-second animation timer
                    PauseTransition pause = new PauseTransition(Duration.seconds(2));

                    // Back to idle after animation
                    pause.setOnFinished(event -> {
                        // Reset back to default image
                        Image defaultImage = new Image(getClass().getResourceAsStream("/Images/SwordIdle.png"));
                        playerImageView.setImage(defaultImage);
                    });

                    pause.play();

                } catch (Exception e) {
                    System.out.println("SwordDefend.gif could not be loaded: " + e.getMessage());
                }
            }

            // Check if equipped weapon is an axe and play defend animation
            if (textBattleSimulator.fighter.getWeapon() != null &&
                    textBattleSimulator.fighter.getWeapon().weaponName.equalsIgnoreCase("Axe")) {
                try {
                    Image axeDefendGif = new Image(getClass().getResourceAsStream("/Images/AxeDefend.png"));
                    playerImageView.setImage(axeDefendGif);

                    // 2-second animation timer
                    PauseTransition pause = new PauseTransition(Duration.seconds(2));

                    // Back to idle after animation
                    pause.setOnFinished(event -> {
                        // Reset back to default image
                        Image defaultImage = new Image(getClass().getResourceAsStream("/Images/AxeIdle.png"));
                        playerImageView.setImage(defaultImage);
                    });

                    pause.play();

                } catch (Exception e) {
                    System.out.println("AxeDefend.gif could not be loaded: " + e.getMessage());
                }
            }

            // Check if equipped weapon is a lance and play defend animation
            if (textBattleSimulator.fighter.getWeapon() != null &&
                    textBattleSimulator.fighter.getWeapon().weaponName.equalsIgnoreCase("Lance")) {
                try {
                    Image lanceDefendGif = new Image(getClass().getResourceAsStream("/Images/LanceDefend.png"));
                    playerImageView.setImage(lanceDefendGif);

                    // 2-second animation timer
                    PauseTransition pause = new PauseTransition(Duration.seconds(2));

                    // Back to idle after animation
                    pause.setOnFinished(event -> {
                        // Reset back to default image
                        Image defaultImage = new Image(getClass().getResourceAsStream("/Images/LanceIdle.png"));
                        playerImageView.setImage(defaultImage);
                    });

                    pause.play();

                } catch (Exception e) {
                    System.out.println("LanceDefend.gif could not be loaded: " + e.getMessage());
                }
            }
            textBattleSimulator.makeFightMove("x");
        }
    }

    @FXML
    protected void onForfeitButtonClick() {
        if (forfeitButton.getText().equals("Forfeit")) {
            // Forfeit the game
            if (textBattleSimulator != null) {
                textBattleSimulator.makeFightMove("c");
            }
            // Change button to Reset
            forfeitButton.setText("Reset");
        } else {
            // Reset by starting a new game
            forfeitButton.setText("Forfeit");
            onStartGameButtonClick();

        }
    }


    @FXML
    protected void onStartGameButtonClick() {
        textBattleSimulator = new TextBattleSimulator(gameTextArea, basePowerTextField, baseDefenseTextField, weaponTextField, healthTextField
        , enemeyHealthTextField, enemyBasePowerTextField, enemyBaseDefenseTextField, enemyImageView);


        //Change image to armory
        try{
            Image armoryImage = new Image(getClass().getResourceAsStream("/Images/Armory.jpg"));
            gameImageView.setImage(armoryImage);
        } catch (Exception e) {
            System.out.println("Image could not be loaded: " + e.getMessage());
        }
        // Display weapon selection screen
        gameTextArea.setText("Welcome to the Arena!\n\n" +
                "Select your weapon:\n\n" +
                "Sword - Power: 8\n" +
                "Axe - Power: 12\n" +
                "Lance - Power: 9\n");

        // Show weapon selection buttons, hide start button and battle buttons
        if (weaponSelectionBox != null) {
            weaponSelectionBox.setVisible(true);
            weaponSelectionBox.setManaged(true);
        }
        if (battleBox != null) {
            battleBox.setVisible(false);
            battleBox.setManaged(false);
        }
        if (startGameButton != null) {
            startGameButton.setVisible(false);
            startGameButton.setManaged(false);
        }

        // Initialize armory
        textBattleSimulator.armed();
    }

    @FXML
    protected void onWeaponSelected(String weaponType) {
        if (textBattleSimulator != null) {
            Weapon selectedWeapon = null;

            switch (weaponType) {
                case "sword":
                    selectedWeapon = new Weapon("Sword", 8);
                    Image SwordImage = new Image(getClass().getResourceAsStream("/Images/SwordIdle.png"));
                    playerImageView.setImage(SwordImage);
                    break;
                case "axe":
                    selectedWeapon = new Weapon("Axe", 12);
                    Image AxeImage = new Image(getClass().getResourceAsStream("/Images/AxeIdle.png"));
                    playerImageView.setImage(AxeImage);
                    break;
                case "lance":
                    selectedWeapon = new Weapon("Lance", 9);
                        Image LanceImage = new Image(getClass().getResourceAsStream("/Images/LanceIdle.png"));
                        playerImageView.setImage(LanceImage);
                    break;
            }

            Image enemyImage = new Image(getClass().getResourceAsStream("/Images/EnemyIdle.png"));
            enemyImageView.setImage(enemyImage);


            if (selectedWeapon != null) {
                textBattleSimulator.fighter.setWeapon(selectedWeapon);
                gameTextArea.setText("You have equipped the " + selectedWeapon.weaponName + ".\n" +
                        "Your battle strength is now: " + textBattleSimulator.fighter.playerPower() + "\n\n" +
                        "Now that you have armed yourself,\nyou may embrace the thrill of battle.\n\n" +
                        "Use the battle controls to fight!");

                // Update stat display
                weaponTextField.setText(selectedWeapon.weaponName);
                basePowerTextField.setText(String.valueOf(textBattleSimulator.fighter.baseStrength));
                baseDefenseTextField.setText(String.valueOf(textBattleSimulator.fighter.baseDefense));
                healthTextField.setText(String.valueOf(textBattleSimulator.fighter.health));

                //Enemy Stats
                enemyBasePowerTextField.setText(String.valueOf(textBattleSimulator.opponent.baseStrength));
                enemyBaseDefenseTextField.setText(String.valueOf(textBattleSimulator.opponent.baseDefense));
                enemeyHealthTextField.setText(String.valueOf(textBattleSimulator.opponent.health));


                // Hide weapon selection, show battle buttons
                if (weaponSelectionBox != null) {
                    weaponSelectionBox.setVisible(false);
                    weaponSelectionBox.setManaged(false);
                }
                if (battleBox != null) {
                    battleBox.setVisible(true);
                    battleBox.setManaged(true);
                }

                //Change image to arena
                try{
                    Image arenaImage = new Image(getClass().getResourceAsStream("/Images/Arena.jpg"));
                    gameImageView.setImage(arenaImage);
                } catch (Exception e) {
                    System.out.println("Image could not be loaded: " + e.getMessage());
                }
            }
        }
    }

    @FXML
    protected void onSwordSelected() {
        onWeaponSelected("sword");
    }

    @FXML
    protected void onAxeSelected() {
        onWeaponSelected("axe");
    }

    @FXML
    protected void onLanceSelected() {
        onWeaponSelected("lance");
    }
}

