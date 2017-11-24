package com.caiogallo.azul.marswalker.engine.input;

import com.caiogallo.azul.marswalker.engine.Robot;
import org.springframework.stereotype.Component;

/**
 * @author caio
 * @since 0.0.1
 */
@Component
public class ProcessCommand {
    public boolean process(String commands, Robot robot){
        boolean validMovement = true;
        for(int i = 0; i < commands.length() && validMovement; i++){
            char command = commands.charAt(i);
            switch (command){
                case 'M':
                    validMovement = robot.move();
                    break;
                case 'L':
                    robot.turn(Robot.Turn.LEFT);
                    break;
                case 'R':
                    robot.turn(Robot.Turn.RIGHT);
                    break;
            }
        }
        return validMovement;
    }
}
