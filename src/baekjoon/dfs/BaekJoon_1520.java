package baekjoon.dfs;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon_1520 {

    static int N, M;
    static int count = 0;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int[][] grid;
    static int[][] mem;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        grid = new int[N][M];
        mem = new int[N][M];

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                grid[y][x] = sc.nextInt();
                mem[y][x] = -1;
            }
        }

        int answer = dfs(0, 0);


//        for (int[] ints : mem) {
//            System.out.println(Arrays.toString(ints));
//        }

        System.out.println(answer);

    }

    private static int dfs(int x, int y) {
        if (x == M - 1 && y == N - 1) {

            return 1;
        }

        if(mem[y][x]!=-1){
            return mem[y][x];
        }

        mem[y][x] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && ny>=0 && ny<N && nx<M){
                if(grid[ny][nx] < grid[y][x]){
                   mem[y][x] += dfs(nx,ny);
                }

            }
        }

        return mem[y][x];
    }
}
