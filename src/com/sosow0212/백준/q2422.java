package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2422 {

    static int N;
    static int M;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            s = br.readLine();
            st = new StringTokenizer(s, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = true;
            map[y][x] = true;
        }

        System.out.println(bruteForce());

    }

    static int bruteForce() {
        int count = 0;

        for (int i = 1; i < N + 1; i++) {
            for (int j = i + 1; j < N + 1; j++) {
                for (int k = j + 1; k < N + 1; k++) {
                    if (map[i][j] || map[i][k] || map[j][k])
                        continue;
                    count++;
                }
            }
        }
        return count;
    }

}