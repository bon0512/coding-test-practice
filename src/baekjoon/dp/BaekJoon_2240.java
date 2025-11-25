package baekjoon.dp;

import java.util.Scanner;

public class BaekJoon_2240 {

    static int T, W;
    static int[][] mem;
    static int[] tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        W = sc.nextInt();

        mem = new int[T + 1][W + 1];
        tree = new int[T + 1];

        for (int i = 1; i <= T; i++) {
            tree[i] = sc.nextInt();
        }


        for (int t = 1; t <= T; t++) {

            for (int w = 0; w <= W; w++) {
                int pos = (w % 2 == 0) ? 1 : 2;


                //이동하지 않고 먹기
                mem[t][w] = mem[t - 1][w] + (tree[t] == pos ? 1 : 0);


                //이동해서 먹기
                if (w > 0) {
                    mem[t][w] = Math.max(mem[t][w], mem[t - 1][w - 1] + (tree[t] == pos ? 1 : 0));
                }
            }
        }

        int answer = 0;
        for (int w = 0; w <=W; w++) {
            answer = Math.max(answer,mem[T][w]);
        }

        System.out.println(answer);


    }
}
