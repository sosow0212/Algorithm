package com.sosow0212.백준;

public class test {
    public static void main(String[] args) {
        int level = 10;
        int rootLevel = 2;
        int spaceNum = level - 1;

        for (int i = 1; i <= level; i++) {
            spaceNum--;
            for (int g = 0; g <= spaceNum; g++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= ((i * 2) - 1); j++) {
                System.out.print("*");
            }
            System.out.println("\n");
        }
        System.out.println("❤ ️메리크리스마스 ❤");
        for (int i = 1; i <= rootLevel; i++) {
            for (int g = 1; g < level; g++) {
                System.out.print(" ");
            }
            System.out.print("*\n");
        }
    }
}
