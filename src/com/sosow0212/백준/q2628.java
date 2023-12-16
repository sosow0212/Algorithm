package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class q2628 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> weights = new ArrayList<>();
        List<Integer> heights = new ArrayList<>();

        int n = sc.nextInt();
        int m = sc.nextInt();
        weights.add(n);
        heights.add(m);

        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int option = sc.nextInt();
            int length = sc.nextInt();

            if (option == 0) {
                heights.add(length);
            } else if (option == 1) {
                weights.add(length);
            }
        }

        int maxW = getMaxLength(n, weights);
        int maxH = getMaxLength(m, heights);

        System.out.println(maxW * maxH);
    }

    private static int getMaxLength(int n, List<Integer> list) {
        int count = list.size();

        if (count == 0) {
            return n;
        }

        Collections.sort(list);

        int maxLength = list.get(0);
        for (int i = 1; i < count; i++) {
            maxLength = Math.max(maxLength, list.get(i) - list.get(i - 1));
        }

        maxLength = Math.max(maxLength, n - list.get(count - 1));

        return maxLength;
    }
}
