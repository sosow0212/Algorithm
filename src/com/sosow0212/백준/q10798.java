package com.sosow0212.백준;

import java.util.Scanner;

public class q10798 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] input = new char[5][15];
        int max_length = Integer.MIN_VALUE;

        for(int i = 0; i < 5; i++) {
            String s = sc.nextLine().trim();
            max_length = Math.max(max_length, s.length());
            for(int j = 0; j < s.length(); j++) {
                input[i][j] = s.charAt(j);
            }
        }
        for(int i = 0; i < max_length; i++) {
            for(int j = 0; j < 5; j++) {
                if(input[j][i] == '\0')
                    continue;
                System.out.print(input[j][i]);
            }
        }
    }
}
