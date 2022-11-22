package com.programmers.sol;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/42862
public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        int answer = n - lost.length; //전체 인원 - 없는 학생 = 체육복 있는 학생

        Arrays.sort(lost);
        Arrays.sort(reserve);


        // !!! 여벌 체육복 있는 학생이 도난 당한 경우 (이 경우 여벌학생,도난학생 배열에서 삭제 시켜줘야 함. 다른 학생 못 빌려주도록)
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    // 여벌 있는 학생이 도난당했으면
                    lost[i] = -1;
                    reserve[j] = -1;
                    // 그 학생은 배열에서 빠져

                    answer++; // 수업 참여할 수 있으니까 ++
                }
            }
        }

        System.out.println(Arrays.toString(lost));
        System.out.println(Arrays.toString(reserve));

        // 도난 당한 학생에게 빌려주는 경우
        for (int i = 0; i < lost.length; i++) { //도난 당한 학생 수 만큼 반복
            for (int j = 0; j < reserve.length; j++) { //여분 있는 학생 수 만큼 반복
                if (reserve[j] + 1 == lost[i] || reserve[j] - 1 == lost[i]) {
                    // 만약 여분 학생 출석번호 +-1 == 잃어버린 학생 출석번호면
                    answer++; //옷을 빌려줘 (수업 들을 수 있는 학생 ++)
                    System.out.printf("%d아 나 %d번인데 내가 빌려줌\n", lost[i], reserve[j]);

                    reserve[i] = 0;
                    lost[i] = 0;
                }
            }
        }
        System.out.println(answer);

        return answer; //수업들을 수 있는 학생의 최댓값 return
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 5; //전체 학생수 (2 <= n <= 30)
        int[] lost = {5,4,2}; //도난당한 학생들의 번호 (1 <= 도난 당한 학생 수 <= n)
        int[] reserve = {2,4};//여벌의 체육복을 가진 학생들의 번호 (1 <= 여벌 있는 학생 수 <= n)
        // !!! 여벌 체육복 있는 학생이 도난 당할 수 있음. 그럼 자기 체육복 하나만 있는 것임.

        solution.solution(n, lost, reserve);
    }
}
