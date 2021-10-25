package com.sosow0212.백준;

import java.math.BigInteger;
import java.util.Scanner;

public class q1271 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger n = in.nextBigInteger();
        BigInteger m = in.nextBigInteger();
        in.close();
        System.out.println(n.divide(m));
        System.out.println(n.remainder(m));

    }
}
