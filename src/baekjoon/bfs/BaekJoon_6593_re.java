package baekjoon.bfs;

import java.util.*;

/**
 ==========================
 * 링크 : https://www.acmicpc.net/problem/6593
 * 이름 : 상범빌딩
 * 난이도 : G5
 * ========================== */


public class BaekJoon_6593_re {

    static int[][][] map;
    static int[] dy = {0, -1, 0, 1, 0, 0};
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int L, R, C;
    static int startX, startY, startZ, endX, endY, endZ;
    static boolean[][][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            L = sc.nextInt();
            R = sc.nextInt();
            C = sc.nextInt();

            //종료 조건
            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            map = new int[L][R][C];
            visited = new boolean[L][R][C];

            // 층 입력
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String s = sc.next();

                    for (int k = 0; k < C; k++) {

                        map[i][j][k] = s.charAt(k);
                        if (s.charAt(k) == 'S') {
                            startZ = i;
                            startY = j;
                            startX = k;
                        } else if (s.charAt(k) == 'E') {
                            endZ = i;
                            endY = j;
                            endX = k;
                        }
                    }
                }
            }

            bfs();

        }
    }

    private static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{startZ, startY, startX, 0});
        visited[startZ][startY][startX] =true;

        while (!queue.isEmpty()) {

            int[] poll = queue.poll();
            int cZ = poll[0];
            int cY = poll[1];
            int cX = poll[2];
            int time = poll[3];

            if (cZ == endZ && cY == endY && cX == endX) {
                System.out.println("Escaped in " + time + " minute(s).");
                return;
            }

            for (int i = 0; i < 6; i++) {
                int nz = cZ + dz[i];
                int ny = cY + dy[i];
                int nx = cX + dx[i];

                if (nz >= 0 && nz < L && ny >= 0 && ny < R && nx >= 0 && nx < C) {
                    if (!visited[nz][ny][nx] && (map[nz][ny][nx] == '.' || map[nz][ny][nx]=='E')) {
                        visited[nz][ny][nx] = true;
                        queue.add(new int[]{nz,ny,nx,time+1});
                    }
                }

            }
        }

        System.out.println("Trapped!");
    }
}
