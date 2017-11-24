package com.caiogallo.azul.marswalker.engine.input;

import com.caiogallo.azul.marswalker.listener.CustomTestExecutorListener;
import com.caiogallo.azul.marswalker.MarsWalkerApplication;
import com.caiogallo.azul.marswalker.engine.Robot;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=MarsWalkerApplication.class)
@TestExecutionListeners(listeners = CustomTestExecutorListener.class, mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS)
public class ProcessCommandTest {
    @Autowired
    private Robot robot;
    @Autowired
    private ProcessCommand processCommand;

    @Test
    public void testValidMMLCommand() throws Exception {
        boolean valid = processCommand.process("MML", robot);
        Assert.assertEquals(true, valid);
    }

    @Test
    public void testValidMMRMMRMMCommand() throws Exception {
        boolean valid = processCommand.process("MMRMMRMM", robot);
        Assert.assertEquals(true, valid);
    }

    @Test
    public void testInvalidMinXPosition(){
        boolean valid = processCommand.process("LLM", robot);
        Assert.assertEquals(false, valid);
    }

    @Test
    public void testInvalidMaxXPosition(){
        boolean valid = processCommand.process("MMMMMM", robot);
        Assert.assertEquals(false, valid);
    }

    @Test
    public void testInvalidMinYPosition(){
        boolean valid = processCommand.process("LM", robot);
        Assert.assertEquals(false, valid);
    }


    @Test
    public void testInvalidMaxYPosition(){
        boolean valid = processCommand.process("RMMMMMM", robot);
        Assert.assertEquals(false, valid);
    }
}