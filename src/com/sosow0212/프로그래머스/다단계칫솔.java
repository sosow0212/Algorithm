package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 다단계칫솔 {

    static Map<String, Integer> peopleIndex;
    static Map<Integer, String> peopleName;
    static Map<String, Integer> sellingPrices;
    static ArrayList<Integer>[] list;

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        list = new ArrayList[enroll.length + 1];

        peopleIndex = new HashMap<>();
        peopleName = new HashMap<>();
        sellingPrices = new HashMap<>();

        peopleIndex.put("-", 0);
        peopleName.put(0, "-");
        sellingPrices.put("-", 0);

        for (int i = 0; i < enroll.length; i++) {
            list[i] = new ArrayList<>();
            peopleIndex.put(enroll[i], i + 1);
            peopleName.put(i + 1, enroll[i]);
            sellingPrices.put(enroll[i], 0);
        }

        list[enroll.length] = new ArrayList<>();

        for (int i = 0; i < enroll.length; i++) {
            String invitor = referral[i];
            String newbie = enroll[i];
            list[peopleIndex.get(newbie)].add(peopleIndex.get(invitor));
        }

        for (int i = 0; i < seller.length; i++) {
            String sellerName = seller[i];
            int sellingPrice = amount[i] * 100;

            dfs(sellerName, sellingPrice);
        }

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = sellingPrices.get(enroll[i]);
        }

        return answer;
    }

    static void dfs(String sellerName, int sellingPrice) {
        if (sellerName.equals("-") || sellingPrice / 10 == 0) {
            sellingPrices.put(sellerName, sellingPrices.getOrDefault(sellerName, 0) + sellingPrice);
            return;
        }

        Integer sellerIndex = peopleIndex.get(sellerName);

        int upstream = sellingPrice / 10;
        int sellerProfit = sellingPrice - upstream;
        ArrayList<Integer> next = list[sellerIndex];

        sellingPrices.put(sellerName, sellingPrices.getOrDefault(sellerName, 0) + sellerProfit);
        for (Integer i : next) {
            dfs(peopleName.get(i), upstream);
        }
    }

    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        // [360, 958, 108, 0, 450, 18, 180, 1080]
        System.out.println(Arrays.toString(solution(enroll, referral, seller, amount)));
    }
}
