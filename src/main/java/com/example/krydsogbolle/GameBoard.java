package com.example.krydsogbolle;

public class GameBoard {
    private Square[][] board; //2D array der repræsenterer spillebrættet.
    private String spiller;

    //Opretter spillebrættet med 3x3 felter og starter med spiller X.
    public GameBoard() {
        board = new Square[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = new Square();
            }
        }
        spiller = "X";
    }

    //Sætter X eller O ind, alt efter hvem der er den næste spiller. Placeringen af spillerens input bliver sendt fra controlleren.
    public void spilTur(int row, int col) {
        board[row][col].retSquare(spiller);
        System.out.println(row + " / " + col);
        System.out.println(spiller);
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

    //Starter et nyt spil og nulstiller næste spillers tur til at være X.
    public void nytSpil() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = new Square();
            }
        }
        spiller = "X";
    }

    public void opgiv() {

    }

    //Henter næste spillers tur (bliver brugt i controlleren).
    public String fåSpiller() {
        return spiller;
    }
}
