package com.example.krydsogbolle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;

public class KrydsOgBolleController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Game game;

    @FXML
    private GridPane gridPane;

    //Styrer hvor spilleren placerer sin brik og placerer den, og holder øje med hvem der vinder.
    @FXML
    void trykKnap(ActionEvent event) throws IOException {

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

        //Hvis en spiller har vundet, så vis en vinder skærm.
        if (game.fåVinder().equals("X")) {
            visVinderXSkærm(event);
        }
        else if (game.fåVinder().equals("O")) {
            visVinderOSkærm(event);
        }

    }

    @FXML
    void trykNytSpil(ActionEvent event) throws IOException {

        visSpilSkærm(event);
        game.nytSpil();

    }

    @FXML
    void trykOpgiv(ActionEvent event) throws IOException {

        visOpgivSkærm(event);

    }

    public void initialize() {

        game = new Game();
        game.nytSpil();

    }

    //Fjerner alt tekst fra spilleknapperne.
    public void resetKnapper() {

        try {
            for (Node n : gridPane.getChildren()) { //Kigger alle noder igennem der ligger i GridPane og sletter deres text.
                Button knap = (Button) n;
                knap.setText("");
            }
        }
        catch (NullPointerException e) { //
            System.out.println(e);
        }

    }

    //Laver selve spil skærmen.
    public void visSpilSkærm(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("KrydsOgBolle.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

    }

    //Laver opgiv skærmen.
    public void visOpgivSkærm(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("KrydsOgBolleOpgiv.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        //Spiller en lyd.
        Media lyd = new Media(String.valueOf(getClass().getResource("/sounds/TaberLyd.mp3")));
        MediaPlayer mediaPlayer = new MediaPlayer(lyd);
        mediaPlayer.seek(mediaPlayer.getStartTime());
        mediaPlayer.play();

    }

    //Laver skærmen for når spiller X vinder.
    public void visVinderXSkærm(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("KrydsOgBolleVinderX.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        //Spiller en lyd.
        Media lyd = new Media(String.valueOf(getClass().getResource("/sounds/VinderLyd.mp3")));
        MediaPlayer mediaPlayer = new MediaPlayer(lyd);
        mediaPlayer.seek(mediaPlayer.getStartTime());
        mediaPlayer.play();

    }

    //Laver skærmen for når spiller O vinder.
    public void visVinderOSkærm(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("KrydsOgBolleVinderO.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        //Spiller en lyd.
        Media lyd = new Media(String.valueOf(getClass().getResource("/sounds/VinderLyd.mp3")));
        MediaPlayer mediaPlayer = new MediaPlayer(lyd);
        mediaPlayer.seek(mediaPlayer.getStartTime());
        mediaPlayer.play();

    }

}
