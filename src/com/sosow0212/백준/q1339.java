package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class q1339 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] alphabet = new Integer[26];
        Arrays.fill(alphabet, 0);
        for (int i = 0; i < n; i++) {
            char[] input = sc.next().toCharArray();
            int pos = 1;
            for (int j = input.length - 1; j >= 0; j--) {
                alphabet[input[j] - 'A'] += Integer.valueOf(pos);
                pos *= 10;
            }
        }
        Arrays.sort(alphabet, Collections.reverseOrder());
        int value = 9, answer = 0;
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == 0) break;
            answer += alphabet[i] * value--;
        }
        System.out.println(answer);
        sc.close();
    }
}

