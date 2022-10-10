package com.example.krydsogbolle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class KrydsOgBolleApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(KrydsOgBolleApplication.class.getResource("KrydsOgBolle.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Kryds og Bolle");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}