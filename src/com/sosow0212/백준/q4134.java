package com.sosow0212.백준;

import java.math.BigInteger;
import java.util.Scanner;

public class q4134 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; ++i) {
            long testValue = scanner.nextLong();
            BigInteger nextPrimeNumber = new BigInteger(String.valueOf(testValue));

            if (nextPrimeNumber.isProbablePrime(10)) {  // 입력 값이 소수면 그대로 출력
                System.out.println(nextPrimeNumber);
            } else {  // 입력 값이 소수가 아니면 다음 소수를 구해서 출력
                System.out.println(nextPrimeNumber.nextProbablePrime());
            }
        }
        scanner.close();
    }
}
