package baekjoon.dp;

import java.util.Scanner;

public class BaekJoon_2579 {

    static int[] stair;
    static int N;
    static int[] mem;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        stair = new int[N + 1];
        mem = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            stair[i] = sc.nextInt();
        }

        int answer = checkMax(N);
        System.out.println(answer);

    }

    private static int checkMax(int i) {

        if (i <= 0) {
            return 0;
        }
        if(mem[i]!=0) return mem[i];

        if (i == 1) return mem[1] = stair[1];
        if (i == 2) return mem[2] = stair[1] + stair[2];

        return mem[i] = Math.max(checkMax(i - 2), checkMax(i - 3) + stair[i-1]) + stair[i];


    }


}
