package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class q12605 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        Stack<String> s = new Stack();
        for (int i = 1; i <= t; i++) {
            s.clear();
            String str = br.readLine();
            String[] split = str.split(" ");
            for (String s1 : split) {
                s.push(s1);
            }

            System.out.print("Case #" + i + ": ");
            while (!s.isEmpty()) {
                System.out.print(s.pop() + " ");
            }
            System.out.println();
        }
    }
}
