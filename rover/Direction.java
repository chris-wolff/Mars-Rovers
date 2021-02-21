package rover;

/**
 * Basic enum for mapping direction to values.
 */
public enum Direction {
        N, E, S, W, NONE;

    /**
     * Turn left, wrap around to West
      * @param direction current direction
     * @return direction after turning left
     */
    public static Direction getDirectionLeft(Direction direction) {
        if (direction.ordinal() -1 < Direction.N.ordinal()) {
            direction = Direction.W;
        }else {
            direction = Direction.values()[(direction.ordinal()-1)];
        }
        return direction;
    }

    /**
     * Turn right, wrap around to North
     * @param direction current direction
     * @return direction after turning right
     */
    public static Direction getDirectionRight(Direction direction) {
        if (direction.ordinal() + 1 > Direction.W.ordinal()) {
            direction = Direction.N;
        }else {
            direction = Direction.values()[(direction.ordinal()+1)];
        }
        return direction;
    }
}

