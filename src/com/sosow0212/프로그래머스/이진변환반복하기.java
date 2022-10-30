package com.sosow0212.프로그래머스;

import java.util.List;

public class 이진변환반복하기 {
    static public List<Integer> solution(String s) {
        List<Integer> answer;
        int zeroCount = 0;
        int changeCount = 0;

        while (!s.equals("1")) {
            StringBuilder sb = new StringBuilder();

            changeCount += 1;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '0') {
                    zeroCount++;
                } else {
                    sb.append(c);
                }
            }

            int n = sb.length();
            s = Integer.toBinaryString(n);
        }

        answer = List.of(changeCount, zeroCount);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("110010101001")); // 3, 8
    }
}
