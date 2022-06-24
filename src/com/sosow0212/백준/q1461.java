package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class q1461 {
    public static int max, num, res, farthest;
    public static List<Integer> plusList = new ArrayList<>();
    public static List<Integer> minusList = new ArrayList<>();

    public static Comparator<Integer> compare = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if(o1 > 0 && o2 > 0) {
                return (o1 > o2) ? -1:(o1 == o2) ? 0:1;
            }

            return (o1 > o2) ? 1:(o1 == o2) ? 0:-1;
        }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");

        num = Integer.parseInt(strs[0]);
        max = Integer.parseInt(strs[1]);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while(st.hasMoreTokens()) {
            int val = Integer.parseInt(st.nextToken());
            if(val > 0) plusList.add(val);
            if(val < 0) minusList.add(val);
            farthest = Math.max(farthest, Math.abs(val));
        }

        Collections.sort(plusList, compare);
        Collections.sort(minusList, compare);

        int cnt = 0;

        for(int i = 0; i < plusList.size(); i += cnt) {
            cnt = 0;
            int select = 0;
            for(int j = 0; j < max; j++) {
                if(i + j < plusList.size()) {
                    select = Math.max(select, Math.abs(plusList.get(i + j)));
                    cnt++;
                }
            }
            res += select * 2;
        }

        for(int i = 0; i < minusList.size(); i += cnt) {
            cnt = 0;
            int select = 0;
            for(int j = 0; j < max; j++) {
                if(i + j < minusList.size()){
                    select = Math.max(select, Math.abs(minusList.get(i + j)));
                    cnt++;
                }
            }
            res += select * 2;
        }

        System.out.println(res - farthest);
    }
}