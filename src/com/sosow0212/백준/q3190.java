package com.sosow0212.백준;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class q3190 {

    private static final int APPLE = 10;
    private static final int SNAKE = 1;

    static int n;
    static int k;
    static int[][] map;
    static int l;
    static Map<Integer, Character> move;
    static Deque<int[]> deque;
    static int time;
    static int[][] pos = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][n];
        k = sc.nextInt();
        move = new LinkedHashMap<>();
        time = 0;
        deque = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;

            map[row][col] = APPLE;
        }

        l = sc.nextInt();
        for (int i = 0; i < l; i++) {
            int count = sc.nextInt();
            char dir = sc.next().charAt(0);

            move.put(count, dir);
        }

        getAnswer();
        System.out.println(time);
    }

    static void getAnswer() {
        int row = 0;
        int col = 0;
        map[row][col] = SNAKE;
        deque.add(new int[]{row, col});
        int dir = 0;

        while (true) {
            time++;

            int nr = row + pos[dir][0];
            int nc = col + pos[dir][1];

            if (!(nr >= 0 && nr < n && nc >= 0 && nc < n)) {
                break;
            }

            if (deque.size() != 1) {
                boolean isDone = false;

                for (int[] ints : deque) {
                    if (ints[0] == nr && ints[1] == nc) {
                        isDone = true;
                        break;
                    }
                }

                if (isDone) {
                    break;
                }
            }

            if (map[nr][nc] == APPLE) {
                map[nr][nc] = 0;
                deque.addFirst(new int[]{nr, nc});
            } else {
                deque.pollLast();
                deque.addFirst(new int[]{nr, nc});
            }

            if (move.containsKey(time)) {
                Character nextDir = move.get(time);

                if (nextDir == 'D') {
                    dir++;
                    if (dir == 4) {
                        dir = 0;
                    }
                } else {
                    dir--;
                    if (dir == -1) {
                        dir = 3;
                    }
                }
            }

            row = nr;
            col = nc;
        }
    }
}
