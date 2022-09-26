package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.List;

public class n2배열자르기 {
    static public List<Long> solution(int n, long left, long right) {
        List<Long> ans = new ArrayList<>();

        for (long i = left; i <= right; i++) {
            long temp = Math.max(i / n, i % n) + 1;
            ans.add(temp);
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        int left = 7;
        int right = 14;
        System.out.println(solution(n, left, right));
    }
}
