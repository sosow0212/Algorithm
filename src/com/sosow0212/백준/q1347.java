package com.sosow0212.백준;

import java.util.Scanner;

public class q1347 {

    static int[] dir;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();

        char[][] map = new char[101][101];

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                map[i][j] = '#';
            }
        }

        int row = 50;
        int col = 50;
        map[row][col] = '.';
        dir = new int[]{1, 0};

        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);

            if (c == 'F') {
                row += dir[0];
                col += dir[1];
                map[row][col] = '.';
            } else {
                dir = getDir(dir, c);
            }
        }
        int leftRow = 50;
        int leftCol = 50;
        int rightRow = 50;
        int rightCol = 50;

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (map[i][j] == '.') {
                    if (i < 50) {
                        leftRow = i;
                    }
                    if (leftCol > j) {
                        leftCol = j;
                    }
                    if (rightRow < i) {
                        rightRow = i;
                    }
                    if (rightCol < j) {
                        rightCol = j;
                    }
                }
            }
        }

        for (int i = leftRow; i <= rightRow; i++) {
            for (int j = leftCol; j <= rightCol; j++) {
                System.out.print(map[i][j] + "");
            }
            System.out.println();
        }
    }

    static int[] getDir(int[] dir, char command) {
        if (dir[0] == 1 && dir[1] == 0) {
            if (command == 'R') {
                return new int[]{0, -1};
            } else {
                return new int[]{0, 1};
            }
        }

        if (dir[0] == 0 && dir[1] == 1) {
            if (command == 'R') {
                return new int[]{1, 0};
            } else {
                return new int[]{-1, 0};
            }
        }

        if (dir[0] == -1 && dir[1] == 0) {
            if (command == 'R') {
                return new int[]{0, 1};
            } else {
                return new int[]{0, -1};
            }
        }

        if (dir[0] == 0 && dir[1] == -1) {
            if (command == 'R') {
                return new int[]{-1, 0};
            } else {
                return new int[]{1, 0};
            }
        }

        return new int[]{0, 0};
    }
}
