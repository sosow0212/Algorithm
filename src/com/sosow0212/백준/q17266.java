package com.sosow0212.백준;

import java.io.IOException;
import java.util.Scanner;

public class q17266 {

    static int[] arr;
    static int n, m;

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }

        int l = 1;
        int r = n;
        int answer = 0;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (check(mid)) {
                answer = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        String s = "";
        System.out.println(answer);
    }

    static boolean check(int mid) {
        int before = 0;

        for (int i = 0; i < m; i++) {
            if (arr[i] - mid <= before) {
                before = arr[i] + mid;
            } else {
                return false;
            }
        }

        return n - before <= 0;
    }
}
