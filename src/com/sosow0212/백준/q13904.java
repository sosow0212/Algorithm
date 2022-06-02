package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class q13904 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] work = new int[n][2];
        int ans = 0;
        int day = 0;
        for(int i=0; i<n; i++) {
            work[i][0] = sc.nextInt();
            work[i][1] = sc.nextInt();
        }

        Arrays.sort(work, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[1], o1[1]);
            }
        });

        int[] score = new int[1001];
        for(int i=0; i<n; i++) {
            for(int j = work[i][0]; j>0; j--) {
                if(score[j] == 0) {
                    score[j] = work[i][1];
                    break;
                }
            }
        }

        for(int i=0; i<score.length; i++) {
            ans += score[i];
        }

        System.out.println(ans);
    }
}
