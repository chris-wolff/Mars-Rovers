## Mars Rover Interview Question
> include a brief explanation of your design and
> assumptions along with your code.

For this question I tried to structure the problem in a modular way which would make the function of each peice clear and easy to test.
Since there aren't real world visability concerns, I chose to make the helper methods public, but still encapsulated the data inside the RoverCalculator class. I 
chose to make the program stop reading input when it encountered a blank line for simplicity.

I found that using an enum for the direction helps with the readability of the code (though an array would also work, or could convert from the string input on the fly) and I decided not to use any modular arithmatic for direction calculation to also try to help with readability. 

With the unit tests, I tried to ensure a mix of good code coverage and a few different scenarios for the rover. The problem does not specify what to do with the bounds that are read in, so I decided to not allow the rover to move outside the grid in any direction. 
