package com.sosow0212.백준;

import java.util.Scanner;

class q5543{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int minH = 2001;
        int minD = 2001;

        for(int i = 0; i < 3; i++){
            int hamburger = sc.nextInt();
            if(hamburger < minH)
                minH = hamburger;
        }
        for(int j = 0; j < 2; j++){
            int drink = sc.nextInt();
            if(drink < minD)
                minD = drink;
        }
        System.out.print(minH + minD - 50);
    }
}