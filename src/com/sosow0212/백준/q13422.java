package com.sosow0212.백준;

import java.util.Scanner;

public class q13422 {

    static final Scanner sc = new Scanner(System.in);
    static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            solve();
        }

        System.out.println(sb.toString());
    }

    static void solve() {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int answer = 0;

        // -1   0   1   2   3   4   5   6   7    8     9
        //  0   3   4   7   5   6   4   2   9   (3)   (4)
        //  0   3   7   14  19  25  29  31  40   43   47
        int[] arr = new int[n + m]; // 8 -> 10
        int[] prefix = new int[n + m];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        // n == m 예외
        if (n == m) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += arr[i];
            }

            if (sum < k) {
                sb.append(1);
            } else {
                sb.append(0);
            }

            sb.append("\n");
            return;
        }


        for (int i = n + 1; i <= n - 1 + m; i++) {
            arr[i] = arr[i - n];
        }

        prefix[1] = arr[1];
        for (int i = 2; i < arr.length; i++) {
            prefix[i] += prefix[i - 1] + arr[i];
        }

        for (int i = 0; i < prefix.length - m; i++) {
            int still = prefix[i + m] - prefix[i];

            if (still < k) {
                answer++;
            }
        }

        sb.append(answer)
                .append("\n");
    }
}
