package com.caiogallo.azul.marswalker.engine;

/**
 * @author caio
 * @since 0.0.1
 */
public class Robot {
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

    public enum Turn{
        LEFT, RIGHT;
    }

    private int x, y = 0;
    private Direction direction = Direction.NORTH;

    public void move() {
        switch (direction) {
            case NORTH:
                    y++;
                break;
            case SOUTH:
                    y--;
                break;
            case WEST:
                    x--;
                break;
            case EAST:
                    x++;
                break;
        }
    }

    public void turn(Turn turn) {
        int directionValue = direction.value;
        switch (turn) {
            case LEFT:
                directionValue--;
                if (directionValue < 0) {
                    directionValue = 3;
                }
                break;
            case RIGHT:
                directionValue++;
                if (directionValue > 3) {
                    directionValue = 0;
                }
                break;
        }
        direction = Direction.fromInteger(directionValue);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString(){
        return String.format("(%d,%d,%c)", x, y, direction.getAbbreviation());
    }
}
