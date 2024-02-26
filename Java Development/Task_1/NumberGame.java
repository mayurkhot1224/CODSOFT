import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int attempts = 5;
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");
        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("I'm thinking of a number between " + minRange + " and " + maxRange + ". You have " + attempts + " attempts.");

            int guess;
            boolean guessedCorrectly = false;
            while (attempts > 0 && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score += attempts;
                    guessedCorrectly = true;
                } else if (guess < randomNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
                attempts--;
            }

            if (!guessedCorrectly) {
                System.out.println("Out of attempts. The number was: " + randomNumber);
            }

            System.out.println("Your score: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");

            if (playAgain) {
                attempts = 5;
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
