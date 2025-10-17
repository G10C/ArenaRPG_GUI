package com.example.arenarpg_gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Capstone.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("ArenaRPG");
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Icon/ArenaRPG.png"))));
        try{
            Taskbar taskbar = Taskbar.getTaskbar();
            java.awt.Image dockIcon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Icon/ArenaRPG.png"));
            taskbar.setIconImage(dockIcon);
        } catch (Exception e) {
            System.out.println("Icon not found" + e.getMessage());
        }
        stage.setScene(scene);
        stage.show();
    }
}
