package com.example.krydsogbolle;

public class Game {

    private String spiller;
    private Board board;
    private int spilTurTæller; //Tæller antal ture der er blevet spillet i alt.

    //Sætter X eller O ind, alt efter hvem der er den næste spiller. Placeringen af spillerens input bliver sendt fra controlleren.
    public void spilTur(int row, int col) {
        board.fåFelter()[row][col].retSquare(spiller);
        spilTurTæller++;
    }

    //Vurderer hvem der skal spille næste tur.
    public void næsteSpiller() {
        spiller = (spiller.equals("X")) ? "O" : "X";
    }

    //Sammenligner de felter hvor en vinder kan blive fundet, og vurderer hvem der har vundet.
    public String fåVinder() {
        String vinder = board.fåFelter()[0][0].fåSquare() + board.fåFelter()[0][1].fåSquare() + board.fåFelter()[0][2].fåSquare(); //Lægger alle vinder felterne sammen i en string.
        if (vinder.equals("XXX")) { //Checker om der er tre af den samme brik.
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

        vinder = board.fåFelter()[0][0].fåSquare() + board.fåFelter()[1][0].fåSquare() + board.fåFelter()[2][0].fåSquare();
        if (vinder.equals("XXX")) {
            return "X";
        }
        else if (vinder.equals("OOO")) {
            return "O";
        }

        vinder = board.fåFelter()[0][1].fåSquare() + board.fåFelter()[1][1].fåSquare() + board.fåFelter()[2][1].fåSquare();
        if (vinder.equals("XXX")) {
            return "X";
        }
        else if (vinder.equals("OOO")) {
            return "O";
        }

        vinder = board.fåFelter()[0][2].fåSquare() + board.fåFelter()[1][2].fåSquare() + board.fåFelter()[2][2].fåSquare();
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

        vinder = board.fåFelter()[0][2].fåSquare() + board.fåFelter()[1][1].fåSquare() + board.fåFelter()[2][0].fåSquare();
        if (vinder.equals("XXX")) {
            return "X";
        }
        else if (vinder.equals("OOO")) {
            return "O";
        }

        return "";
    }

    //Starter et nyt spil og nulstiller næste spillers tur til at være X.
    public void nytSpil() {
        board = new Board();
        spiller = "X";
        spilTurTæller = 0;
    }

    //Henter næste spillers tur (bliver brugt i controlleren).
    public String fåSpiller() {
        return spiller;
    }

    //Henter spillebrættet.
    public Board fåBoard() {
        return board;
    }

    public int fåSpilTurTæller() {
        return spilTurTæller;
    }

}
