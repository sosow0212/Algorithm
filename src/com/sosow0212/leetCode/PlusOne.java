package com.sosow0212.leetCode;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        StringBuilder sb = new StringBuilder();

        for (int digit : digits) {
            sb.append(digit);
        }

        int result = Integer.parseInt(sb.toString()) + 1;
        String[] split = String.valueOf(result).split("");

        int[] answer = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            answer[i] = Integer.parseInt(split[i]);
        }

        return answer;
    }
}
