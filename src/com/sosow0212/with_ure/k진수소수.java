package com.sosow0212.with_ure;

import java.util.ArrayList;
import java.util.List;

public class k진수소수 {

    public static int solution(int n, int k) {
        int answer = 0;

        String s = toRadix(n, k);
        String[] numbers = s.split("0");

        List<String> pure = new ArrayList<>();
        for (String number : numbers) {
            if (!number.contains(" ") && !number.isBlank()) {
                pure.add(number);
            }
        }

        for (String number : pure) {
            if (isPrime(Long.parseLong(number))) {
                answer++;
            }
        }

        return answer;
    }

    public static String toRadix(int number, int radix) {
        return Integer.toString(number, radix);
    }

    public static boolean isPrime(Long number) {
        if (number < 2) {
            return false;
        }

        if (number == 2) {
            return true;
        }

        for (int i = 3; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // 3
        System.out.println(solution(437674, 3));

        // 2
        System.out.println(solution(110011, 10));
    }
}
