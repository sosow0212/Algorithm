package com.sosow0212.백준;

import java.io.IOException;
import java.util.Scanner;

public class q1305 {
    private final static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) throws NumberFormatException, IOException {
        int sizeOfAd = sc.nextInt();
        String ad = sc.next();
        System.out.println(getAnswer(sizeOfAd, ad));
    }

    static int getAnswer(int sizeOfAd, String ad) {
        int index = 0;
        int[] inFir = new int[ad.length()];

        for (int i = 1; i < ad.length(); i++) {
            while (index > 0 && ad.charAt(index) != ad.charAt(i)) {
                index = inFir[index - 1];
            }

            if (ad.charAt(index) == ad.charAt(i)) {
                inFir[i] = ++index;
            }
        }
        return sizeOfAd - inFir[ad.length() - 1];
    }
}
