package com.example.krydsogbolle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
//import javafx.scene.media.*;
//import java.io.File;

public class KrydsOgBolleController {

    /*String musicFile = "";

    Media sound = new Media(new File(musicFile).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(sound);
    mediaPlayer.play();*/

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Game game;

    @FXML
    private Label infoBox;

    @FXML
    private ListView<Image> imageListView;

    @FXML
    private ImageView billedeBox;

    private final ListView<Image> ObservableList<Image> images = FXCollections.observableArrayList();

    @FXML
    private GridPane gridPane;

    @FXML
    private Label test;

    @FXML
    void trykKnap(ActionEvent event) {

        Button knap = (Button) event.getSource(); //Henter hvilken knap der bliver trykket på.
        int row = (GridPane.getRowIndex(knap) == null) ? 0 : GridPane.getRowIndex(knap); //Laver et row variabel med knappens row index i GridPane containeren.
        int col = (GridPane.getColumnIndex(knap) == null) ? 0 : GridPane.getColumnIndex(knap); //Laver et column variabel med knappens row index i GridPane containeren.

        //Checker om feltet spilleren har valgt er blank og om der er blevet placeret mindre end 6 brikker.
        if (game.fåBoard().fåFelter()[row][col].fåSquare().isBlank() && game.fåSpilTurTæller()<6) {
            game.spilTur(row, col); //Bruger knappens xy koordinater til at sætte spillerens tur ind i et 2D array af spillebrættet.
            knap.setText(game.fåSpiller());
            game.næsteSpiller(); //Skifter til den anden spiller (sætter næste tur til O fra X eller omvendt).
        }
        //Hvis 6 brikker er placeret på spillebrættet, så bruges metoden flytBrik() i stedet.
        else {
            game.flytBrik(row, col);
        }

    }

    @FXML
    void trykNytSpil(ActionEvent event) {

        try {
            root = FXMLLoader.load(getClass().getResource("KrydsOgBolle.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            game.nytSpil();
            for (Node n : gridPane.getChildren()) { //Kigger alle noder igennem der ligger i GridPane og sletter deres text.
                Button knap = (Button) n;
                knap.setText("");
            }
        }
        catch (ClassCastException | IOException e) { //ClassCastException ved runtime, der bliver fundet en "Group" node i loopen?
            System.out.println(e);
        }

    }

    @FXML
    void trykOpgiv(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("KrydsOgBolleFront.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        game.opgiv();

        Image image = new Image(getClass().getResourceAsStream("/images/Loser.png"));
        System.out.println(getClass().getResourceAsStream("/images/Loser.png"));
        billedeBox.setImage(image);

    }

    public void initialize() {

        billedeBox = new ImageView("file:Forside.png");
        game = new Game();
        game.nytSpil();

    }

    //Skifter scene fra KrydsOgBolleFront.fxml til KrydsOgBolle.fxml
    @FXML
    public void skiftScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("KrydsOgBolle.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
