//Number Game

import java.util.Scanner;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        System.out.println("\n");
        System.out.println("-:Welcome To The Number Guessing Game:-");
        System.out.println("I have Selected the number between 1 to 100...\n");
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();

            int lowerLimit = 1;
            int upperLimit = 100;
            int attemptsLimit = 10;
            int score = 0;

            boolean playAgain = true;

            while (playAgain) {
                // Step 1: FOR Random number betweek 1 to 100
                int secretNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;

                // Step 2: For user to guess within a limited number of attempts
                for (int attempt = 1; attempt <= attemptsLimit; attempt++) {
                    int userGuess;
                    while (true) {

                        System.out.print("Guess the number between " + lowerLimit + " and " + upperLimit + ": ");
                        if (scanner.hasNextInt()) {
                            userGuess = scanner.nextInt();
                            break;
                        } else {
                            System.out.println("Invalid number, Please enter a valid number.");
                            scanner.next();
                        }
                    }

                    // Step 3: For Comparing user's guess with the generated number
                    if (userGuess == secretNumber) {
                        System.out.println(
                                "Congratulations! You guessed the correct number in " + attempt + " attempts.");
                        score++;
                        break;
                    } else if (userGuess < secretNumber) {
                        System.out.println("Too low! Try again.");
                    } else {
                        System.out.println("Too high! Try again.");
                    }

                    // Check if attempts are exhausted
                    if (attempt == attemptsLimit) {
                        System.out
                                .println("Sorry, you've run out of attempts. The correct number was " + secretNumber
                                        + ".");
                    }
                }

                // Step 6: Ask the user if they want to play again
                System.out.print("Do you want to play again? (yes/no): ");
                String playAgainInput = scanner.next();
                playAgain = playAgainInput.equalsIgnoreCase("yes");
            }

            // Step 7: Display the user's score
            System.out.println("Your final score is " + score + ".");
        }
    }
}