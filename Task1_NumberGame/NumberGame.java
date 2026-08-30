import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        char playAgain;

        do {
            int randomNumber = random.nextInt(100) + 1; // Random number between 1 and 100
            int maxAttempts = 7;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n===== Number Guessing Game =====");
            System.out.println("Guess the number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();

                attempts++;

                if (guess == randomNumber) {
                    System.out.println("🎉 Congratulations! You guessed the correct number.");

                    // Score calculation
                    int score = (maxAttempts - attempts + 1) * 10;
                    totalScore += score;

                    System.out.println("Attempts Taken: " + attempts);
                    System.out.println("Score This Round: " + score);

                    guessedCorrectly = true;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too Low!");
                } else {
                    System.out.println("Too High!");
                }

                System.out.println("Attempts Left: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("\nYou lost!");
                System.out.println("The correct number was: " + randomNumber);
            }

            System.out.println("Total Score: " + totalScore);

            System.out.print("\nDo you want to play again? (Y/N): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\nThank you for playing!");
        System.out.println("Final Score: " + totalScore);

        sc.close();
    }
}