package com.example.krydsogbolle;

public class Square {

    private String xo;

    public Square() {
        xo = "";
    }

    //Henter spillebrikkens værdi (X, O eller ingenting).
    public String fåSquare() {
        return xo;
    }

    //Retter spillebrikkens værdi. Det er her hvor spillerens tur bliver sat ind.
    public void retSquare(String xo) {
        this.xo = xo;
    }
}
