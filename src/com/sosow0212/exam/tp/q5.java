package com.sosow0212.exam.tp;

public class q5 {

    public static long solution(long orderAmount, long taxFreeAmount, long serviceFee) {
        long provP = orderAmount - serviceFee;

        // 예외인 경우
        if (provP - taxFreeAmount == 1) {
            return 0;
        }

        double needToPay = (provP - taxFreeAmount) / 1.1;
        return (long) Math.ceil(needToPay * 0.1);
    }

    public static void main(String[] args) {
        // 10
        System.out.println(solution(120, 0, 20));
    }
}
