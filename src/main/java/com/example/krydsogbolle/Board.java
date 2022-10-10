package com.example.krydsogbolle;

public class Board {

    private Square[][] board; //2D array der repræsenterer spillebrættet.

    //Opretter spillebrættet med 3x3 felter og starter med spiller X.
    public Board() {

        board = new Square[3][3];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = new Square();
            }
        }

    }

    public Square[][] fåBoard() {

        return board;

    }
}
