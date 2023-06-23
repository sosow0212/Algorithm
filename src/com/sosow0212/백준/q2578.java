package com.sosow0212.백준;

import java.util.Scanner;

public class q2578 {

    static int[][] map;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        map = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int t = 0; t < 25; t++) {
            int num = sc.nextInt();

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (map[i][j] == num) {
                        map[i][j] = -1;
                    }
                }
            }

            checkRow();
            checkCol();
            checkLeftToRight();
            checkRightToLeft();

            if (answer >= 3) {
                System.out.println(t + 1);
                return;
            }
        }
    }

    static void checkRow() {
        for (int i = 0; i < 5; i++) {
            int count = 0;

            for (int j = 0; j < 5; j++) {
                if (map[i][j] == -1) {
                    count++;
                }
            }

            if (count == 5) {
                answer++;
            }
        }
    }

    static void checkCol() {
        for (int i = 0; i < 5; i++) {
            int count = 0;

            for (int j = 0; j < 5; j++) {
                if (map[j][i] == -1) {
                    count++;
                }
            }

            if (count == 5) {
                answer++;
            }
        }
    }

    static void checkLeftToRight() {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (map[i][i] == -1) {
                count++;
            }
        }

        if (count == 5) {
            answer++;
        }
    }

    static void checkRightToLeft() {
        int count = 0;

        for (int i = 0; i < 5; i++) {
            if (map[i][4 - i] == -1) {
                count++;
            }
        }

        if (count == 5) {
            answer++;
        }
    }
}
