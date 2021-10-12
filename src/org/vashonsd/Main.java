package org.vashonsd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] words = {"Elephant","Snake","Tiger","Zebra","Kitten","Porpoise","Whale","Horse","Penguin","Bear","Moose","Panda"};
        String word = words[ (int) (Math.random() * (words.length + 1)) ];
        // int length = word.length();
        // This would be useful if I wrote out the progress, but that would require another array...

        int remainingTries = 10;
        boolean isRunning = true;

        while (isRunning) {

            System.out.println("Guess a letter (Hint: the word is an animal). You have " + remainingTries + " left. \nType 'exit' to exit");
            String guess = input.nextLine();
            if (guess.equals("exit")) {
                isRunning = false;
            } else {
                char letter = guess.charAt(0); // Declare variables way earlier
                int indexOfLetter = word.indexOf(letter); // ^
                if (indexOfLetter == -1) {
                    System.out.println("Nope, that letter isn't in the word.");
                    remainingTries--;
                } else {
                    int secondAppearance = word.substring(indexOfLetter + 1).indexOf(letter); // Does this even work?!
                    if (secondAppearance == -1) {
                        System.out.println("That letter appears once! At index " + indexOfLetter);
                    } else {
                        System.out.println("That letter appears twice! At index " + indexOfLetter + " and " + secondAppearance);
                    }
                }
            }

            if (remainingTries <= 0) {
                System.out.println("Game over, you ran out of tries. The word was " + word);
                isRunning = false;
            }
        }
    }
}
