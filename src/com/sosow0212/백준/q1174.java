package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q1174 {
    static List<Long> list = new ArrayList<>();
    static int[] num = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        makeNum(0, 0);
        list.sort(null);
        if (n > 1023) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(n - 1));
        }

    }

    static void makeNum(long sum, int index) {
        if (!list.contains(sum)) {
            list.add(sum);
        }

        if (index >= 10) {
            return;
        }

        makeNum((sum * 10) + num[index], index + 1);
        makeNum(sum, index + 1);
    }
}
