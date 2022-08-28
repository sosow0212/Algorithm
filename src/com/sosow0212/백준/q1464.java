package com.sosow0212.백준;

import java.util.Scanner;

public class q1464 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        String s = str.substring(0,1);

        for(int i=1; i<str.length(); i++) {
            if(s.charAt(i-1) < str.charAt(i)) {
                s = str.charAt(i) + s;
            } else {
                s = s + str.charAt(i);
            }
        }

        String temp = "";
        for(int i=s.length()-1; i>=0; i--) {
            temp += s.charAt(i);
        }

        System.out.println(temp);
    }

}
