package com.example.krydsogbolle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import java.io.IOException;

public class KrydsOgBolleApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(KrydsOgBolleApplication.class.getResource("KrydsOgBolleFront.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Kryds og Bolle");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}