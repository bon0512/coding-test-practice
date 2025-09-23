package baekjoon.bfs;

import java.util.*;

public class BeakJoon_1937 {

    static int N;
    static int[][] grid;
    static List<int[]>[] list;
    static boolean[][] visited;
    static int[][] mem;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int count =0;
    static int maxCount = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        grid = new int[N][N];
        mem = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count = dfs(j,i);

                maxCount = Math.max(count,maxCount);
            }
        }

        System.out.println(maxCount);


    }

    private static int dfs(int x, int y){

        if(mem[y][x]!=0) return mem[y][x];

        mem[y][x] =1;


        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && ny<N && nx<N){
                if(grid[ny][nx] > grid[y][x]){
                   mem[y][x] = Math.max(mem[y][x],dfs(nx,ny)+1);
                }
            }
        }


        return mem[y][x];

    }


}
