package baekjoon.implementation;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 백준 연구소 문제
 */
public class BaekJoon_14502 {

    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static int N;
    static int M;
    static int[][] maps;
    static int max=-1;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   //세로
        M = sc.nextInt();   //가로

        maps = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maps[i][j] = sc.nextInt();
            }
        }


        buildWall(0);
        System.out.println(max);


    }

    private static void buildWall(int count) {

        if (count == 3) {
            spreadVirus();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i][j] == 0) {
                    maps[i][j] = 1;
                    buildWall(count + 1);
                    maps[i][j] = 0;
                }
            }
        }

    }


    private static void spreadVirus() {

        int[][] tempMaps = new int[N][M];
        for (int i = 0; i < N; i++) {
            tempMaps[i] = maps[i].clone();
        }

        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempMaps[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll[1] + dx[i];
                int ny = poll[0] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    if (tempMaps[ny][nx] == 0 && !visited[ny][nx]) {
                        tempMaps[ny][nx] = 2;
                        visited[ny][nx] = true;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }


        countSafeArea(tempMaps);
    }

    private static void countSafeArea(int[][] tempMaps) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(tempMaps[i][j]==0){
                    count++;
                }
            }
        }

        max = Math.max(max,count);

    }
}

