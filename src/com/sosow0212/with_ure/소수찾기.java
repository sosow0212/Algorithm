package com.sosow0212.with_ure;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {

    static Set<Integer> numberSet;
    static boolean[] visited;
    static int answer;

    public static int solution(String numbers) {
        answer = 0;

        numberSet = new HashSet<>();
        visited = new boolean[numbers.length()];
        permutation(0, "", numbers);

        findPrime();

        return answer;
    }

    private static void permutation(final int index, final String sum, final String numbers) {
        if (index == numbers.length()) {
            numberSet.add(Integer.parseInt(sum));
            return;
        }

        if (!sum.equals("")) {
            numberSet.add(Integer.parseInt(sum));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(index + 1, sum + numbers.charAt(i), numbers);
                visited[i] = false;
            }
        }
    }

    private static void findPrime() {
        for (Integer number : numberSet) {

            if (number <= 1) {
                continue;
            }

            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                answer++;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(solution("17")); // 3
        System.out.println(solution("011")); // 2
    }
}
