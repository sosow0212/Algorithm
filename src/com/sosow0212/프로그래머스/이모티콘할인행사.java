package com.sosow0212.프로그래머스;

import java.util.Arrays;

public class 이모티콘할인행사 {

    static int[] discountPercentage = {90, 80, 70, 60};
    static int totalPlusMember;
    static int totalBuyingPrice;

    public int[] solution(int[][] users, int[] emoticons) {
        initData();
        dfs(0, emoticons, users, new int[emoticons.length]);
        return new int[]{totalPlusMember, totalBuyingPrice};
    }

    private void initData() {
        totalPlusMember = 0;
        totalBuyingPrice = 0;
    }

    private void dfs(int index, int[] emoticons, int[][] users, int[] percentages) {
        if (index == emoticons.length) {
            findAnswer(emoticons, users, percentages);
            return;
        }

        for (int rate : discountPercentage) {
            percentages[index] = rate;
            dfs(index + 1, emoticons, users, percentages);
        }
    }

    private void findAnswer(final int[] emoticons, final int[][] users, final int[] percentages) {
        int plusMember = 0;
        int totalPrice = 0;

        for (int[] user : users) {
            int buyingPrice = 0;
            int percentage = user[0];
            int price = user[1];

            for (int i = 0; i < percentages.length; i++) {
                if (100 - percentages[i] >= percentage) {
                    buyingPrice += emoticons[i] * percentages[i] / 100;
                }

                if (buyingPrice >= price) {
                    plusMember++;
                    buyingPrice = 0;
                    break;
                }
            }

            totalPrice += buyingPrice;
        }

        if (plusMember > totalPlusMember) {
            totalPlusMember = plusMember;
            totalBuyingPrice = totalPrice;
            return;
        }

        if (plusMember == totalPlusMember) {
            totalBuyingPrice = Math.max(totalBuyingPrice, totalPrice);
        }
    }

    public static void main(String[] args) {
        이모티콘할인행사 sol = new 이모티콘할인행사();

        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emoticons = {7000, 9000};

        // 1, 5400
        System.out.println(Arrays.toString(sol.solution(users, emoticons)));


        int[][] users2 = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons2 = {1300, 1500, 1600, 4900};

        // 4, 13860
        System.out.println(Arrays.toString(sol.solution(users2, emoticons2)));
    }
}
