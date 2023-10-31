package com.sosow0212.백준;

import java.util.List;
import java.util.Scanner;

public class q4659 {

    static final List<String> AEIOU = List.of("a", "e", "i", "o", "u");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String str = sc.next();

            if (str.equals("end")) {
                break;
            }

            String[] words = str.split("");

            // 1. 모음 하나라도 포함 되는지 확인
            boolean pass = false;
            for (String word : words) {
                if (AEIOU.contains(word)) {
                    pass = true;
                    break;
                }
            }

            if (!pass) {
                printWrong(str);
                continue;
            }


            // 2. 모음 자음 3개 연속
            boolean pass2 = true;
            int aeiou = 0;
            int etc = 0;
            for (String word : words) {
                if (AEIOU.contains(word)) {
                    aeiou++;
                    etc = 0;
                } else {
                    aeiou = 0;
                    etc++;
                }

                if (aeiou >= 3 || etc >= 3) {
                    pass2 = false;
                    break;
                }
            }

            if (!pass2) {
                printWrong(str);
                continue;
            }

            // 3. 같은 글자 두번 안됨, ee & oo만 가능
            boolean pass3 = true;
            String before = words[0];
            for (int i = 1; i < words.length; i++) {
                String now = words[i];

                if ((!now.equals("o") && !now.equals("e")) && before.equals(now)) {
                    pass3 = false;
                    break;
                }

                before = now;
            }
            if (!pass3) {
                printWrong(str);
                continue;
            }

            printAnswer(str);
        }

        // <baekjoon> is acceptable.
    }

    public static void printAnswer(final String word) {
        System.out.println("<" + word + "> is acceptable.");
    }

    public static void printWrong(final String word) {
        System.out.println("<" + word + "> is not acceptable.");
    }
}

