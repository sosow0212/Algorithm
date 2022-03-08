package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Scanner;

public class q2864 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        String num1 = sc.next();
        String num2 = sc.next();
        String num1_1 = "";
        String num1_2 = "";
        String num2_1 = "";
        String num2_2 = "";

        for (int i = 0; i < num1.length(); i++) {
            if (num1.charAt(i) == '5') {
                num1_2 = num1_2 + "6";
            } else {
                num1_2 = num1_2 + num1.charAt(i);
            }
            if (num1.charAt(i) == '6') {
                num1_1 = num1_1 + "5";
            } else {
                num1_1 = num1_1 + num1.charAt(i);
            }


        }

        for (int i = 0; i < num2.length(); i++) {
            if (num2.charAt(i) == '5') {
                num2_2 = num2_2 + "6";
            } else {
                num2_2 = num2_2 + num2.charAt(i);
            }
            if (num2.charAt(i) == '6') {
                num2_1 = num2_1 + "5";
            } else {
                num2_1 = num2_1 + num2.charAt(i);
            }

        }
        list.add(Integer.parseInt(num1_1) + Integer.parseInt(num2_1));
        list.add(Integer.parseInt(num1_2) + Integer.parseInt(num2_2));
        System.out.printf("%d %d", list.get(0), list.get(1));
        sc.close();
    }
}