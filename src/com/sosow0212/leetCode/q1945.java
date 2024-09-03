package com.sosow0212.leetCode;

public class q1945 {

    public int getLucky(String s, int k) {
        String numericString = "";

        for (char ch : s.toCharArray()) {
            numericString += Integer.toString(ch - 'a' + 1);
        }

        while (k-- > 0) {
            int sum = 0;
            for (char c : numericString.toCharArray()) {
                sum += c - '0';
            }

            numericString = String.valueOf(sum);
        }

        return Integer.parseInt(numericString);
    }

    public static void main(String[] args) {
        q1945 sol = new q1945();

        System.out.println(sol.getLucky("iiii", 1));
    }
}
