package com.sosow0212.백준;

import java.util.HashSet;
import java.util.Scanner;

public class q5568 {

    public static int numberOfCard, numberOfSelect;
    public static String card[];
    public static boolean visited[];
    public static HashSet<String> hashSet = new HashSet<>();

    public static void selectCard(int remain, String str) {
        if(remain == 0) {
            hashSet.add(str);
            return;
        }

        for(int i=0; i<numberOfCard; i++) {
            if(!visited[i]) {
                visited[i] = true;
                selectCard(remain-1, str + card[i]);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        numberOfCard = sc.nextInt();
        numberOfSelect = sc.nextInt();
        card = new String[numberOfCard];
        for(int i=0; i<numberOfCard; i++) {
            card[i] = sc.next();
        }

        visited = new boolean[numberOfCard];
        selectCard(numberOfSelect, "");

        System.out.println(hashSet.size());

    }
}
