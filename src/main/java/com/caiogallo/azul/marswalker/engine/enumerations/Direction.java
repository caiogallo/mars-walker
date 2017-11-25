package com.caiogallo.azul.marswalker.engine.enumerations;

public enum Direction{
    NORTH(0, 'N'), EAST(1, 'E'), SOUTH(2, 'S'), WEST(3, 'W');

    private int value;
    private char abbreviation;

    Direction(int value, char abbreviation) {
        this.value = value;
        this.abbreviation = abbreviation;
    }

    public int getValue(){
        return this.value;
    }

    public char getAbbreviation() {
        return this.abbreviation;
    }

    public static Direction fromInteger(int value){
        return values()[value];
    }
}
