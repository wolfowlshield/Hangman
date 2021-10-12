package org.vashonsd;

public class Main {
    public static void main(String[] args) {
        String[] words = {"Elephant","Snake","Tiger","Zebra","Kitten","Porpoise","Whale","Horse","Penguin","Bear","Moose","Panda"};
        String word = words[ (int) (Math.random() * (words.length + 1)) ];

        int length = word.length();

    }
}
