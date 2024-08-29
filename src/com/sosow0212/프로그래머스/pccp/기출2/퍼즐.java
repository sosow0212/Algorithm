package com.sosow0212.프로그래머스.pccp.기출2;

public class 퍼즐 {

    public int solution(int[] diffs, int[] times, long limit) {
        long answer = Long.MAX_VALUE;

        long min = Long.MAX_VALUE;
        long max = 0;
        for (int i = 0; i < diffs.length; i++) {
            min = Math.min(min, diffs[i]);
            max = Math.max(max, diffs[i]);
        }

        // 이분탐색으로 숙련도의 최솟값을 구한다 (left)
        long left = min;
        long right = max;

        while (left <= right) {
            long mid = (left + right) / 2; // 레벨
            long sum = 0;
            int beforeClearTime = 0;

            for (int i = 0; i < diffs.length; i++) {
                int diff = diffs[i];
                int time = times[i];
                long clearTime = 0;

                if (diff <= mid) {
                    clearTime += time;
                } else {
                    long tryCount = diff - mid;
                    clearTime = tryCount * (time + beforeClearTime) + time;
                }

                beforeClearTime = time;
                sum += clearTime;
            }

            if (sum <= limit) {
                // 충분히 해결할 수 있으면 더 줄이기 시도
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                // 해결하지 못하면 범위 재설정
                left = mid + 1;
            }
        }

        return (int) answer;
    }

    public static void main(String[] args) {
        퍼즐 sol = new 퍼즐();

        // 3
//        System.out.println(sol.solution(new int[]{1, 5, 3}, new int[]{2, 4, 7}, 30));

        // 294
//        System.out.println(sol.solution(new int[]{1, 328, 467, 209, 52}, new int[]{2, 7, 1, 4, 3}, 1723));

        // 39354
        System.out.println(sol.solution(new int[]{1, 99999, 100000, 99995}, new int[]{9999, 9001, 9999, 9001}, 3456789012L));
    }
}
