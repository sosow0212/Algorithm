package com.sosow0212.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class q218 {

    static class Building {
        int x;
        int y;
        boolean isStartPoint;

        public Building(final int x, final int y, final boolean isStartPoint) {
            this.x = x;
            this.y = y;
            this.isStartPoint = isStartPoint;
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Building> buildingsList = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();

        for (int[] building : buildings) {
            buildingsList.add(new Building(building[0], building[2], true));
            buildingsList.add(new Building(building[1], building[2], false));
        }

        Collections.sort(buildingsList, (o1, o2) -> {
            if (o1.x != o2.x) {
                return o1.x - o2.x;
            } else if (o1.isStartPoint && !o2.isStartPoint) {
                return -1;
            } else if (!o1.isStartPoint && o2.isStartPoint) {
                return 1;
            } else if (o1.isStartPoint && o2.isStartPoint) {
                return o2.y - o1.y;
            } else {
                return o1.y - o2.y;
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        pq.add(0);

        for (Building building : buildingsList) {
            int top = pq.peek();

            if (building.isStartPoint) {
                pq.offer(building.y);
            } else {
                pq.remove(building.y);
            }

            if (top != pq.peek()) {
                answer.add(List.of(building.x, pq.peek()));
            }
        }

        return answer;
    }
}
