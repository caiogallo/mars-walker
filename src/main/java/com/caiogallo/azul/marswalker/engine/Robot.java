package com.caiogallo.azul.marswalker.engine;

import com.caiogallo.azul.marswalker.engine.enumerations.Direction;
import com.caiogallo.azul.marswalker.engine.enumerations.Turn;
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

    private int x = INITIAL_XY_POSITION;
    private int y = INITIAL_XY_POSITION;
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
        boolean valid = false;
        if (x >= Terrain.MIN_X_DISTANCE && x <= Terrain.MAX_X_DISTANCE &&
                y >= Terrain.MIN_Y_DISTANCE && y <= Terrain.MAX_Y_DISTANCE){
            valid = true;
        }
        return valid;
    }

    public void turn(Turn turn) {
        int directionValue = direction.getValue();
        switch (turn) {
            case LEFT:
                directionValue--;
                if (directionValue < Direction.NORTH.getValue()) {
                    directionValue = Direction.WEST.getValue();
                }
                break;
            case RIGHT:
                directionValue++;
                if (directionValue > Direction.WEST.getValue()) {
                    directionValue = Direction.NORTH.getValue();
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
        return String.format("(%d, %d, %c)", x, y, direction.getAbbreviation());
    }
}
