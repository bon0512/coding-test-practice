package baekjoon.dp;

import java.util.Scanner;

public class BaekJoon_14501 {

    static int[] time, price, dp;
    static int N;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        time = new int[N + 1];
        price = new int[N + 1];
        dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            time[i] = sc.nextInt();
            price[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            int Ti = time[i];
            int Pi = price[i];


            dp[i+1] =Math.max(dp[i+1],dp[i]);

            if(i+Ti<=N+1){
                dp[i+Ti] = Math.max(dp[i+Ti],dp[i]+Pi);
            }

        }

        int max = Integer.MIN_VALUE;
        for (int i : dp) {
            max = Math.max(max,i);
        }

        System.out.println(max);

    }
}
