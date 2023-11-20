package com.sosow0212.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class rep {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];

                if (pq.size() < k) {
                    pq.add(new int[]{nums1[i], nums2[j], sum});
                } else {
                    if (sum < pq.peek()[2]) {
                        pq.poll();
                        pq.add(new int[]{nums1[i], nums2[j], sum});
                    } else {
                        break;
                    }
                }
            }
        }

        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            List<Integer> pairList = new ArrayList<>();
            pairList.add(pair[0]);
            pairList.add(pair[1]);
            answer.add(0, pairList);
        }

        return answer;
    }

    public static void main(String[] args) {
        q373 sol = new q373();

        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;

        System.out.println(sol.kSmallestPairs(nums1, nums2, k));
    }
}
