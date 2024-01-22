package com.sosow0212.백준;

import java.util.Scanner;

public class q2828 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int j = sc.nextInt();

        int answer = 0;

        int l = 0;
        int r = m - 1;

        for (int i = 0; i < j; i++) {
            int idx = sc.nextInt() - 1;

            if (idx > r) {
                answer += idx - r;
                r = idx;
                l = idx - (m - 1);
            } else if (idx < l) {
                answer += l - idx;
                l = idx;
                r = idx + (m - 1);
            }
        }

        System.out.println(answer);
    }
}
