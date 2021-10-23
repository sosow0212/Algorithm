import java.util.*;

class 모의고사 {
    public int[] solution(int[] answers) {
        int[] point = {0,0,0}; // 점수표
        int[] pointCopy = {}; // 점수표 정렬
        int max = 0; // 점수 최대값
        List<Integer> list = new ArrayList(); // 정답자 넣기

        int[][] spzPatterns = {
                {1, 2, 3, 4, 5},        // 수포자들의  패턴
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        // [1] 채점하기
        for (int i = 0; i < answers.length; i++) {
            if (spzPatterns[0][i%5] == answers[i]) {
                point[0]++;
            }

            if (spzPatterns[1][i%8] == answers[i]) {
                point[1]++;
            }

            if (spzPatterns[2][i%10] == answers[i]) {
                point[2]++;
            }
        }

        // [2] 점수표 정렬해서 가장 큰 값 찾기
        pointCopy = point.clone();
        Arrays.sort(pointCopy);
        max = pointCopy[2];

        for (int i = 0; i < point.length; i++) {
            if (point[i] == max) {
                list.add(i+1);
            }
        }

        // [3] 가장 큰 값을 가진 학생 번호 구하기
        int[] answer = new int[list.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}