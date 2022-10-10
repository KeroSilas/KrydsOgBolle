package com.example.krydsogbolle;

public class Game {

    private String spiller;
    private Board board;
    private int spilTurTæller;

    //Sætter X eller O ind, alt efter hvem der er den næste spiller. Placeringen af spillerens input bliver sendt fra controlleren.
    public void spilTur(int row, int col) {

        board.fåFelter()[row][col].retSquare(spiller);
        spilTurTæller++;

        System.out.println(row + " / " + col);
        System.out.println(spiller);
        System.out.println(spilTurTæller);

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

    public String fåVinder() {

        String vinder = board.fåFelter()[0][0].fåSquare() + board.fåFelter()[0][1].fåSquare() + board.fåFelter()[0][2].fåSquare();

        if (vinder.equals("XXX")) {
            return "X";
        }
        else if (vinder.equals("OOO")) {
            return "O";
        }

        vinder = board.fåFelter()[1][0].fåSquare() + board.fåFelter()[1][1].fåSquare() + board.fåFelter()[1][2].fåSquare();

        if (vinder.equals("XXX")) {
            return "X";
        }
        else if (vinder.equals("OOO")) {
            return "O";
        }

        vinder = board.fåFelter()[2][0].fåSquare() + board.fåFelter()[2][1].fåSquare() + board.fåFelter()[2][2].fåSquare();

        if (vinder.equals("XXX")) {
            return "X";
        }
        else if (vinder.equals("OOO")) {
            return "O";
        }

        vinder = board.fåFelter()[0][0].fåSquare() + board.fåFelter()[0][1].fåSquare() + board.fåFelter()[0][2].fåSquare();

        if (vinder.equals("XXX")) {
            return "X";
        }
        else if (vinder.equals("OOO")) {
            return "O";
        }

        vinder = board.fåFelter()[1][0].fåSquare() + board.fåFelter()[1][1].fåSquare() + board.fåFelter()[1][2].fåSquare();

        if (vinder.equals("XXX")) {
            return "X";
        }
        else if (vinder.equals("OOO")) {
            return "O";
        }

        vinder = board.fåFelter()[2][0].fåSquare() + board.fåFelter()[2][1].fåSquare() + board.fåFelter()[2][2].fåSquare();

        if (vinder.equals("XXX")) {
            return "X";
        }
        else if (vinder.equals("OOO")) {
            return "O";
        }

        vinder = board.fåFelter()[0][0].fåSquare() + board.fåFelter()[1][1].fåSquare() + board.fåFelter()[2][2].fåSquare();

        if (vinder.equals("XXX")) {
            return "X";
        }
        else if (vinder.equals("OOO")) {
            return "O";
        }

        vinder = board.fåFelter()[2][2].fåSquare() + board.fåFelter()[1][1].fåSquare() + board.fåFelter()[0][0].fåSquare();

        if (vinder.equals("XXX")) {
            return "X";
        }
        else if (vinder.equals("OOO")) {
            return "O";
        }

        return "";

    }

    public boolean slutSpil() {

        if (!fåVinder().equals("")) {
            return true;
        }

        return false;

    }

    //Starter et nyt spil og nulstiller næste spillers tur til at være X.
    public void nytSpil() {

        board = new Board();
        spiller = "X";
        spilTurTæller = 0;

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

    public Board fåBoard() {
        return board;
    }

    public int fåSpilTurTæller() {
        return spilTurTæller;
    }

}
