package com.sosow0212.leetCode;

public class q6 {

    public String convert(String s, int numRows) {
        if (s.length() <= 2) {
            return s;
        }

        if (numRows == 1) {
            return s;
        }

        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }

        sb[0].deleteCharAt(0);

        int row = 0;
        boolean isDown = true;
        for (int i = 0; i < s.length(); i++) {
            if (row == numRows) {
                isDown = false;
                row = numRows - 2;
            }

            if (row == 0) {
                isDown = true;
                row = 0;
            }

            if (isDown) {
                sb[row].append(s.charAt(i));
                row++;
            } else {
                sb[row].append(s.charAt(i));
                row--;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (StringBuilder stringBuilder : sb) {
            answer.append(stringBuilder.toString());
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        q6 sol = new q6();

        // PAHNAPLSIIGYIR
//        System.out.println(sol.convert("PAYPALISHIRING", 3));

        // A
        System.out.println(sol.convert("ABC", 1));
    }
}
