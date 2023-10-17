package com.sosow0212.백준;

import java.util.Scanner;

public class q1969 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] arr = new String[n];
        char[][] alphabet = new char[m][26];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();

            for (int j = 0; j < m; j++) {
                alphabet[j][arr[i].charAt(j) - 'A'] += 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        int answer = 0;

        for (int i = 0; i < m; i++) {
            int max = Integer.MIN_VALUE;
            char pick = 'A';

            for (int j = 0; j < 26; j++) {
                if (alphabet[i][j] > max) {
                    max = alphabet[i][j];
                    pick = (char) ('A' + j);
                }
            }

            sb.append(pick);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i].charAt(j) != sb.charAt(j)) {
                    answer++;
                }
            }
        }

        System.out.println(sb.toString());
        System.out.println(answer);
    }
}
