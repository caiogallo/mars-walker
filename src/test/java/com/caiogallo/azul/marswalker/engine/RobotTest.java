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

    @Test
    public void turnRightThreeTimes(){
        robot.turn(Robot.Turn.RIGHT);
        robot.turn(Robot.Turn.RIGHT);
        robot.turn(Robot.Turn.RIGHT);

        Assert.assertEquals(robot.getDirection(), Robot.Direction.WEST);
        Assert.assertEquals(robot.getX(), 0);
        Assert.assertEquals(robot.getY(), 0);

    }

    @Test
    public void turnLeftFiveTimes(){
        robot.turn(Robot.Turn.LEFT);
        robot.turn(Robot.Turn.LEFT);
        robot.turn(Robot.Turn.LEFT);
        robot.turn(Robot.Turn.LEFT);
        robot.turn(Robot.Turn.LEFT);

        Assert.assertEquals(robot.getDirection(), Robot.Direction.WEST);
        Assert.assertEquals(robot.getX(), 0);
        Assert.assertEquals(robot.getY(), 0);

    }

    @Test
    public void moveTwiceTurnRightMoveTwiceTurnRightMoveTwice(){
        robot.move();
        robot.move();
        robot.turn(Robot.Turn.RIGHT);
        robot.move();
        robot.move();
        robot.turn(Robot.Turn.RIGHT);
        robot.move();
        robot.move();

        Assert.assertEquals(robot.getDirection(), Robot.Direction.SOUTH);
        Assert.assertEquals(robot.getX(), 2);
        Assert.assertEquals(robot.getY(), 0);
        Assert.assertEquals("(2,0,S)", robot.toString());
    }

    @Test
    public void moveTwiceAndTurnLeft(){
        robot.move();
        robot.move();
        robot.turn(Robot.Turn.LEFT);

        Assert.assertEquals(robot.getDirection(), Robot.Direction.WEST);
        Assert.assertEquals(robot.getX(), 0);
        Assert.assertEquals(robot.getY(), 2);
        Assert.assertEquals("(0,2,W)", robot.toString());
    }

}