package com.sosow0212.woowa_study.set1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class q1946 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int test = sc.nextInt();

        for (int t = 0; t < test; t++) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt();
        ArrayList<Grade> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list.add(new Grade(a, b));
        }

        Collections.sort(list);

        int ans = 1;
        int min = list.get(0).b;

        for (int i = 1; i < n; i++) {
            if (list.get(i).b < min) {
                ans++;
                min = list.get(i).b;
            }
        }

        System.out.println(ans);
    }
}

class Grade implements Comparable<Grade> {

    int a;
    int b;

    Grade(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Grade o) {
        if (this.a > o.a) {
            return 1;
        } else {
            return -1;
        }
    }
}
