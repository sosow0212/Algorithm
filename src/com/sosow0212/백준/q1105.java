package com.sosow0212.백준;

import java.util.Scanner;

public class q1105 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = 0;
        String l = sc.next();
        String r = sc.next();

        if(l.length() != r.length()) {
            System.out.println(ans);
            return;
        } else {
            for(int i=0; i<l.length(); i++) {
                if(l.charAt(i) != r.charAt(i))
                    break;

                if(l.charAt(i) == '8')
                    ans ++;
            }

            System.out.println(ans);
        }
    }
}
