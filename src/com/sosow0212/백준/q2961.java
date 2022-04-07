package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2961 {


    static int minTaste;
    static boolean[] isSelected;
    static int[][] tastes;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        isSelected = new boolean[N];
        minTaste = Integer.MAX_VALUE;
        tastes = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tastes[i][0] = Integer.parseInt(st.nextToken());
            tastes[i][1] = Integer.parseInt(st.nextToken());
        }


        subSet(0, 1, 0);

        System.out.println(minTaste);
    }

    public static void subSet(int cnt, int mulSour, int sumBitter) {
        if (cnt == N) {
            int falseCnt = 0;
            for (int i = 0; i < N; i++) {
                if (isSelected[i]) continue;
                falseCnt++;
            }
            if (falseCnt == N) return;
            minTaste = Math.min(minTaste, Math.abs(mulSour - sumBitter));
            return;
        }

        isSelected[cnt] = true;
        subSet(cnt + 1, mulSour * tastes[cnt][0], sumBitter + tastes[cnt][1]);
        isSelected[cnt] = false;
        subSet(cnt + 1, mulSour, sumBitter);


    }

}