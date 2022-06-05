package com.sosow0212.etc;

import java.util.Scanner;

public class q3028 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String shuffle = sc.next();
        boolean[] flag = new boolean[3];
        flag[0] = true;

        for(int i=0; i<shuffle.length(); i++) {
            if(shuffle.charAt(i)=='A') {
                if(flag[0]==true) {
                    flag[0]=false;
                    flag[1]=true;
                }
                else if(flag[1]==true) {
                    flag[1]=false;
                    flag[0]=true;
                }
            }

            else if(shuffle.charAt(i)=='B') {
                if(flag[1]==true) {
                    flag[1]=false;
                    flag[2]=true;
                }
                else if(flag[2]==true) {
                    flag[2]=false;
                    flag[1]=true;
                }
            }

            else if(shuffle.charAt(i)=='C') {
                if(flag[0]==true) {
                    flag[0]=false;
                    flag[2]=true;
                }
                else if(flag[2]==true) {
                    flag[2]=false;
                    flag[0]=true;
                }
            }
        }

        if(flag[0])
            System.out.println(1);
        if(flag[1])
            System.out.println(2);
        if(flag[2])
            System.out.println(3);
    }
}
