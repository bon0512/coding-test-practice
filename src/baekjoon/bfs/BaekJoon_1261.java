package baekjoon.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon_1261 {

    static int N, M;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int[][] grid;
    static int[][] countK;
    static boolean[][] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        grid = new int[N][M];
        visited = new boolean[N][M];
        countK = new int[N][M];

        sc.nextLine();

        for (int y = 0; y < N; y++) {
            String s = sc.nextLine();
            for (int x = 0; x < M; x++) {
                grid[y][x] = s.charAt(x) - '0';
            }
        }


        bfs();

        for (int[] ints : countK) {
            System.out.println(Arrays.toString(ints));
        }

        System.out.println(countK[N-1][M-1]);
    }

    private static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();

        //x좌표 y좌표, 현재 부신 벽 수;
        queue.add(new int[]{0, 0, 0});
        visited[0][0] = true;
        countK[0][0] = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curX = poll[0];
            int curY = poll[1];
            int curK = poll[2];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx>=0 && ny>=0 && nx<M && ny<N){

                    if(!visited[ny][nx]){
                        if(grid[ny][nx] == 0){
                            queue.add(new int[]{nx,ny,curK});
                            countK[ny][nx]= curK;
                            visited[ny][nx] = true;
                        }
                        else{
                            queue.add(new int[]{nx,ny,curK+1});
                            countK[ny][nx] = curK+1;
                            visited[ny][nx] = true;
                        }
                    }else if(visited[ny][nx]){
                        if(grid[ny][nx] ==1 &&countK[ny][nx]>curK+1){
                            countK[ny][nx] = curK+1;
                            queue.add(new int[]{nx,ny,curK+1});
                        }else if(grid[ny][nx] ==0 &&countK[ny][nx]>curK){
                            countK[ny][nx] = curK;
                            queue.add(new int[]{nx,ny,curK});
                        }
                    }
                }
            }



        }


    }
}
