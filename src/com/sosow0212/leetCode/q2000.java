package com.sosow0212.leetCode;

public class q2000 {

    public static String reversePrefix(String word, char ch) {
        if (!word.contains(Character.toString(ch))) {
            return word;
        }

        int index = word.indexOf(ch);
        StringBuilder rev = new StringBuilder(word.substring(0, index + 1)).reverse();

        return rev.toString() + word.substring(index + 1);
    }

    public static void main(String[] args) {
        // dcbaefd
        System.out.println(reversePrefix("abcdefd", 'd'));
    }
}
