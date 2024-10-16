package com.sosow0212.leetCode;

public class q2938 {

    public long minimumSteps(String s) {
        // 11100
        long whiteCount = 0;
        long answer = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                whiteCount++;
            } else {
                answer += whiteCount;
            }
        }

        return answer;
    }
}
