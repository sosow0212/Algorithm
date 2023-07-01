package com.sosow0212.woowacourse_study.week1Test;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class q23757 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        PriorityQueue<Integer> gifts = new PriorityQueue<>(Collections.reverseOrder());
        int[] kids = new int[m];

        int giftMaxVal = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            gifts.add(num);
            giftMaxVal = Math.max(num, giftMaxVal);
        }

        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            kids[i] = num;
            if (num > giftMaxVal) {
                System.out.println(0);
                return;
            }
        }

        for (int kid : kids) {
            if (gifts.size() == 0) {
                System.out.println(0);
                return;
            }

            Integer gift = gifts.poll();
            if (kid > gift) {
                System.out.println(0);
                return;
            }

            gifts.add(gift - kid);
        }

        // 선물 4 3 2 1
        // 아이 3 2 1 1

        // 선물 4 3 2 1
        // 아이 5 3 1

        System.out.println(1);
    }
}
