package baekjoon.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon_15656 {

    static int N,M;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] =sc.nextInt();
        }

        Arrays.sort(arr);

        dfs(0,new int[M]);
        System.out.print(sb);

    }

    private static void dfs( int depth, int[] temp) {
        if(depth==M){
            for (int i : temp) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {

            temp[depth] = arr[i];
            dfs(depth+1,temp);

        }
    }
}
