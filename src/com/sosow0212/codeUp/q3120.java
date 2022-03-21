package com.sosow0212.codeUp;

import java.util.Scanner;

public class q3120 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int result = 0;
        result += Math.abs(a - b) / 10;

        int c = Math.abs(a - b) % 10;
        if (c == 1 || c == 5) result += 1;
        else if (c == 2 || c == 4 || c == 6 || c == 9) result += 2;
        else if (c == 3 || c == 7 || c == 8) result += 3;

        System.out.println(result);
    }
}
