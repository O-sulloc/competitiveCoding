package com.bok.bruteForce;

import java.util.Scanner;

public class Boj2798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //카드의 개수
        int M = sc.nextInt(); //딜러가 외치는 수
        int[] card = new int[N];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            card[i] = sc.nextInt();
        }

        // m을 넘지 않으면서 m에 최대한 가까운 카드의 합을 구하라 (3장의 합)
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    //System.out.printf("%d+%d+%d = %d \n", card[i], card[j], card[k], card[i] + card[j] + card[k]);
                    if (card[i] + card[j] + card[k] > answer && card[i] + card[j] + card[k] <= M) {
                        answer = card[i] + card[j] + card[k];
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
