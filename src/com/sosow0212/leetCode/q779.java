package com.sosow0212.leetCode;

public class q779 {

    public static int kthGrammar(int n, int k) {
        // 3 2 == 1
        /**
         * 0
         * 01
         * 0110
         * 01101001
         * 0110100110010110
         */

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                sb.append(0);
                continue;
            }

            String now = sb.toString();
            String[] nowSplit = now.split("");

            sb = new StringBuilder();

            for (int j = 0; j < nowSplit.length; j++) {
                if (nowSplit[j].equals("0")) {
                    nowSplit[j] = "01";
                } else {
                    nowSplit[j] = "10";
                }

                sb.append(nowSplit[j]);
            }
        }

        System.out.println(sb);
        return sb.toString().charAt(k - 1) - '0';
    }

    public static void main(String[] args) {
        System.out.println(kthGrammar(30, 434991989));
    }
}
