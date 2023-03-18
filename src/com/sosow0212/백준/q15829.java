package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int prime = 1234567891;

        long sum = 0;
        long r = 1;

        for (int i = 0; i < n; i++) {
            sum += ((input.charAt(i) - 'a' + 1) * r) % prime;
            r = (r * 31) % prime;
        }

        System.out.println(sum % prime);
    }
}
