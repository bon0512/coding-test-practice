package baekjoon.bfs;

import java.util.*;

public class BaekJoon_16948 {

    static int[] dr = {-2, -2, 0, 0, 2, 2};
    static int[] dc = {-1, 1, -2, 2, -1, 1};

    static int N, r1, c1, r2, c2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        r1 = sc.nextInt();
        c1 = sc.nextInt();
        r2 = sc.nextInt();
        c2 = sc.nextInt();

        System.out.println(bfs());
    }

    private static int bfs() {
        if (r1 == r2 && c1 == c2) return 0;

        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(dist[i], -1);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r1, c1});
        dist[r1][c1] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int k = 0; k < 6; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (dist[nr][nc] != -1) continue;

                dist[nr][nc] = dist[r][c] + 1;

                if (nr == r2 && nc == c2) return dist[nr][nc];

                q.offer(new int[]{nr, nc});
            }
        }

        return -1;
    }
}
