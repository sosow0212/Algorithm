package com.sosow0212.백준;

import java.math.BigInteger;
import java.util.Scanner;

// 큰 수로 팰린드롬 수 구하기
// Big Integer 사용해도, 런타임에러뜸

public class q1334 {
    public static boolean isReverseNum(BigInteger n) {
        String num = String.valueOf(n);
        String reverseNum = "";
        for (int i = num.length() - 1; i >= 0; i--) {
            reverseNum += num.charAt(i);
        }
        if (num.equals(reverseNum)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = sc.nextBigInteger();
        while(true) {
            n.add(BigInteger.valueOf(1));
            if(isReverseNum(n)) {
                System.out.println(n);
                break;
            }
        }
    }
}
