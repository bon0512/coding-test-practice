package baekjoon.dp;

import java.util.Scanner;

public class BaekJoon_1149 {

    static int N;
    static int[][] houseColor;
    static int[][] mem;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        houseColor = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            houseColor[i][0] = sc.nextInt();
            houseColor[i][1] = sc.nextInt();
            houseColor[i][2] = sc.nextInt();
        }


        for (int i = 2; i <=N ; i++) {
            mem[i][0] = Math.min(mem[i-1][1],mem[i-1][2])+houseColor[i][0];
            mem[i][1] = Math.min(mem[i-1][0],mem[i-1][2])+houseColor[i][1];
            mem[i][2] = Math.min(mem[i-1][1],mem[i-1][0])+houseColor[i][2];

        }
        System.out.println(Math.min(mem[N][0],Math.min(mem[N][1],mem[N][2])));

    }
}
