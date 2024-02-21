package com.sosow0212.leetCode;

public class q2038 {

    public boolean winnerOfGame(String colors) {
        int alice = 0;
        int bob = 0;

        if (colors.length() < 3) {
            return false;
        }

        for (int i = 1; i < colors.length() - 1; i++) {
            if (colors.charAt(i - 1) == colors.charAt(i) && colors.charAt(i) == colors.charAt(i + 1)) {
                if (colors.charAt(i) == 'A') {
                    alice++;
                } else {
                    bob++;
                }
            }
        }

        return alice > bob;
    }

    // 6(2) 5(1) 4 3 2 1
}
