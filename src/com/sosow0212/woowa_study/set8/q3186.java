package com.sosow0212.woowa_study.set8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q3186 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int l = sc.nextInt();
        int n = sc.nextInt();
        String s = sc.next();

        List<Integer> list = new ArrayList<>();
        int idx = -1;

        while ((idx = s.indexOf("1".repeat(k), idx + 1)) != -1) {
            list.add(idx + k - 1);
        }

        List<Integer> answer = new ArrayList<>();
        if (list.isEmpty()) {
            System.out.println("NIKAD");
            return;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            int left = list.get(i) + 1;
            int right = list.get(i + 1);

            String subString = s.substring(left, right);
            int index = subString.indexOf("0".repeat(l));
            if (index != -1) {
                answer.add(index + l + left);
            }
        }

        int last = list.get(list.size() - 1) + 1;
        String subString = s.substring(last);
        int index = subString.indexOf("0".repeat(l));

        if (index != -1) {
            answer.add(index + l + last);
        } else {
            answer.add(s.lastIndexOf('1') + 1 + l);
        }

        for (int a : answer) {
            System.out.println(a);
        }
    }
}
