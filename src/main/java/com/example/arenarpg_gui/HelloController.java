package com.example.arenarpg_gui;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
import javafx.scene.image.ImageView;

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
    private TextField weaponTextField;

    @FXML
    private TextField healthTextField;

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
    protected void onAttackButtonClick() {
        if (textBattleSimulator != null) {
            textBattleSimulator.makeFightMove("z");
        }
    }

    @FXML
    protected void onDefendButtonClick() {
        if (textBattleSimulator != null) {
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
//        if (textBattleSimulator != null) {
//            textBattleSimulator.makeFightMove("c");
        }
    }
//    @FXML
//    protected void onMoveButtonClick(){
//        textBattleSimulator.makeFightMove();
//    }


    @FXML
    protected void onStartGameButtonClick() {
        textBattleSimulator = new TextBattleSimulator(gameTextArea, basePowerTextField, baseDefenseTextField, weaponTextField, healthTextField);
//        gameTextArea.setText("New game");
//        textBattleSimulator.playGame();

        // Display weapon selection screen
        gameTextArea.setText("Welcome to the Arena!\n\n" +
                "Select your weapon:\n\n" +
                "Sword - Power: 8\n" +
                "Axe - Power: 12\n" +
                "Lance - Power: 9\n" +
                "Iron Knuckles - Power: 6\n" +
                "No Weapon - Power: 1\n\n");

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
                    break;
                case "axe":
                    selectedWeapon = new Weapon("Axe", 12);
                    break;
                case "lance":
                    selectedWeapon = new Weapon("Lance", 9);
                    break;
                case "ironKnuckles":
                    selectedWeapon = new Weapon("Iron Knuckles", 6);
                    break;
                case "noWeapon":
                    selectedWeapon = new Weapon("No Weapon", 1);
                    break;
            }

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

                // Hide weapon selection, show battle buttons
                if (weaponSelectionBox != null) {
                    weaponSelectionBox.setVisible(false);
                    weaponSelectionBox.setManaged(false);
                }
                if (battleBox != null) {
                    battleBox.setVisible(true);
                    battleBox.setManaged(true);
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

    @FXML
    protected void onIronKnucklesSelected() {
        onWeaponSelected("ironKnuckles");
    }

    public void onNoWeaponSelected() {
        onWeaponSelected("onNoWeaponSelected");
    }
}

