package com.sosow0212.백준;

import java.util.Scanner;

public class q3568 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().replaceAll(";", "");
        String[] condition = str.split(",");

        String base = condition[0].split(" ")[0];

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < condition.length; i++) {
            String type = condition[i].replace(base, "").trim();

            StringBuilder nameCopy = new StringBuilder();
            StringBuilder delimiterCopy = new StringBuilder();

            for (char c : type.toCharArray()) {
                if (Character.isAlphabetic(c)) {
                    nameCopy.append(c);
                } else {
                    delimiterCopy.append(c);
                }
            }

            StringBuilder rev = new StringBuilder(delimiterCopy).reverse();
            String modifiedString = rev.toString().replaceAll("\\]\\[", "[]");

            answer.append(base)
                    .append(modifiedString + " ")
                    .append(nameCopy + ";")
                    .append("\n");
        }

        System.out.println(answer.toString());
    }
}
