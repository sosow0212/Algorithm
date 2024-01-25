package com.sosow0212.백준;

import java.util.Scanner;

public class q1173 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int m = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();
        int R = sc.nextInt();

        int count = 0;
        int time = 0;
        int now = m;

        while (count < N) {
            if (now + T <= M) {
                count++;
                time++;
                now += T;
                continue;
            }

            if (now - R < m) {
                now = m;
                time++;
            } else {
                now -= R;
                time++;
            }
        }

        if (now + T > M && now == m) {
            System.out.println("-1");
            return;
        }

        System.out.println(time);
    }
}
