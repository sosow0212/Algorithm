package com.sosow0212.백준;

import java.util.Scanner;

public class q5622 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        // 문자열을 char형 배열로 반환
        char[] chars = str.toCharArray();

        // 총 걸리는 시간을 저장할 int형 변수
        int sum = 0;
        // foreach 반복문, char[] 배열 안에 값들을 하나씩 char형으로 처리
        for (char c : chars) {
            // 알파벳이 ABC 중 하나라면 + 3초
            if (c >= 'A' && c <= 'C') {
                sum += 3;
                // 알파벳이 DEF 중 하나라면 + 4초
            } else if (c >= 'D' && c <= 'F') {
                sum += 4;
                // 알파벳이 GHI 중 하나라면 + 5초
            } else if (c >= 'G' && c <= 'I') {
                sum += 5;
                // 알파벳이 JKL 중 하나라면 + 6초
            } else if (c >= 'J' && c <= 'L') {
                sum += 6;
                // 알파벳이 MNO 중 하나라면 + 7초
            } else if (c >= 'M' && c <= 'O') {
                sum += 7;
                // 알파벳이 PQRS 중 하나라면 + 8초
            } else if (c >= 'P' && c <= 'S') {
                sum += 8;
                // 알파벳이 TUV 중 하나라면 + 9초
            } else if (c >= 'T' && c <= 'V') {
                sum += 9;
                // 알파벳이 WXYZ 중 하나라면 + 10초
            } else if (c >= 'W' && c <= 'Z') {
                sum += 10;
            }
        }
        System.out.println(sum);
    }
}