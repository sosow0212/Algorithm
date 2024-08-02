package com.sosow0212.leetCode;

public class q2134 {

    public static int minSwaps(int[] nums) {
        /**
         * 아이디어 : 원형배열이므로, 슬라이딩 윈도우로 모든 케이스를 탐색할 것임
         * 1을 순차적으로 세워놔야하므로 일단 전체 1의 크기를 슬라이딩 윈도우의 사이즈로 정한다.
         * 슬라이딩 윈도우 탐색을 하면서 0의 개수를 모두 세고, 최소 개수가 답이 된다. (0의 최수 개수만큼 스왑하면 되므로)
         */

        int answer = Integer.MAX_VALUE;
        int windowSize = 0;
        int zeroCount = 0;

        for (int num : nums) {
            if (num == 1) {
                windowSize++;
            }
        }

        // 1. 윈도우 초기 0값 계산 (추후 비교를 위해)
        for (int i = 0; i < windowSize; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }
        }

        // 2. 슬라이딩 윈도우
        for (int start = 1; start < nums.length; start++) {
            int end = (start + windowSize - 1) % nums.length;

            // 이전 마지막 0 제거
            if (nums[start - 1] == 0) {
                zeroCount--;
            }

            // 이번 마지막 0이면 추가
            if (nums[end] == 0) {
                zeroCount++;
            }

            // 0의 개수 갱신
            answer = Math.min(answer, zeroCount);
        }

        return answer;
    }

    public static void main(String[] args) {
        // 1
        System.out.println(minSwaps(new int[]{0, 1, 0, 1, 1, 0, 0}));
    }
}
