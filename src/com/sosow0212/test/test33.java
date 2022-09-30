package com.sosow0212.test;

import java.util.*;

public class test33 {
    public static void main(String[] args) {

        long n = 118372;
        long answer = 0;

        String nStr = String.valueOf(n);
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nStr.length(); i++) {
            list.add(nStr.charAt(i) - '0');
        }
        Collections.sort(list);

        String ans = "";
        for (int i = list.size() - 1; i >= 0; i--) {
            ans += String.valueOf(list.get(i));
        }
        answer = Long.valueOf(ans);
        System.out.println(answer);
    }
}
