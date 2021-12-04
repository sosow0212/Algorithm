package com.sosow0212.백준;

import java.util.*;
import java.math.*;

public class q10825 {

    static String score[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        score = new String[n][4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                score[i][j] = sc.next();
            }
        }

        Arrays.sort(score, new Comparator<String[]>() {

            @Override
            public int compare(String[] a, String[] b) {

                if (Integer.valueOf(a[1]) > Integer.valueOf(b[1])) { // 국어가 감소하는 순으로
                    // 여기선 기준의 다음 수가 더 크면 큰 수를 왼쪽으로 옮긴다.
                    return -1;
                } else if (Integer.valueOf(a[1]) == Integer.valueOf(b[1])) { // 국어가 같다면
                    if (Integer.valueOf(a[2]) == Integer.valueOf(b[2])) { // 영어가 같다면
                        if (Integer.valueOf(a[3]) == Integer.valueOf(b[3])) { // 수학이 같다면
                            return a[0].compareTo(b[0]); // 이름순으로 정렬
                            // 다음에 오는 이름이 사전순으로 빠를 경우 먼저 나온다.
                        }
                        // 국어와 영어가 같다면 수학은 내림차순 정렬을 해야하므로
                        // 기준 수가 다음 수보다 작을경우 -1을 반환해 다음 수가 먼저 온다.
                        return Integer.compare(Integer.valueOf(b[3]), Integer.valueOf(a[3]));
                    }
                    // 국어가 같다면 영어를 오름차순 정렬
                    // 다음 수가 더 작다면 다음 수가 먼저와야 한다.
                    return Integer.compare(Integer.valueOf(a[2]), Integer.valueOf(b[2]));
                } else return 1; // 모든 경우에 걸리지 않으면 기존상태 유지

            }

        });

        for (int i = 0; i < n; i++) {

            System.out.println(score[i][0]);
        }


    }

}