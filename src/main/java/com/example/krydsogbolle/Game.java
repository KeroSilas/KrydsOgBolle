package com.example.krydsogbolle;

public class Game {
    private String spiller;
    Board bræt;

    //Sætter X eller O ind, alt efter hvem der er den næste spiller. Placeringen af spillerens input bliver sendt fra controlleren.
    public void spilTur(int row, int col) {
        bræt.fåBoard()[row][col].retSquare(spiller);
        System.out.println(row + " / " + col);
        System.out.println(spiller);
    }

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
