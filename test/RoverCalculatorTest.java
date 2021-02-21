package test;

import rover.Direction;
import rover.RoverCalculator;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RoverCalculatorTest {

    private RoverCalculator rc;
    private Scanner sc;
    private int[] bounds = {5,5};

    @Test
    public void testGetRoverCoordinates_OneRover(){
        sc = new Scanner("""
                5 5
                1 2 N
                LMLMLMLMM

                """);
        rc = new RoverCalculator(sc);
        String result = rc.getRoverCoordinates();
        assertEquals("1 3 N\n",result);
    }

    @Test
    public void testGetRoverCoordinates_TwoRovers(){
        sc = new Scanner("""
                5 5
                1 2 N
                LMLMLMLMM
                3 3 E
                MMRMMRMRRM

                """);
        rc = new RoverCalculator(sc);
        String result = rc.getRoverCoordinates();
        assertEquals("""
                1 3 N
                5 1 E
                """,result);
    }

    @Test
    public void testGetRoverCoordinates_OutOfBoundsRover(){
        sc = new Scanner("""
                10 10
                4 4 N
                MMMMMMMMMMMMMMM

                """);
        rc = new RoverCalculator(sc);
        String result = rc.getRoverCoordinates();
        assertEquals("4 10 N\n",result);
    }

    @Test
    public void testDoMovement(){
        rc = new RoverCalculator(null);
        rc.setX(3);
        rc.setY(3);
        rc.doMovement(Direction.N, bounds);
        assertEquals(4, rc.getY());
        rc.doMovement(Direction.E, bounds);
        assertEquals(4, rc.getX());
        rc.doMovement(Direction.S, bounds);
        assertEquals(3, rc.getY());
        rc.doMovement(Direction.W, bounds);
        assertEquals(3, rc.getY());
    }

    @Test
    public void testGetBounds(){
        int[] expected = {5,5};
        sc = new Scanner("5 5");
        rc = new RoverCalculator(sc);
        bounds = rc.getBounds(bounds);
        assertArrayEquals(expected, bounds);
        sc.close();
    }
}