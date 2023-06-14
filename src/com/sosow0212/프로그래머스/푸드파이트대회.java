package com.sosow0212.프로그래머스;

public class 푸드파이트대회 {

    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < food.length; i++)
            if (food[i] % 2 == 0) {
                int count = food[i] / 2;
                for (int j = 0; j < count; j++) {
                    sb.append(String.valueOf(i));
                }
            } else {
                int count = food[i] / 2;
                for (int j = 0; j < count; j++) {
                    sb.append(String.valueOf(i));
                }
            }

        StringBuilder reverse = new StringBuilder(sb).reverse();

        return sb.toString() + "0" + reverse.toString();
    }

    public static void main(String[] args) {
        푸드파이트대회 sol = new 푸드파이트대회();

        int[] food = {1, 3, 4, 6};
        System.out.println(sol.solution(food));
    }
}
