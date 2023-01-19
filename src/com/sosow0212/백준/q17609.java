package com.sosow0212.백준;

import java.util.Scanner;

public class q17609 {
    private final static Scanner sc = new Scanner(System.in);
    private static int t;

    public static void main(String[] args) {
        initData();
        getAnswer();
    }

    private static void initData() {
        t = sc.nextInt();
    }

    private static void getAnswer() {
        for (int i = 0; i < t; i++) {
            String word = sc.next();
            int answer = decodeWord(word);
            System.out.println(answer);
        }
    }

    private static int decodeWord(String word) {
        if (isPalindrome(word)) {
            return 0;
        } else if (isAlmostPalindrome(word, 0, word.length() - 1, true)) {
            return 1;
        } else {
            return 2;
        }
    }

    private static boolean isPalindrome(String word) {
        StringBuilder input = new StringBuilder(word);
        if (input.reverse().toString().equals(word)) {
            return true;
        }
        return false;
    }

    private static boolean isAlmostPalindrome(String word, int left, int right, boolean can_skip) {
        if (left > right) {
            return true;
        }

        if (word.charAt(left) == word.charAt(right)) {
            return isAlmostPalindrome(word, left + 1, right - 1, can_skip);
        } else if (can_skip) {
            return (isAlmostPalindrome(word, left + 1, right, false) || isAlmostPalindrome(word, left, right - 1,
                    false));
        } else {
            return false;
        }
    }
}
