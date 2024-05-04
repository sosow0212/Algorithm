package com.sosow0212.leetCode;

import java.util.Arrays;

public class q881 {

    public int numRescueBoats(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }

            right--;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        q881 sol = new q881();

        // 4
        System.out.println(sol.numRescueBoats(new int[]{3, 5, 3, 4}, 5));
    }
}
