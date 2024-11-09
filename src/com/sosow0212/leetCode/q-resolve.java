package com.sosow0212.leetCode;

public class q-resolve {

    public int numTeams(int[] rating) {
        int answer = 0;

        for (int boundary = 0; boundary < rating.length; boundary++) {
            int leftSamller = 0;
            int leftLager = 0;
            int rightSmaller = 0;
            int rightLager = 0;

            for (int left = 0; left < boundary; left++) {
                if (rating[left] < rating[boundary]) {
                    leftSamller++;
                } else {
                    leftLager++;
                }
            }

            for (int right = boundary + 1; right < rating.length; right++) {
                if (rating[boundary] > rating[right]) {
                    rightSmaller++;
                } else {
                    rightLager++;
                }
            }

            // 오름차순 기준 팀 수 : 기준수보다 작은 수 * 기준수보다 큰 수 (팀의 수는 3이므로)
            answer += (leftSamller * rightLager) + (leftLager * rightSmaller);
        }

        return answer;
    }

    public static void main(String[] args) {
        q-resolve sol = new q-resolve();

        // 3
        System.out.println(sol.numTeams(new int[]{2, 5, 3, 4, 1}));

        // 0
        System.out.println(sol.numTeams(new int[]{2, 1, 3}));
    }
}
