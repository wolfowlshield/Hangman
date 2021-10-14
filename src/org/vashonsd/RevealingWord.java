package org.vashonsd;

public class RevealingWord {

    String word = "";

    public RevealingWord(int length) {
        for (int i = length; i > 0; i--) {
            word = word.concat("-");
        }
    }

    public void revealLetterAt(int index, char letter) {
        word = word.substring(0, index) +
                word.substring(index, index + 1).replace('-', letter) +
                word.substring(index + 1);
    }

    public String getWord() {
        return word;
    }
}
