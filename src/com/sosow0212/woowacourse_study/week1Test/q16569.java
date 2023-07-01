package com.sosow0212.woowacourse_study.week1Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class q16569 {

    static int n, m, v;
    static int startRow, startCol;
    static int[][] map;
    static int[][] times;
    static int[][] pos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static List<int[]> volcano;
    static int[] answerPos;

    public static void main(String[] args) {
        initData();
        bfs();
    }

    private static void bfs() {
        Queue<int[]> p = new LinkedList<>();
        Queue<int[]> v = new LinkedList<>();

        p.add(new int[] {startRow, startCol});

    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();
        answerPos = new int[2];
        times = new int[n + 1][m + 1];
        volcano = new ArrayList<>();

        startRow = sc.nextInt();
        startCol = sc.nextInt();

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < v; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            volcano.add(new int[]{row, col});
            times[row][col] = sc.nextInt();
        }
    }
}
