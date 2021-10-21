package com.sosow0212.프로그래머스;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 * 프로그래머스 - 완주하지 못한 선수
 * <p>
 * 문제 설명
 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
 * <p>
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 * <p>
 * 제한사항
 * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 * completion의 길이는 participant의 길이보다 1 작습니다.
 * 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
 * 참가자 중에는 동명이인이 있을 수 있습니다.
 * <p>
 * <p>
 * 입출력 예
 * participant	completion	return
 * ["leo", "kiki", "eden"]	["eden", "kiki"]	"leo"
 * ["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
 * ["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav"
 * <p>
 * <p>
 * 입출력 예 설명
 * 예제 #1
 * "leo"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.
 * <p>
 * 예제 #2
 * "vinko"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.
 * <p>
 * 예제 #3
 * "mislav"는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.
 */

import java.util.Arrays;

public class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant); // 오름차순 > 이름의 순서를 같게 하고 비교하면 쉬움
        Arrays.sort(completion);

        // 더 작은 배열인 completion을 for문으로 돌려야 편함
        for (int i = 0; i < completion.length; i++) {
            if (!completion[i].equals(participant[i])) {
                return participant[i];
            }
        }

        answer = participant[participant.length - 1];

        return answer;
    }

    public static void main(String[] args) {

    }

}
