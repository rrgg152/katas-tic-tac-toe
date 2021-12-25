package com.example.tictactoe.game;

public enum Position {
    A1("A1"), A2("A2"), A3("A3"),
    B1("B1"), B2("B2"), B3("B3"),
    C1("C1"), C2("C2"), C3("C3");

    private final String value;

    Position(String value){
        this.value=value;
    }
    public static Position fromValue(String value) {
        switch (value.toUpperCase()) {
            case "A1": return Position.A1;
            case "A2": return Position.A2;
            case "A3": return Position.A3;
            case "B1": return Position.B1;
            case "B2": return Position.B2;
            case "B3": return Position.B3;
            case "C1": return Position.C1;
            case "C2": return Position.C2;
            case "C3": return Position.C3;
            default: return null;
        }
    }

    public char letter() {
        return this.value.charAt(0);
    }
    public char number() {
        return this.value.charAt(1);
    }
    public Position value(){
        return fromValue(this.value);
    }
}
