package com.sosow0212.백준;

import java.util.Scanner;

public class q12904 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String before = sc.next();
        String after = sc.next();
        boolean isDone = false;

        StringBuilder sb = new StringBuilder(after);

        while (true) {
            if (sb.toString().equals(before)) {
                isDone = true;
                break;
            }

            if (sb.length() == 0) {
                break;
            }

            char c = sb.charAt(sb.length() - 1);

            if (c == 'A') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.deleteCharAt(sb.length() - 1);
                sb.reverse();
            }
        }

        if (isDone) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
