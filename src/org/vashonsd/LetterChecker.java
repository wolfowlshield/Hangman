package org.vashonsd;

public class LetterChecker {

    String word;

    RevealingWord revealed;

    int numAppearances;

    public LetterChecker(String word) {
        this.word = word;
        revealed = new RevealingWord(word.length());
    }

    public void revealAllOfLetter(RevealingWord revealed, char letter) {

        boolean moreLetters;

        int indexOfLetter;
        int previousAppearance;

        numAppearances = 0;
        moreLetters = true;
        previousAppearance = -1;
        while (moreLetters) {
            indexOfLetter = word.indexOf(letter, previousAppearance + 1);
            if (indexOfLetter != -1) {
                revealed.revealLetterAt(indexOfLetter, letter);
                previousAppearance = indexOfLetter;
                numAppearances++;
            } else {
                moreLetters = false;
            }
        }
    }
}