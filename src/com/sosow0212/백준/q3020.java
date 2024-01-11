package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q3020 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int h = sc.nextInt();

        int[] up = new int[h + 1];
        int[] down = new int[h + 1];

        int[] prefixUp = new int[h + 1];
        int[] prefixDown = new int[h + 1];
        int[] prefix = new int[h + 1];

        // 돌의 길이만큼 카운터 저장
        for (int i = 0; i < n / 2; i++) {
            down[sc.nextInt()]++;
            up[sc.nextInt()]++;
        }

        for (int i = 1; i < h + 1; i++) {
            prefix[i] = up[i] + down[h + 1 - i];
        }


        System.out.println(Arrays.toString(up));
        System.out.println(Arrays.toString(down));
        System.out.println(Arrays.toString(prefix));
        /**
         * 14 5
         * 1 3 4 2 2 4 3 4 3 3 3 2 3 4
         */
    }
}
