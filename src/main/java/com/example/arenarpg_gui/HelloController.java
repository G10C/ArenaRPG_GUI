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
    protected void onAttackButtonClick(){
        if (textBattleSimulator != null){
            textBattleSimulator.makeFightMove("z");
        }
    }
//    @FXML
//    protected void onMoveButtonClick(){
//        textBattleSimulator.makeFightMove();
//    }


    @FXML
    protected void onStartGameButtonClick() {
        textBattleSimulator = new TextBattleSimulator(gameTextArea, basePowerTextField);
        gameTextArea.setText("New game");
        textBattleSimulator.playGame();





    }
}
