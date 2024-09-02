package com.sosow0212.leetCode;

public class q1894 {

    public int chalkReplacer(int[] chalk, int k) {
        int index = 0;
        while (true) {
            if (index >= chalk.length) {
                index = 0;
            }

            if (chalk[index] > k) {
                break;
            }

            k -= chalk[index];

            index++;
        }

        return index;
    }

    public int chalkReplacer2(int[] chalk, int k) {
        int n = chalk.length;

        long[] prefixSum = new long[n];
        prefixSum[0] = chalk[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + chalk[i];
        }

        long sum = prefixSum[n - 1];
        long remainingChalk = (k % sum);
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int need = chalk[i];

            if (remainingChalk < need) {
                answer = i;
                break;
            }

            remainingChalk -= need;
        }

        return answer;
    }

    public static void main(String[] args) {
        q1894 sol = new q1894();

        System.out.println(sol.chalkReplacer2(new int[]{5, 1, 5}, 22));
    }
}
