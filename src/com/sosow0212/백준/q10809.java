package com.sosow0212.백준;

import java.util.Scanner;

public class q10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] alpa = new int[25];
        int[] alpaCount = new int[25];

        // 97-a ~ 122-z
        for (int i = 0; i < 25; i++) {
            alpa[i] = 97 + i;
            alpaCount[i] = -1;
        }

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < 25; j++) {
                if ((int)str.charAt(i) == alpa[j]) {
                    alpaCount[j] = i;
                }
            }
        }

        for(int i=0; i<25; i++) {
            System.out.print(alpaCount[i] + " ");
        }
    }
}
