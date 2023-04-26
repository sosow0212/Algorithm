package com.sosow0212.백준;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class q17614 {

    public static void main(String[] args) {
        List<String> list = List.of("3", "6", "9");
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            String strNum = String.valueOf(i);

            answer += Arrays.stream(strNum.split(""))
                    .filter(list::contains)
                    .count();
        }

        System.out.println(answer);
    }
}
