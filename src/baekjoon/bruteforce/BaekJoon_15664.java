package baekjoon.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

/**
 * N과 M 11
 *
 */

public class BaekJoon_15664 {



    static int N, M;
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
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        dfs(0,0,new int[M]);
        System.out.print(sb);


    }

    private static void dfs(int start,int depth, int[] temp) {

        if(depth==M){
            for(int i : temp){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return ;
        }



        int prev = -1;

        for (int i = start; i < N; i++) {
            if(!visited[i] && prev!=arr[i]){
                visited[i] =true;
                temp[depth] = arr[i];
                prev = arr[i];
                dfs(i,depth+1,temp);
                visited[i] = false;
            }
        }

    }


}
