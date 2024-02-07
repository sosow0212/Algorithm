package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q5671 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int answer = 0;

            for (int i = n; i <= m; i++) {
                char[] nums = String.valueOf(i).toCharArray();
                Arrays.sort(nums);

                if (nums.length < 2) {
                    answer++;
                    continue;
                }

                boolean isContinue = false;
                for (int j = 0; j < nums.length - 1; j++) {
                    if (nums[j] == nums[j + 1]) {
                        isContinue = true;
                        break;
                    }
                }

                if (isContinue) {
                    continue;
                }

                answer++;
            }
            sb.append(answer)
                    .append("\n");
        }

        System.out.println(sb.toString());
    }
}
