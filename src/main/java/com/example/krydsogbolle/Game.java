package com.example.krydsogbolle;

public class Game {

    private String spiller;
    Board bræt;
    String vinder;

    //Sætter X eller O ind, alt efter hvem der er den næste spiller. Placeringen af spillerens input bliver sendt fra controlleren.
    public void spilTur(int row, int col) {

        bræt.fåBoard()[row][col].retSquare(spiller);
        System.out.println(row + " / " + col);
        System.out.println(spiller);

    }

    //Flytter brikken ...
    public void flytBrik(int row, int col) {

    }

    //Vurderer hvem der skal spille næste tur.
    public void næsteSpiller() {

        if(spiller.equals("X")) {
            spiller = "O";
            return;
        }
        spiller = "X";

        //spiller = (spiller.equals("X")) ? "O" : "X";

    }

    public String visVinder() {

        vinder = bræt.fåBoard()[0][0].fåSquare() + bræt.fåBoard()[0][1].fåSquare() + bræt.fåBoard()[0][2].fåSquare();

        if (vinder.equals("XXX")) {
            return "X";
        }
        else if (vinder.equals("OOO")) {
            return "O";
        }

        vinder = bræt.fåBoard()[1][0].fåSquare() + bræt.fåBoard()[1][1].fåSquare() + bræt.fåBoard()[1][2].fåSquare();

        if (vinder.equals("XXX")) {
            return "X";
        }
        else if (vinder.equals("OOO")) {
            return "O";
        }

        vinder = bræt.fåBoard()[2][0].fåSquare() + bræt.fåBoard()[2][1].fåSquare() + bræt.fåBoard()[2][2].fåSquare();

        if (vinder.equals("XXX")) {
            return "X";
        }
        else if (vinder.equals("OOO")) {
            return "O";
        }

        vinder = bræt.fåBoard()[0][0].fåSquare() + bræt.fåBoard()[0][1].fåSquare() + bræt.fåBoard()[0][2].fåSquare();

        if (vinder.equals("XXX")) {
            return "X";
        }
        else if (vinder.equals("OOO")) {
            return "O";
        }

        vinder = bræt.fåBoard()[1][0].fåSquare() + bræt.fåBoard()[1][1].fåSquare() + bræt.fåBoard()[1][2].fåSquare();

        if (vinder.equals("XXX")) {
            return "X";
        }
        else if (vinder.equals("OOO")) {
            return "O";
        }

        vinder = bræt.fåBoard()[2][0].fåSquare() + bræt.fåBoard()[2][1].fåSquare() + bræt.fåBoard()[2][2].fåSquare();

        if (vinder.equals("XXX")) {
            return "X";
        }
        else if (vinder.equals("OOO")) {
            return "O";
        }

        vinder = bræt.fåBoard()[0][0].fåSquare() + bræt.fåBoard()[1][1].fåSquare() + bræt.fåBoard()[2][2].fåSquare();

        if (vinder.equals("XXX")) {
            return "X";
        }
        else if (vinder.equals("OOO")) {
            return "O";
        }

        vinder = bræt.fåBoard()[2][2].fåSquare() + bræt.fåBoard()[1][1].fåSquare() + bræt.fåBoard()[0][0].fåSquare();

        if (vinder.equals("XXX")) {
            return "X";
        }
        else if (vinder.equals("OOO")) {
            return "O";
        }

        return "";

    }

    public boolean slutSpil() {

        if (!visVinder().equals("")) {
            return true;
        }

        return false;

    }

    //Starter et nyt spil og nulstiller næste spillers tur til at være X.
    public void nytSpil() {

        bræt = new Board();
        spiller = "X";

    }

    public void opgiv() {

    }

    //Henter næste spillers tur (bliver brugt i controlleren).
    public String fåSpiller() {

        return spiller;

    }

    public void retSpiller(String spiller) {

        this.spiller = spiller;

    }
}
