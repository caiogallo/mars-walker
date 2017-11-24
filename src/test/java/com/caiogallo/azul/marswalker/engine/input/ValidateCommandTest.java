package com.caiogallo.azul.marswalker.engine.input;

import com.caiogallo.azul.marswalker.MarsWalkerApplication;
import com.caiogallo.azul.marswalker.engine.input.ValidateCommand;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=MarsWalkerApplication.class)
public class ValidateCommandTest
{
    @Autowired
    private ValidateCommand validateCommand;

    @Test
    public void testValidCommand() throws Exception {
        boolean valid = validateCommand.validateInputPattern("MML");
        Assert.assertEquals(true, valid);
    }

    @Test
    public void testInvalidCommand() throws Exception {
        boolean valid = validateCommand.validateInputPattern("AAA");
        Assert.assertEquals(false, valid);
    }

}