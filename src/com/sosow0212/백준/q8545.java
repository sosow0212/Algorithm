package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q8545 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String input01 = br.readLine();
        System.out.print(solution(input01));
    }

    public static String solution(String input01) {
        return new StringBuilder(input01).reverse().toString();
    }

}
