package com.sosow0212.woowa_study.set8;

import java.util.Scanner;

public class q27962 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();

        for (int i = 1; i < n; i++) {
            String a = str.substring(0, i);
            String b = str.substring(n - i);

            int cnt = 0;
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) != b.charAt(j)) {
                    cnt++;
                }
            }

            if (cnt == 1) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }
}
