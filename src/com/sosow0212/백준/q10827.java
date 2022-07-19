package com.sosow0212.백준;

import java.math.BigDecimal;
import java.util.Scanner;

public class q10827 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigDecimal n = sc.nextBigDecimal();
        int m = sc.nextInt();

        BigDecimal ans = BigDecimal.ONE;

        while(m > 0) {
            ans = ans.multiply(n);
            m -= 1;
        }

        System.out.println(ans.toPlainString());
    }
}
