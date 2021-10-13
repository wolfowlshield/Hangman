package org.vashonsd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] words = {"elephant","snake","tiger","zebra","kitten","porpoise","whale","horse","penguin","bear","moose","panda"};
        String word = words[ (int) (Math.random() * (words.length)) ];

        int remainingTries = 10;
        boolean isRunning = true;

        char letter;
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
                    secondAppearance = word.lastIndexOf(letter); // One letter cannot appear more than twice w/ this logic...
                    // secondAppearance = word.substring(indexOfLetter + 1).indexOf(letter);                                                                                          // Replace with .lastIndexOf, should make everything nicer
                    if (secondAppearance == indexOfLetter) {
                        System.out.println("That letter appears once! At index " + indexOfLetter);
                        revealedLetters =
                                revealedLetters.substring(0, indexOfLetter) +
                                revealedLetters.substring(indexOfLetter, indexOfLetter + 1).replace('-',letter) +
                                revealedLetters.substring(indexOfLetter + 1);
                    } else {
                        System.out.println("That letter appears twice! At index " + indexOfLetter + " and " + secondAppearance);
                        revealedLetters =
                                revealedLetters.substring(0, indexOfLetter) +
                                revealedLetters.substring(indexOfLetter, indexOfLetter + 1).replace('-',letter) +
                                revealedLetters.substring(indexOfLetter + 1, secondAppearance) +
                                revealedLetters.substring(secondAppearance, secondAppearance + 1).replace('-', letter) +
                                revealedLetters.substring(secondAppearance + 1); // There's gotta be a better way to do this, but this works so...
                    }
                }
            }
            if (revealedLetters.equals(word) || guess.equals(word)) {
                System.out.println(word);
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