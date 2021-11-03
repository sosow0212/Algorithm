package com.sosow0212.백준;

import java.util.Scanner;

public class q1152{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine().trim();
        scan.close();
        if(str.isEmpty()){
            System.out.println(0);
        }else{
            String[] words = str.split(" ");
            System.out.println(words.length);
        }
    }
}