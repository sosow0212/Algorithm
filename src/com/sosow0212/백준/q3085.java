package com.sosow0212.백준;

import java.util.Scanner;

public class q3085 {

    static int n;
    static char[][] map;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new char[n][n];
        answer = 0;

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            map[i] = str.toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                char temp = map[i][j];
                map[i][j] = map[i][j + 1];
                map[i][j + 1] = temp;
                checkCandy();
                temp = map[i][j];
                map[i][j] = map[i][j + 1];
                map[i][j + 1] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                char temp = map[j][i];
                map[j][i] = map[j + 1][i];
                map[j + 1][i] = temp;
                checkCandy();
                temp = map[j][i];
                map[j][i] = map[j + 1][i];
                map[j + 1][i] = temp;
            }
        }

        System.out.println(answer);

    }

    private static void checkCandy() {

        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 0; j < n - 1; j++) {
                if (map[i][j] == map[i][j + 1]) {
                    count++;
                } else {
                    count = 1;
                }

                answer = Math.max(answer, count);
            }
        }

        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 0; j < n - 1; j++) {
                if (map[j][i] == map[j + 1][i]) {
                    count++;
                } else {
                    count = 1;
                }

                answer = Math.max(answer, count);
            }
        }
    }
}
