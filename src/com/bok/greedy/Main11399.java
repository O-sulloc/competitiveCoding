package com.bok.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Main11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //사람 수 5명
        int[] arr = new int[n]; //각각 인출하는데 걸리는 시간 배열로 받음 [3, 1, 4, 3, 2]
        int[] time = new int[n]; //[1분, 3분, 6분, 9분, 13분] (이 배열에 있는 값 다 더해서 총 소요 시간 알아냄)
        int answer = 0; //위에 배열에 있는 값 다 더해서 총 몇 분 소요 되는지 리턴. 32분

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); //각각 인출하는데 걸리는 시간 배열로 받음
        }

        // 가장 적게 걸리는 사람을 앞에 세워 (정렬)
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            time[i] += arr[i]; //[1분, 3분, 6분, 9분, 13분]이거 하려고

            if (i + 1 < n) {
                time[i + 1] = time[i]; // 첫 번째 결과(1분) 다음 요소에 보내 줘야됨. [1분, 1분, 0분, 0분, 0분]
            }
        }

        for (int i = 0; i < time.length; i++) {
            answer += time[i];
        }

        System.out.println(answer);

    }
}
