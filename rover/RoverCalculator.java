package rover;

import java.util.Scanner;

/**
 * Class for figuring for calculating a rover's position from a series of comands.
 */
public class RoverCalculator {

    private Scanner sc;

    private int x;
    private int y;

    /**
     * Constructs a rover with a default position off the grid because
     * it will get its position from the scanner's input.
     * @param sc where the rover is reading from.
     */
    public RoverCalculator(Scanner sc){
        this.sc = sc;
        x = -1;
        y = -1;
    }

    /**
     * Driver for rover.
     * @param args
     */
    public static void main(String[] args) {
        RoverCalculator id = new RoverCalculator(new Scanner(System.in));
        System.out.println(id.getRoverCoordinates());
    }

    /**
     * Stops performing calculations and returns when the scanner encounters an empty line.
     * @return The rover's coordinates based upon Scanner input of Driver class.
     */
    public String getRoverCoordinates(){
        String output = "";

        int[] bounds = new int[2];
        bounds = getBounds(bounds);

        sc.nextLine();
        String roverInfoSpaceDelimitedString;

        while(!(roverInfoSpaceDelimitedString = sc.nextLine()).equals("")) {
            String[] roverInfo = roverInfoSpaceDelimitedString.split(" ");
            x = Integer.parseInt(roverInfo[0]);
            y = Integer.parseInt(roverInfo[1]);
            Direction direction = Direction.valueOf(roverInfo[2]);

            String command = sc.nextLine();

            for (int i =0; i < command.length(); i++) {
                if (command.charAt(i) == 'L') {
                    direction = Direction.getDirectionLeft(direction);
                }else if(command.charAt(i) == 'R'){
                    direction = Direction.getDirectionRight(direction);
                }else if (command.charAt(i) == 'M')  {
                    doMovement(direction, bounds);
                }
            }
            output += x + " " + y + " " + direction + "\n";
        }
        sc.close();
        return output;
    }

    /**
     * Only move in the direction if within bounds
     * @param direction the current direction of the rover
     * @param bounds bounds[0] is the x bound, bounds[1] is the y bound
     */
    public void doMovement(Direction direction, int[] bounds){
        int dOrd = direction.ordinal();
        if (direction == Direction.N && y < bounds[1]) {
            y++;
        }else if (direction == Direction.E && x < bounds[0]) {
            x++;
        }else if (direction == Direction.S && y > 0){
            y--;
        }else if (direction == Direction.W && x > 0){
            x--;
        }
    }

    /**
     * Get the bounds of the rover
     * @param bounds to be set
     * @return bounds[0] is the x bound, bounds[1] is the y bound
     */
    public int[] getBounds(int[] bounds) {
        bounds[0] = sc.nextInt();
        bounds[1] = sc.nextInt();
        return bounds;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}