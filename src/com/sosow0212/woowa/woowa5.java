package com.sosow0212.woowa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class woowa5 {

    static int[] moneyType = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static void main(String[] args) {
        int money = 50237;
        System.out.println(solution(money)); // 1, 0, 0, 0, 0, 2, 0, 3, 7
    }

    // 5만, 1만, 5천, 1천, 5백, 1백, 5십, 1십, 1
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        answer = getCount(money);
        System.out.println(answer);

        return answer;
    }

    public static List<Integer> getCount(int money) {
        List<Integer> countOfMoneySortedByType = new ArrayList<>();
        int mod = 0;

        for (int i = 0; i < moneyType.length; i++) {
            if (money >= moneyType[i]) {
                mod = money / moneyType[i];
                money -= (mod * moneyType[i]);
                countOfMoneySortedByType.add(mod);
                continue;
            }

            countOfMoneySortedByType.add(0);
        }

        return countOfMoneySortedByType;
    }
}
