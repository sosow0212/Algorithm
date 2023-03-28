package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q14939 {

    private static final int LAST_IDX = 9;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr = new int[10][10];
    static int[][] temp = new int[10][10];
    static int tempAnswer;
    static int answer = Integer.MAX_VALUE;
    static int[] dx = {0, 0, 1, 0, -1};
    static int[] dy = {0, 1, 0, -1, 0};

    static void init() {
        tempAnswer = 0;
        for (int i = 0; i < 10; ++i) {
            temp[i] = arr[i].clone();
        }
    }

    static void click(int x, int y) {
        for (int i = 0; i < 5; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= 10 || ny >= 10) {
                continue;
            }
            temp[nx][ny] ^= 1;
        }
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; ++i) {
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(p -> p.equals("#") ? 0 : 1)
                    .toArray();
        }

        for (int i = 0; i < 1024; ++i) {
            init();

            for (int j = 1; j <= 10; ++j) {
                int num = 1024;
                num = num >> j;
                if ((i & num) > 0) {
                    tempAnswer++;
                    click(0, j - 1);
                }
            }

            for (int j = 1; j < 10; ++j) {
                for (int k = 0; k < 10; ++k) {
                    if (temp[j - 1][k] == 1) {
                        tempAnswer++;
                        click(j, k);
                    }
                }
            }

            if (Arrays.stream(temp[LAST_IDX]).sum() == 0) {
                answer = Math.min(answer, tempAnswer);
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? "-1" : answer);
    }
}
