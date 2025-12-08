package baekjoon.dp;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon_1699 {

    static int N;
    static int[] dp;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        dp = new int[N + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;

        if(N==1){
            System.out.println(dp[N]);
            return ;
        }


        for (int i = 2; i * i <= N; i++) {
            dp[i * i] = 1;
        }

        for (int i = 2; i <= N; i++) {

            for (int k = 1; k *k<=i; k++) {
                dp[i] = Math.min(dp[i], dp[i-k*k]+dp[k*k]);
            }
        }

        System.out.println(dp[N]);
    }
}
