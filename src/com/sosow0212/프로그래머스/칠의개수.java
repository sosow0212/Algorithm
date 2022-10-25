package com.sosow0212.프로그래머스;

public class 칠의개수 {
    static public int solution(int[] array) {
        int answer = 0;

        for(int i : array) {
            String str = String.valueOf(i);
            for(int j=0; j<str.length(); j++) {
                if(str.charAt(j) == '7') {
                    answer ++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {7, 77, 17};
        System.out.println(solution(arr)); // 4
    }
}
