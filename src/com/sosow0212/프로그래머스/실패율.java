package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 실패율 {
    static public List<Integer> solution(int N, int[] stages) {
        List<Double> answer = new ArrayList<>();
        List<Double> temp = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        HashMap<Integer, Integer> hashMap = new HashMap<>();


        for (int i : stages) {
            if (i > N) {
                continue;
            }
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }

        for (int i = 1; i <= N; i++) {
            hashMap.put(i, hashMap.getOrDefault(i, 0));
        }


        double size = stages.length;
        for (int i = 1; i <= hashMap.size(); i++) {
            if(size == 0) {
                answer.add(0.0);
                temp.add(0.0);
                break;
            }
            answer.add(hashMap.get(i) / size);
            temp.add(hashMap.get(i) / size);
            size -= hashMap.get(i);
        }

        Collections.sort(temp, Collections.reverseOrder());


        boolean[] visited = new boolean[answer.size()];

        for (int i = 0; i < temp.size(); i++) {
            for (int j = 0; j < answer.size(); j++) {
                if (visited[j] == true)
                    continue;
                if (temp.get(i).equals(answer.get(j))) {
                    result.add(j + 1);
                    visited[j] = true;
                    continue;
                }
            }
        }

        System.out.println(answer);
        System.out.println(temp);


        return result;
    }

    public static void main(String[] args) {
        int N = 8;
        int[] stages = {1,2,3,4,5,6,7};
        System.out.println(solution(N, stages));
    }
}
