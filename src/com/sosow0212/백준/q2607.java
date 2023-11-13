package com.sosow0212.백준;

import java.util.Scanner;

public class q2607 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();

        int answer = 0;

        char[] arr = new char[26];

        for (int i = 0; i < n - 1; i++) {
            String diff = sc.next();
            int temp = 0;

            for (int j = 0; j < str.length(); j++) {
                arr[j]++;
            }

            for (int j = 0; j < diff.length(); j++) {
                if (arr[diff.charAt(j) - 'A'] != 0) {
                    arr[diff.charAt(j) - 'A']--;
                    temp++;
                }
            }

            if (str.length() - 1 == diff.length() && temp == str.length() - 1) {
                answer++;
            } else if (str.length() == diff.length() && temp == str.length() || str.length() - 1 == temp) {
                answer++;
            } else if (str.length() + 1 == diff.length() && temp == str.length()) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
