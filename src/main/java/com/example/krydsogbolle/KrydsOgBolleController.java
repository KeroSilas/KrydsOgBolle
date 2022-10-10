package com.example.krydsogbolle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.GridPane;

public class KrydsOgBolleController {

    private Game game;

    @FXML
    private GridPane gridPane;

    //De her knapper behøver vi nok ikke at definere.
    @FXML
    private Button knap1;

    @FXML
    private Button knap2;

    @FXML
    private Button knap3;

    @FXML
    private Button knap4;

    @FXML
    private Button knap5;

    @FXML
    private Button knap6;

    @FXML
    private Button knap7;

    @FXML
    private Button knap8;

    @FXML
    private Button knap9;
    // -

    @FXML
    private Button nytSpil;

    @FXML
    private Button opgiv;

    @FXML
    void trykKnap(ActionEvent event) {
        Button knap = (Button) event.getSource(); //Henter hvilken knap der bliver trykket på.
        int row = (GridPane.getRowIndex(knap) == null) ? 0 : GridPane.getRowIndex(knap); //Laver et row variabel med knappens row index i GridPane containeren.
        int col = (GridPane.getColumnIndex(knap) == null) ? 0 : GridPane.getColumnIndex(knap); //Laver et column variabel med knappens row index i GridPane containeren.

        game.spilTur(row, col); //Bruger knappens xy koordinater til at sætte spillerens tur ind i et 2D array af spillebrættet.
        knap.setText(game.fåSpiller());
        game.næsteSpiller(); //Skifter til den anden spiller (sætter næste tur til O fra X eller omvendt).
    }

    /*@FXML
    void flytKnap(MouseDragEvent event) {
        Button knap = (Button) event.getSource(); //Henter hvilken knap der bliver trykket på.
        int row = (GridPane.getRowIndex(knap) == null) ? 0 : GridPane.getRowIndex(knap); //Laver et row variabel med knappens row index i GridPane containeren.
        int col = (GridPane.getColumnIndex(knap) == null) ? 0 : GridPane.getColumnIndex(knap); //Laver et column variabel med knappens row index i GridPane containeren.
    }*/

    @FXML
    void trykNytSpil(ActionEvent event) {
        try {
            game.nytSpil();
            for (Node n : gridPane.getChildren()) { //Kigger alle noder igennem der ligger i GridPane og sletter deres text.
                Button knap = (Button) n;
                knap.setText("");
            }
        }
        catch (ClassCastException e) { //ClassCastException ved runtime, der bliver fundet en "Group" node i loopen?
            System.out.println(e);
        }
    }

    @FXML
    void trykOpgiv(ActionEvent event) {

    }

    public void initialize() {
        game = new Game();
        game.bræt = new Board();
        game.retSpiller("X");
    }

}
