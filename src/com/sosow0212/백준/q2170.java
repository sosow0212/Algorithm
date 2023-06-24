package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class q2170 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] lines = new int[n][2];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            lines[i][0] = Integer.parseInt(str.split(" ")[0]);
            lines[i][1] = Integer.parseInt(str.split(" ")[1]);
        }

        Arrays.sort(lines, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                } else {
                    return Integer.compare(o1[0], o2[0]);
                }
            }
        });

        int start = lines[0][0];
        int end = lines[0][1];
        int answer = lines[0][1] - lines[0][0];

        for (int i = 1; i < n; i++) {
            if (lines[i][0] >= start && lines[i][1] <= end) {
                continue;
            } else if (lines[i][0] < end) {
                answer += lines[i][1] - end;
            } else {
                answer += lines[i][1] - lines[i][0];
            }

            start = lines[i][0];
            end = lines[i][1];
        }

        System.out.println(answer);
    }
}
