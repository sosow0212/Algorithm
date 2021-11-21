package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Scanner;

public class q10994 {

    static int n;
    static ArrayList<String> al = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        al.add("*");

        for(int a = 1; a < n; a++) {
            for(int i = 0 ; i < al.size(); i++) {
                String temp = al.get(i);
                al.remove(i);
                al.add(i, "* "+temp+" *");
            }

            String temp = al.get(0);
            String empty = "";

            for(int i = 0; i < temp.length()-2; i++) {
                empty += " ";
            }
            al.add("*"+empty+"*");
            temp = "";

            for(int i = 0; i < empty.length()+2; i++) {
                temp += "*";
            }

            al.add(temp);
        }

        for(int i = al.size()-1; i > 0; i--) {
            System.out.println(al.get(i));
        }

        for(int i = 0 ; i < al.size(); i++) {
            System.out.println(al.get(i));
        }

    }

}