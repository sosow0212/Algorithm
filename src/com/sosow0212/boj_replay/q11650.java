package com.sosow0212.boj_replay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class q11650 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Point> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            list.add(new Point(x, y));
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1.x != o2.x) {
                return o1.x - o2.x;
            }
            return o1.y - o2.y;
        });

        System.out.println(list);
    }

    static class Point {
        int x, y;

        public Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
