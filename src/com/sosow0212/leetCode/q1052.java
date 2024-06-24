package com.sosow0212.leetCode;

public class q1052 {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;

        int positiveCustomer = 0;
        for (int i = 0; i < minutes; i++) {
            positiveCustomer += customers[i] * grumpy[i];
        }
        int max = positiveCustomer;

        for (int i = minutes; i < n; i++) {
            positiveCustomer += customers[i] * grumpy[i];
            positiveCustomer -= customers[i - minutes] * grumpy[i - minutes];

            max = Math.max(max, positiveCustomer);
        }

        int answer = max;

        for (int i = 0; i < customers.length; i++) {
            answer += customers[i] * (1 - grumpy[i]);
        }

        return answer;
    }
}
