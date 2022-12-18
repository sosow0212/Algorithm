package com.sosow0212.프로그래머스;

public class 숫자찾기 {
    static public int solution(int num, int k) {
        int answer = 0;
        String numStr = String.valueOf(num);

        for (int i = 0; i < numStr.length(); i++) {
            if (numStr.charAt(i) - '0' == k) {
                return i + 1;
            }
        }

        if (answer == 0) {
            return -1;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(123456, 7));
    }
}
