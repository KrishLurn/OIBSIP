import java.util.*;
import java.util.Random;
import javax.swing.*;

class Number_Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("You have to guess the random number between 1 and 100.");
        System.out.println("You can play the game for as many rounds.");
        System.out.println("You have maximum 10 attempts!");
        System.out.println("Are you ready? Let's Go!");
        System.out.println();

        boolean moreRounds = true;
        int round = 1;
        int totalP = 0;

        while (moreRounds) {
            System.out.println();

            int x = random.nextInt(100) + 1;
            System.out.println("for debugging!!");
            System.out.println(x);

            System.out.println();
            System.out.println("Round: " + round);

            int high = 100;
            int low = 0;

            for (int i = 0; i < 10; i++) {
                int points = 100 - (10 * i);
                System.out.println();

                System.out.println("Attempt > " + (i + 1) + "/10 for " + points + " points");

// This opens Dialogue Box for Input but there seems to be problem in taking input while recording.
                // String numberInput;
                // numberInput = JOptionPane.showInputDialog("Enter a number: ");
                // int guess = Integer.parseInt(numberInput);

                System.out.print("Enter a number: ");
                int guess = sc.nextInt();

                if (guess > high || guess < low) {
                    System.out.println("You're playing it wrong. Try Again!");
                    System.out.println("Wrong guess, the number is greater than " + low + " but less than " + high);
                    System.out.println();
                    continue;
                }
                if (x == guess) {
                    System.out.println("Well Done! You Win: " + points + " points");
                    totalP += points;
                    System.out.println();
                    break;

                } else if (x > guess) {
                    System.out.println("Wrong guess, the number is greater than " + guess + " but less than " + high);
                    low = guess;

                } else if (x < guess) {
                    System.out.println("Wrong guess, the number is greater than " + low + " but less than " + guess);
                    high = guess;
                }
            }
            sc.nextLine();
            System.out.println("Score in Round " + round + ": " + totalP + " points");
            System.out.println();

            while (true) {
                System.out.print("Do you want to keep playing? ");
                System.out.println();
                String input = sc.nextLine();

                if (input.equalsIgnoreCase("yes")) {
                    moreRounds = true;
                    round++;
                    break;

                } else if (input.equalsIgnoreCase("no")) {
                    System.out.println();
                    System.out.println("Your Final Score: " + totalP);
                    System.out.println();
                    moreRounds = false;
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'Yes' or 'No'.");
                    continue;
                }
            }
        }
        sc.close();
    }
}