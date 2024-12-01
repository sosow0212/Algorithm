package com.sosow0212.leetCode;

public class q1346 {

    public boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    continue;
                }

                if (arr[i] == arr[j] * 2) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        q1346 sol = new q1346();

        System.out.println(sol.checkIfExist(new int[]{7, 1, 14, 11}));
    }
}
