package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class kul {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> answers = new ArrayList<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] map = new char[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = sc.next()
                    .toCharArray();
        }

        for (int i = 0; i < n; i++) {
            char[] arr = map[i];

            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < arr.length - 1; j++) {
                char c = arr[j];

                if (c == '#') {
                    temp = new StringBuilder();
                    continue;
                }

                temp.append(c);
                if (temp.length() >= 2) {
                    answers.add(temp.toString());
                }
            }
        }

        for (int i = 0; i < m; i++) {

            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < n; j++) {
                char c = map[j][i];

                if (c == '#') {
                    temp = new StringBuilder();
                    continue;
                }

                temp.append(c);
                if (temp.length() >= 2) {
                    answers.add(temp.toString());
                }
            }
        }

        Collections.sort(answers);
        System.out.println(answers);
    }
}
