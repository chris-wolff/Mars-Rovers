package test;

import rover.Direction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectionTest {
    @Test
    public void testGetDirectionLeft(){
        Direction d = Direction.N;
        d = Direction.getDirectionLeft(d);
        assertEquals(Direction.W, d);
        d = Direction.E;
        d = Direction.getDirectionLeft(d);
        assertEquals(Direction.N, d);
    }

    @Test
    public void testGetDirectionRight(){
        Direction d = Direction.W;
        d = Direction.getDirectionRight(d);
        assertEquals(Direction.N, d);
        d = Direction.N;
        d = Direction.getDirectionRight(d);
        assertEquals(Direction.E, d);
    }
}
