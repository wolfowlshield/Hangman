package org.vashonsd;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] words = {"elephant","snake","tiger","zebra","kitten","porpoise","whale","horse","penguin","bear","moose","panda"};
        String word = words[ (int) (Math.random() * (words.length)) ];

        RevealingWord revealed = new RevealingWord(word.length());
        LetterChecker checker = new LetterChecker(word);
        int remainingTries = 10;
        boolean isRunning = true;

        char letter;

        System.out.println("(Remember the index of a word starts at 0)");

        while (isRunning) {

            System.out.println("Guess a letter (Hint: the word is an animal). You have " + remainingTries + " tries left. \nType 'exit' to exit");
            System.out.println(revealed.getWord());

            String guess = input.nextLine().toLowerCase();

            if (guess.equals("exit")) {
                isRunning = false;
            } else {
                letter = guess.charAt(0);
                if (word.indexOf(letter) != -1) {
                    checker.revealAllOfLetter(revealed, letter);
                    System.out.println("That letter appears " + checker.numAppearances + " time(s) in the word");
                } else {
                    System.out.println("That letter isn't in the word");
                    remainingTries--;
                }
            }
            if (revealed.getWord().equals(word) || guess.equals(word)) {
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