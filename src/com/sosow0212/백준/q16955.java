package com.sosow0212.백준;

import java.util.Scanner;

public class q16955 {

    static final char ME = 'X';

    static char[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        map = new char[10][10];

        for (int i = 0; i < 10; i++) {
            String str = sc.next();
            map[i] = str.toCharArray();
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (map[i][j] == ME) {
                    searchRow(i, j);
                    searchCol(i, j);
                    searchDiaToRightDown(i, j);
                    searchDiaToLeftUp(i, j);
                }
            }
        }

        System.out.println(0);
    }

    static void searchRow(int row, int col) {
        boolean canUseChance = true;
        int temp = 0;
        int count = 5;

        for (int i = col; i < 10; i++) {
            count--;
            if (map[row][i] == 'X') {
                temp++;
            }

            if (canUseChance && map[row][i] == '.') {
                canUseChance = false;
                temp++;
            }

            if (count == 0) {
                break;
            }
        }

        if (temp == 5) {
            System.out.println(1);
            System.exit(1);
        }
    }

    static void searchCol(int row, int col) {
        boolean canUseChance = true;
        int temp = 0;

        int count = 5;
        for (int i = row; i < 10; i++) {
            count--;
            if (map[col][i] == 'X') {
                temp++;
            }

            if (canUseChance && map[col][i] == '.') {
                canUseChance = false;
                temp++;
            }

            if (count == 0) {
                break;
            }
        }

        if (temp == 5) {
            System.out.println(1);
            System.exit(1);
        }
    }

    static void searchDiaToRightDown(int row, int col) {
        boolean canUseChance = true;
        int temp = 0;

        for (int i = 0; i < 5; i++) {
            int nr = row + i;
            int nc = col + i;

            if (!(nr >= 0 && nr < 10 && nc >= 0 && nc < 10)) {
                break;
            }

            if (map[nr][nc] == ME) {
                temp++;
                continue;
            }

            if (map[nr][nc] == '.' && canUseChance) {
                canUseChance = false;
                temp++;
            }
        }

        if (temp == 5) {
            System.out.println(1);
            System.exit(1);
        }
    }

    static void searchDiaToLeftUp(int row, int col) {
        boolean canUseChance = true;
        int temp = 0;

        for (int i = 0; i < 5; i++) {
            int nr = row - i;
            int nc = col - i;

            if (!(nr >= 0 && nr < 10 && nc >= 0 && nc < 10)) {
                break;
            }

            if (map[nr][nc] == ME) {
                temp++;
                continue;
            }

            if (map[nr][nc] == '.' && canUseChance) {
                canUseChance = false;
                temp++;
            }
        }

        if (temp == 5) {
            System.out.println(1);
            System.exit(1);
        }
    }
}
