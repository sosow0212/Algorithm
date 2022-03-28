package com.sosow0212.백준;

import java.util.Scanner;

public class q5525 {

    public static int solve(String str, String task) {
        int answer = 0;

        for (int i = 0; i < task.length() - str.length(); i++) {
            if (task.substring(i, i + str.length()).equals(str)) {
                answer++;
            }
        }
        return answer;
    }

    // ioi
    // iooioioio


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String task = sc.next();
        String str = "IOI";
        for (int i = 0; i < n - 1; i++) {
            if (n == 1) break;
            str += "OI";
        }
        // task, str 완성

        System.out.println(solve(str, task));


    }
}
