package com.caiogallo.azul.marswalker.engine;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RobotTest {
    Robot robot;

    @Before
    public void beforeTest(){
        robot = new Robot();
    }

    @Test
    public void moveOneUnitUp() throws Exception {
        robot.move();

        Assert.assertEquals(robot.getDirection(), Robot.Direction.NORTH);
        Assert.assertEquals(robot.getX(), 0);
        Assert.assertEquals(robot.getY(), 1);
    }

    @Test
    public void moveThreeUnitsUp() throws Exception {
        robot.move();
        robot.move();
        robot.move();

        Assert.assertEquals(robot.getDirection(), Robot.Direction.NORTH);
        Assert.assertEquals(robot.getX(), 0);
        Assert.assertEquals(robot.getY(), 3);
    }

    @Test
    public void turnLeftOnce(){
        robot.turn(Robot.Turn.LEFT);

        Assert.assertEquals(robot.getDirection(), Robot.Direction.WEST);
        Assert.assertEquals(robot.getX(), 0);
        Assert.assertEquals(robot.getY(), 0);

    }

    @Test
    public void turnRightOnce(){
        robot.turn(Robot.Turn.RIGHT);

        Assert.assertEquals(robot.getDirection(), Robot.Direction.EAST);
        Assert.assertEquals(robot.getX(), 0);
        Assert.assertEquals(robot.getY(), 0);

    }

}