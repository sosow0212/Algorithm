package com.sosow0212.study;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P1 {

    public int solution(int[] boxes, int m, int k) {
        List<Integer> arr = Arrays.stream(boxes)
                .boxed()
                .sorted(Collections.reverseOrder())
                .toList();

        for (int i = 0; i < k; i++) {
            int count = m / 10000;

            for (int j = 0; j < boxes.length; j++) {
                if (count * arr.get(j) <= 100000) {
                    m += (count * arr.get(j));
                    break;
                }
            }
        }

        return m;
    }

    public static void main(String[] args) {
        P1 p1 = new P1();

        // 1294200
        System.out.println(p1.solution(
                new int[]{1000, 800, 900}, 1000000, 3)
        );

    }
}
