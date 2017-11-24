package com.caiogallo.azul.marswalker.engine;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * @author caio
 * @since 0.0.1
 */
@Component()
@Scope(value="request", proxyMode= ScopedProxyMode.TARGET_CLASS)
public class Robot {
    public static final int INITIAL_XY_POSITION = 0;

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

    private int x, y = INITIAL_XY_POSITION;
    private Direction direction = Direction.NORTH;

    public boolean move() {
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

        return validatePosition();
    }

    private boolean validatePosition(){
        if (x >= Terrain.MIN_X_DISTANCE && x <= Terrain.MAX_X_DISTANCE &&
                y >= Terrain.MIN_X_DISTANCE && y <= Terrain.MAX_X_DISTANCE){
            return true;
        }
        return false;
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
