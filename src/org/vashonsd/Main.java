package org.vashonsd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] words = {"elephant","snake","tiger","zebra","kitten","porpoise","whale","horse","penguin","bear","moose","panda"};
        String word = words[ (int) (Math.random() * (words.length + 1)) ];

        int remainingTries = 10;
        boolean isRunning = true;

        char letter; // Declaring these out here in case I need to use them to create a revealing word...
        int indexOfLetter;
        int secondAppearance;
        String revealedLetters = "";

        for (int i = word.length(); i > 0; i--) {
            revealedLetters = revealedLetters.concat("-");
        }

        System.out.println("(Remember the index of a word starts at 0)");

        while (isRunning) {

            System.out.println("Guess a letter (Hint: the word is an animal). You have " + remainingTries + " tries left. \nType 'exit' to exit");
            System.out.println(revealedLetters);

            String guess = input.nextLine().toLowerCase();

            if (guess.equals("exit")) {
                isRunning = false;
            } else {
                letter = guess.charAt(0);
                indexOfLetter = word.indexOf(letter);
                if (indexOfLetter == -1) {
                    System.out.println("Nope, that letter isn't in the word.");
                    remainingTries--;
                } else {
                    secondAppearance = word.substring(indexOfLetter + 1).indexOf(letter); // returns the int minus the substring length, need the -1 to check in the if statement
                    if (secondAppearance == -1) {
                        System.out.println("That letter appears once! At index " + indexOfLetter);
                        revealedLetters =
                                revealedLetters.substring(0, indexOfLetter) +
                                revealedLetters.substring(indexOfLetter, indexOfLetter + 1).replace('-',letter) +
                                revealedLetters.substring(indexOfLetter + 1);
                    } else {
                        secondAppearance += (indexOfLetter + 1); // adds the substring length (+1) the get the index of the actual appearance
                        System.out.println("That letter appears twice! At index " + indexOfLetter + " and " + secondAppearance);
                        revealedLetters =
                                revealedLetters.substring(0, indexOfLetter) +
                                revealedLetters.substring(indexOfLetter, indexOfLetter + 1).replace('-',letter) +
                                revealedLetters.substring(indexOfLetter + 1, secondAppearance) +
                                revealedLetters.substring(secondAppearance, secondAppearance + 1).replace('-', letter) +
                                revealedLetters.substring(secondAppearance + 1); // There's gotta be a better way to do this...
                    }
                }
            }
            if (revealedLetters.equals(word)) {
                System.out.println("Congratulations! You win!");
                isRunning = false;
            }
            if (remainingTries <= 0) {
                System.out.println("Game over, you ran out of tries. The word was '" + word + "'.");
                isRunning = false;
            }
        }
    }
}
