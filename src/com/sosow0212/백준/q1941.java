package com.sosow0212.백준;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q1941 {
    private static int answer = 0;
    private static int[] princesses = new int[7];
    private static char[][] map = new char[5][5];
    private static boolean visitedOfCombination[] = new boolean[25];
    private static boolean visitedOfBfs[];
    private static int[][] pos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        initData();
        getAnswer(0, 0, 0);
        System.out.println(answer);
    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);
        map = new char[5][5];
        for (int i = 0; i < 5; i++) {
            map[i] = sc.next().toCharArray();
        }
    }

    public static void getAnswer(int index, int count, int countOfSom) {
        if (count == 7) {
            if (countOfSom >= 4) {
                if (checkAdj()) {
                    answer++;
                }
                return;
            }
            return;
        }

        for (int i = index; i < 5 * 5; i++) {
            visitedOfCombination[i] = true;
            princesses[count] = i;

            if (map[i / 5][i % 5] == 'S') {
                getAnswer(i + 1, count + 1, countOfSom + 1);
            } else {
                getAnswer(i + 1, count + 1, countOfSom);
            }

            visitedOfCombination[i] = false;
        }
    }

    public static boolean checkAdj() {
        int count = 1;
        visitedOfBfs = new boolean[5 * 5];
        queue = new LinkedList<>();
        queue.add(princesses[0]);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            visitedOfBfs[now] = true;
            for (int i = 0; i < pos.length; i++) {
                int nr = (now / 5) + pos[i][0];
                int nc = (now % 5) + pos[i][1];

                if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || visitedOfBfs[nr * 5 + nc] || !visitedOfCombination[nr * 5 + nc]) {
                    continue;
                }

                count++;
                visitedOfBfs[nr * 5 + nc] = true;
                queue.add(nr * 5 + nc);
            }
        }
        return count == 7 ? true : false;
    }
}
