package baekjoon.bruteforce;

import java.util.Scanner;

/**
 * 10971 외판원 순회2
 * 순열이용해서 푸는건데
 * 문제에서는 시작점을 고정으로하길 유도했을듯.
 */
public class BaekJoon_10971 {

    static int N;
    static int[][] grid;
    static boolean[] visited;
    static int startIndex;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        N = sc.nextInt();
        grid = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }


        per(0,new int[N]);
        System.out.println(min);


    }

    private static void per(int depth, int[] temp) {
        if(depth==N){
            int sum = 0;
            int start =0;
            int end = 0;
            for (int i = 0; i < temp.length-1; i++) {
                start = temp[i];
                end = temp[i+1];
                if(grid[start][end] ==0 ) return ;
                sum += grid[start][end];

            }
            start = temp[temp.length-1];
            end = temp[0];

            if(grid[start][end]==0) return ;
            sum += grid[start][end];

            min = Math.min(min,sum);

            return ;
        }



        for (int i = 0; i < N; i++) {

            if(!visited[i]){
                visited[i] =true;
                temp[depth] = i;
                per(depth+1,temp);
                visited[i] =false;
            }
        }


    }
}
