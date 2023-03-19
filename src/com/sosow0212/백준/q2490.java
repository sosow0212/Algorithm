package com.sosow0212.백준;

import java.util.List;
import java.util.Scanner;

public class q2490 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            List<String> split = List.of(sc.nextLine().split(" "));

            int count = (int) split.stream()
                    .filter(number -> number.equals("1"))
                    .count();

            if (count == 3) {
                System.out.println("A");
            } else if (count == 2) {
                System.out.println("B");
            } else if (count == 1) {
                System.out.println("C");
            } else if(count == 0) {
                System.out.println("D");
            } else {
                System.out.println("E");
            }

        }
    }
}
