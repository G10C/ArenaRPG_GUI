package com.example.arenarpg_gui;


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
import javafx.event.ActionEvent;

public class HelloController {
    private Arena arena;
    private Armory armory;
    private Enemy enemy;
    private Warrior warrior;
    private Weapon weapon;
    private MainHub mainHub;
    private TextBattleSimulator textBattleSimulator;


    @FXML
    private Label welcomeText;

    @FXML
    private TextField nameInput;
    ;
    private boolean gameStarted = false;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to ArenaRPG!");
    }

    @FXML
    protected void onStartGameClick() {
        if (!gameStarted) {
            // Initialize the game
            textBattleSimulator = new TextBattleSimulator();
            warrior = new Warrior();

            String name = nameInput.getText().trim();
            if (name.isEmpty()) {
                welcomeText.setText("Please enter your warrior name!");
                return;
            }

            warrior.setName(name);
            welcomeText.setText("Welcome to the Text Battle Simulator, " + name + "!\nGame initialized. Ready to play!");
            gameStarted = true;
        } else {
            // Start the actual game
            textBattleSimulator.playGame();
            welcomeText.setText("Game started! Check console for interactions.");
        }
    }
}
