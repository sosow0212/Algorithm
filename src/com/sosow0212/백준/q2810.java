package com.sosow0212.백준;

import java.util.Scanner;
import java.util.Stack;

public class q2810 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int peo = 0;
        int holder = 1;
        String str = sc.next();
        Stack<Character> stack = new Stack<>();
        stack.push('*');

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == 'S') {
                stack.push('S');
                stack.push('*');
                peo ++;
                holder ++;
            } else {
                char temp = stack.peek();
                if(temp == 'L') {
                    stack.push('L');
                    stack.push('*');
                    peo ++;
                    holder ++;
                } else {
                    stack.push('L');
                    peo ++;
                }
            }
        }

        if(holder > peo) {
            System.out.println(peo);
        } else {
            System.out.println(holder);
        }

    }
}
