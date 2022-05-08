package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class q1092 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        Integer[] wl = new Integer[n];
        for (int i = 0; i < n; i++) {
            wl[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        Integer[] bw = new Integer[m];

        for (int i = 0; i < m; i++) {
            bw[i] = sc.nextInt();
        }

        Arrays.sort(wl, Collections.reverseOrder());
        Arrays.sort(bw, Collections.reverseOrder());

        if (bw[0] > wl[0]) System.out.println(-1);
        else {
            int result = 0;
            int[] start = new int[n];
            Arrays.fill(start, 0);
            while (m > 0) {
                for (int i=0; i<n; i++) { // 각각의 crane이 일함
                    if (m < 1) break;
                    for (int j=start[i]; j<bw.length; j++) {
                        if (bw[j]==0 || bw[j] > wl[i]) {
                            start[i]++;
                            continue;
                        }
                        bw[j] = 0;
                        m--;
                        break;
                    }
                }
                result++;
            }
            System.out.println(result);
        }
    }
}