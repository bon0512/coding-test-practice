package baekjoon.dfs;

import java.util.*;

public class BeakJoon_1937 {


    static int N;
    static int[][] mem;
    static int[][] grid;

    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};

    static int max =-1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        mem = new int[N][N];
        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j]  = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int count = dfs(j, i);
                max = Math.max(count,max);
            }
        }


        System.out.println(max);
        for (int[] ints : mem) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static int dfs(int x, int y) {
        if(mem[y][x] != 0) return mem[y][x];

        mem[y][x] =1;
        System.out.println("x : "+ x+ "y : ");
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<N && ny<N){
                if(grid[ny][nx]>grid[y][x]){
                    mem[y][x] = Math.max(mem[y][x],dfs(nx,ny)+1);
                }
            }
        }

        return mem[y][x];

    }


}
