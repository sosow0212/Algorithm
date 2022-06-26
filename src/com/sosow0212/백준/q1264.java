package com.sosow0212.백준;

import java.util.Scanner;

public class q1264 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            String str = sc.nextLine();

            if(str.equals("#"))
                return;

            int count = 0;

            for(int i=0; i<str.length(); i++) {
                char c = str.charAt(i);
                if(c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U') {
                    count ++;
                }
            }

            System.out.println(count);
        }
    }
}
