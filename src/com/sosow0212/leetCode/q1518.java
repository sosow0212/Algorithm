package com.sosow0212.leetCode;

public class q1518 {

    // https://leetcode.com/problems/water-bottles/solutions/5432686/easy-way-to-solve-it-java

    public int numWaterBottles(int numBottles, int numExchange) {
        int answer = 0;
        int lastBottles = 0;

        while (true) {
            // 1. 온전한 물을 마신다
            answer += numBottles;

            // 2. 빈 병을 구한다
            int emptyBottles = numBottles + lastBottles;

            // 3. 다음에 마실 물을 구한다.
            numBottles = emptyBottles / numExchange;

            // 4. 다음에 사용할 빈 병을 구한다
            lastBottles = emptyBottles % numExchange;

            // 마실 물이 없다면 종료한다.
            if (numBottles == 0) {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        q1518 sol = new q1518();

        // 19
        System.out.println(sol.numWaterBottles(15, 4));
    }
}
