package com.sosow0212.leetCode;

public class q476 {

    public int findComplement(int num) {
        StringBuilder sb = new StringBuilder();

        String binaryString = Integer.toBinaryString(num);
        for (char c : binaryString.toCharArray()) {
            if (c == '1') {
                sb.append("0");
            } else {
                sb.append("1");
            }
        }

        String after = sb.toString();
        return Integer.parseInt(after, 2);
    }
}
