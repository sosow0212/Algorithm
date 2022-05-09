package com.sosow0212.프로그래머스;

// 카카오 21년도 채용연계 인턴쉽 문제
public class 숫자문자열과영단어 {
    public int solution(String s) {
        int answer = 0;

        String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] word = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i=0; i<10; i++) {
            s = s.replace(word[i], num[i]);
        }

        return Integer.parseInt(s);
    }


    public static void main(String[] args) {
        String s = "one4seveneight";
        숫자문자열과영단어 sol = new 숫자문자열과영단어();
        System.out.println(sol.solution(s)); // 1478
    }
}
