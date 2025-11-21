package baekjoon.bfs;

import java.util.*;

public class BaekJoon_2583 {

    static int M, N, K;
    static boolean[][] grid;
    static boolean[][] visited;
    static List<Integer> answer;
    static int count;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();

        grid = new boolean[M][N];
        visited = new boolean[M][N];
        answer = new ArrayList<>();

        while (K-- > 0) {
            int x1, y1, x2, y2;
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            for (int i = y1; i < y2; i++) {
                for (int j = x1; j < x2; j++) {
                    grid[i][j] = true;
                }
            }
        }
        //for (boolean[] booleans : grid) {
        //    System.out.println(Arrays.toString(booleans));
        //}

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!grid[i][j] && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(count);
        Collections.sort(answer);
        for(Integer i : answer){
            System.out.print(i+" ");
        }
    }

    private static void bfs(int y, int x) {
        count++;
        Queue<int[]> queue = new LinkedList<>();

        int paperCount = 1;
        queue.add(new int[]{x, y});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curX = poll[0];
            int curY = poll[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {

                    if(!grid[ny][nx] && !visited[ny][nx]){
                        visited[ny][nx] = true;
                        paperCount++;
                        queue.add(new int[]{nx,ny});
                    }

                }
            }


        }

        answer.add(paperCount);
    }//bfs
}
