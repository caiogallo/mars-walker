package com.caiogallo.azul.marswalker.rest;

import com.caiogallo.azul.marswalker.engine.Robot;
import com.caiogallo.azul.marswalker.engine.input.ProcessCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caio
 * @since 0.0.1
 */
@RestController
@RequestMapping("/rest/mars")
public class RobotController {

    private ProcessCommand processCommand;
    private Robot robot;

    @RequestMapping(method = RequestMethod.POST,
            value = "/{commands}")
    public ResponseEntity receiveCommand(@PathVariable(value = "commands") String commands) {

        boolean validCommand = processCommand.process(commands, robot);
        if (validCommand) {
            return new ResponseEntity<>(robot.toString(), HttpStatus.OK);
        }
        return new ResponseEntity<>(
                String.format("%d %s",HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()),
                HttpStatus.BAD_REQUEST);
    }

    @Autowired
    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    @Autowired
    public void setProcessCommand(ProcessCommand processCommand) {
        this.processCommand = processCommand;
    }
}
