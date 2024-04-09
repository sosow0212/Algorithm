package com.sosow0212.leetCode;

public class q2073 {

    public int timeRequiredToBuy(int[] tickets, int k) {
        int answer = 0;

        int i = 0;
        while (true) {
            if (i == tickets.length) {
                i = 0;
            }

            int ticket = tickets[i];

            if (ticket >= 1) {
                tickets[i]--;
            } else {
                i++;
                continue;
            }

            answer++;

            if (i == k && tickets[i] == 0) {
                break;
            }

            i++;
        }

        return answer;
    }
}
