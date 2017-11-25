package com.caiogallo.azul.marswalker.rest;

import com.caiogallo.azul.marswalker.MarsWalkerApplication;
import com.caiogallo.azul.marswalker.engine.Robot;
import com.caiogallo.azul.marswalker.engine.input.ProcessCommand;
import com.caiogallo.azul.marswalker.listener.CustomTestExecutorListener;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=MarsWalkerApplication.class)
@TestExecutionListeners(listeners = CustomTestExecutorListener.class, mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS)
public class RobotControllerTest {
    @Autowired
    private RobotController robotController;
    @Autowired
    private Robot robot;
    @Autowired
    private ProcessCommand processCommand;

    @Before
    public void setup(){
        robotController.setRobot(robot);
        robotController.setProcessCommand(processCommand);
    }

    @Test
    public void testValidCommand() throws Exception {
        ResponseEntity<String> response = robotController.receiveCommand("MMRMMRMM");
        Assert.assertEquals(200, response.getStatusCode().value());
        Assert.assertEquals("(2,0,S)", response.getBody());
    }

    @Test
    public void testValidMMLCommand() throws Exception {
        ResponseEntity<String> response = robotController.receiveCommand("MML");
        Assert.assertEquals(200, response.getStatusCode().value());
        Assert.assertEquals("(0,2,W)", response.getBody());
    }

    @Test
    public void testInvalidCharacter() throws Exception {
        ResponseEntity<String> response = robotController.receiveCommand("AAA");
        Assert.assertEquals(400, response.getStatusCode().value());
        Assert.assertEquals(null, response.getBody());
    }

    @Test
    public void testInvalidCommandPosition() throws Exception {
        ResponseEntity<String> response = robotController.receiveCommand("MMMMMMMMMMMM");
        Assert.assertEquals(400, response.getStatusCode().value());
        Assert.assertEquals(null, response.getBody());
    }

    @Test
    public void testTurnLeftToWest() throws Exception{
        ResponseEntity<String> responseEntity = robotController.receiveCommand("L");
        Assert.assertEquals(200, responseEntity.getStatusCode().value());
        Assert.assertEquals("(0,0,W)", responseEntity.getBody());
    }

    @Test
    public void testTurnLeftToSouth() throws Exception{
        ResponseEntity<String> responseEntity = robotController.receiveCommand("LL");
        Assert.assertEquals(200, responseEntity.getStatusCode().value());
        Assert.assertEquals("(0,0,S)", responseEntity.getBody());
    }

    @Test
    public void testTurnLeftToEast() throws Exception{
        ResponseEntity<String> responseEntity = robotController.receiveCommand("LLL");
        Assert.assertEquals(200, responseEntity.getStatusCode().value());
        Assert.assertEquals("(0,0,E)", responseEntity.getBody());
    }

    @Test
    public void testTurnRightToEast() throws Exception{
        ResponseEntity<String> responseEntity = robotController.receiveCommand("R");
        Assert.assertEquals(200, responseEntity.getStatusCode().value());
        Assert.assertEquals("(0,0,E)", responseEntity.getBody());
    }

    @Test
    public void testTurnRightToSouth() throws Exception{
        ResponseEntity<String> responseEntity = robotController.receiveCommand("RR");
        Assert.assertEquals(200, responseEntity.getStatusCode().value());
        Assert.assertEquals("(0,0,S)", responseEntity.getBody());
    }

    @Test
    public void testTurnRightToWest() throws Exception{
        ResponseEntity<String> responseEntity = robotController.receiveCommand("RRR");
        Assert.assertEquals(200, responseEntity.getStatusCode().value());
        Assert.assertEquals("(0,0,W)", responseEntity.getBody());
    }
}