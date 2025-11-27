package baekjoon.dp;

import java.util.Scanner;

public class BaekJoon_11726 {

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int[] mem = new int[N + 1];
        mem[1] = 1;
        if (N >= 2) mem[2] = 2;

        for (int i = 3; i <= N; i++) {
            mem[i] = (mem[i - 1] + mem[i - 2]) % 10007;
        }

        System.out.println(mem[N]);
    }

}
