package com.sosow0212.프로그래머스;

import java.util.Arrays;
import java.util.List;

public class A로B만들기 {
    static public int solution(String before, String after) {
        int answer = 1;

        char[] beforeArr = before.toCharArray();
        char[] afterArr = after.toCharArray();

        Arrays.sort(beforeArr);
        Arrays.sort(afterArr);

        for(int i=0; i<beforeArr.length; i++) {
            if(beforeArr[i] != afterArr[i]) {
                answer = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("olleh", "hello"));
    }
}
