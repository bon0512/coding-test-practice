package baekjoon.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon_7562 {

    static int N;
    static int T;
    static int[][] grid;
    static int startX, startY;
    static int endX, endY;

    static int count =0;
    static int[] dx = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();


        for (int i = 0; i < T; i++) {
            N = sc.nextInt();
            startX = sc.nextInt();
            startY = sc.nextInt();
            endX = sc.nextInt();
            endY = sc.nextInt();
            bfs(startX, startY);
            System.out.println(grid[endY][endX]);
        }
    }

    private static void bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        grid = new int[N][N];
        queue.add(new int[]{y, x});

        grid[y][x] = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curX = poll[1];
            int curY = poll[0];

            if(curY == endY && curX == endX){
                break;
            }


            for (int i = 0; i < 8; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<N && grid[ny][nx]==0){
                    grid[ny][nx] = grid[curY][curX]+1;
                    queue.add(new int[]{ny,nx});
                }


            }

        }


    }
}
