package com.caiogallo.azul.marswalker.engine.input;

import org.springframework.stereotype.Component;

/**
 * @author caio
 * @since 0.0.1
 */
@Component
public class ValidateCommand {
    private static final String REGEX_INPUT_COMMANDS = "[RLM]+";

    public boolean validateInputPattern(String commands){
        return commands.matches(REGEX_INPUT_COMMANDS);
    }
}
