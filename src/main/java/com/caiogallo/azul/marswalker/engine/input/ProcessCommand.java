package com.caiogallo.azul.marswalker.engine.input;

import com.caiogallo.azul.marswalker.engine.Robot;
import com.caiogallo.azul.marswalker.engine.enumerations.Turn;
import org.springframework.stereotype.Component;

/**
 * @author caio
 * @since 0.0.1
 */
@Component
public class ProcessCommand {
    private static final String REGEX_INPUT_COMMANDS = "[RLM]+";

    public boolean process(String commands, Robot robot){
        boolean validMovement = validateInputPattern(commands);
        for(int i = 0; i < commands.length() && validMovement; i++){
            char command = commands.charAt(i);
            switch (command){
                case 'M':
                    validMovement = robot.move();
                    break;
                case 'L':
                    robot.turn(Turn.LEFT);
                    break;
                case 'R':
                    robot.turn(Turn.RIGHT);
                    break;
            }
        }
        return validMovement;
    }



    public boolean validateInputPattern(String commands){
        return commands.matches(REGEX_INPUT_COMMANDS);
    }

}
