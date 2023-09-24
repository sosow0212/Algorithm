package com.sosow0212.woowa_study.set3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q28298 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);

        char[][] map = new char[n][m];
        int[] alphabets = new int[26];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int boundaryPoint = n * m / (k * k);

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {

                for (int alphabet = 0; alphabet < 26; alphabet++) {
                    alphabets[alphabet] = 0;
                }

                for (int v = 0; v < n - k + 1; v += k) {
                    for (int w = 0; w < m - k + 1; w += k) {
                        char t = map[v + i][w + j];
                        alphabets[t - 'A']++;
                    }
                }

                int maxTileNum = 0;
                int maxTileIndex = 0;
                for (int v = 0; v < 26; v++) {
                    if (alphabets[v] > maxTileNum) {
                        maxTileNum = alphabets[v];
                        maxTileIndex = v;
                    }
                }

                answer += boundaryPoint - maxTileNum;
                char maxTile = (char) (maxTileIndex + 'A');

                for (int v = 0; v < n - k + 1; v += k) {
                    for (int w = 0; w < m - k + 1; w += k) {
                        map[v + i][w + j] = maxTile;
                    }
                }
            }
        }

        System.out.println(answer);

        for (char[] line : map) {
            System.out.println(new String(line));
        }
    }
}
