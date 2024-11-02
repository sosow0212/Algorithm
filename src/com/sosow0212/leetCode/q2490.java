package com.sosow0212.leetCode;

public class q2490 {

    public boolean isCircularSentence(String sentence) {
        String[] split = sentence.split(" ");

        boolean isPass = true;
        for (int i = 1; i < split.length; i++) {
            if (split[i - 1].charAt(split[i - 1].length() - 1) != split[i].charAt(0)) {
                isPass = false;
                break;
            }
        }

        String last = split[split.length - 1];
        if (isPass && last.charAt(last.length() - 1) == split[0].charAt(0)) {
            return true;
        }

        return false;
    }
}
