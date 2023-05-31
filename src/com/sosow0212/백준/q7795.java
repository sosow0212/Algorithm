package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q7795 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            sol();
        }
    }

    public static void sol() {
        int sizeA = sc.nextInt();
        int sizeB = sc.nextInt();

        int[] a = new int[sizeA];
        int[] b = new int[sizeB];

        for (int i = 0; i < sizeA; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < sizeB; i++) {
            b[i] = sc.nextInt();
        }

        // 1 1 3 7 8
        // 1 3 6
        int answer = 0;

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < sizeA; i++) {
            int aNum = a[i];

            for (int j = 0; j < sizeB; j++) {
                if (aNum <= b[j]) {
                    break;
                }
                answer++;
            }
        }

        System.out.println(answer);
    }
}
