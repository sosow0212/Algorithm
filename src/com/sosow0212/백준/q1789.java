package com.sosow0212.백준;

import java.util.Scanner;

public class q1789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int count = 0;
        int sum = 0;

        while(true) {
            count++;
            sum += count;
            if(s == sum) {
                break;
            }
            if(s <= sum) {
                count --;
                break;
            }


        }

        System.out.println("count = " + count);
    }
}
