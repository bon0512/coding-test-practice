package baekjoon.greedy;

import java.util.Scanner;

public class BaekJoon_7570 {

    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        arr = new int[N+1];
        dp = new int[N+1];

        for (int i = 1; i < N+1; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i < N+1; i++) {
            dp[arr[i]] = dp[arr[i]-1] +1;
        }

        int max =0;
        for (int i = 1; i < N+1; i++) {

            max = Math.max(max,dp[i]);
        }

        int answer = N - max;

        System.out.println(answer);

    }
}
