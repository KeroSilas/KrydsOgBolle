package com.example.krydsogbolle;

public class Board {

    private Square[][] board; //2D array der repræsenterer spillebrættet.

    //Opretter spillebrættet med 3x3 felter og starter med spiller X.
    public Board() {
        board = new Square[3][3];
        for (int row = 0; row < board.length; row++) { //Looper igennem rækkerne.
            for (int col = 0; col < board[row].length; col++) { //Looper igennem kolonnerne.
                board[row][col] = new Square(); //Lægger en ny Square object ind i hver felt.
            }
        }
    }

    //Henter felterne på spillebrættet.
    public Square[][] fåFelter() {
        return board;
    }
}
