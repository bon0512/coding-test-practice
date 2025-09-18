package baekjoon.bruteforce;

import java.util.Scanner;

public class BaekJoon_15651 {

    static int N,M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();


        dfs(0,new int[M]);
        System.out.print(sb);

    }

    private static void dfs( int depth, int[] temp) {
        if(depth==M){
            for(int i : temp){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {

            temp[depth] = i;
            dfs(depth+1,temp);


        }
    }
}
