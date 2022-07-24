package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class q9935 {
    static StringBuilder sb = new StringBuilder();
    static String bomb, str;
    static int bombLen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        bomb = br.readLine();
        bombLen = bomb.length();

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (sb.length() >= bombLen) {
                if (sb.substring(sb.length() - bombLen, sb.length()).equals(bomb)) {
                    sb.delete(sb.length() - bombLen, sb.length());
                }
            }
        }
        System.out.println(sb.length() == 0 ? "FRULA" : sb);
    }
}
