package com.sosow0212.백준;

import java.util.*;

public class q2865 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int peopNum = sc.nextInt();
        int genreNum = sc.nextInt();
        int finalNum = sc.nextInt();
        ArrayList<pair> list = new ArrayList();
        float answer = 0;
        ArrayList<Integer> finalidlist = new ArrayList();

        for (int i = 0; i < genreNum; i++) {
            for (int j = 0; j < peopNum; j++) {
                int id = sc.nextInt();
                float ability = sc.nextFloat();
                list.add(new pair(id, ability));
            }
        }
        Collections.sort(list, new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                return Float.compare(o2.ability, o1.ability);
            }
        });
        for (pair thispair : list) {
            if (finalidlist.size() >= finalNum) break;
            if (!finalidlist.contains(thispair.id)) {
                answer += thispair.ability;
                finalidlist.add(thispair.id);
            } else {
                continue;
            }
        }
        System.out.printf("%.1f\n", answer);
    }
}

class pair {
    int id;
    float ability;

    public pair(int id, float ability) {
        this.id = id;
        this.ability = ability;
    }
}