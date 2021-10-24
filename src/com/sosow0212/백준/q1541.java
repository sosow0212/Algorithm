package com.sosow0212.백준;

import java.util.Scanner;

// 그리디 어려움 다시
public class q1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = Integer.MAX_VALUE;
        String[] calText = sc.nextLine().split("-");

        for (int i = 0; i < calText.length; i++) {
            int temp = 0;

            // 뺄셈으로 나뉜 토큰을 덧셈으로 분리하여 해당 토큰들을 더한다.
            String[] addition = calText[i].split("\\+");

            // 덧셈으로 나뉜 토큰들을 모두 더한다.
            for (int j = 0; j < addition.length; j++) {
                temp += Integer.parseInt(addition[j]);
            }

            // 첫번째 토큰인 경우 temp값이 첫번째 수가 됨
            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}
