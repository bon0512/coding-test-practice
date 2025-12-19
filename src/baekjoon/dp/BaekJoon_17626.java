package baekjoon.dp;

import java.util.Scanner;

public class BaekJoon_17626 {

    static int N;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        dp = new int[N+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = i;
        }

        for (int i = 1; i*i < dp.length; i++) {
            dp[i*i] = 1;
        }

        for (int i = 1; i <dp.length ; i++) {
            if(dp[i]==1) continue;
            for (int j = 1; j*j <i ; j++) {
                dp[i] = Math.min(dp[i-j*j]+1, dp[i]);
            }
        }



        System.out.println(dp[N]);
    }
}
