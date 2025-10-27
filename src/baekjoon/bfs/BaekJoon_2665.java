package baekjoon.bfs;

import java.util.*;

public class BaekJoon_2665 {

    static int N;
    static char[][] grid;
    static int[][] dist;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        sc.nextLine();
        grid = new char[N][N];
        dist = new int[N][N];

        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = s.charAt(j);
            }
        }

        bfs();
        System.out.println(dist[N-1][N-1]);
    }

    private static void bfs() {
        Deque<int[]> deque = new ArrayDeque<>();


        dist[0][0] = 0;
        deque.add(new int[]{0, 0});

        while (!deque.isEmpty()) {
            int[] poll = deque.poll();
            int curY = poll[0];
            int curX = poll[1];

            for (int i = 0; i < 4; i++) {
                int ny = curY + dy[i];
                int nx = curX + dx[i];


                if (ny >= 0 && nx >= 0 && ny < N && nx < N) {

                    int cost = (grid[ny][nx] == '0' ? 1 : 0);

                    if(dist[ny][nx]> dist[curY][curX]+cost){
                        dist[ny][nx] = dist[curY][curX]+cost;
                        if(grid[ny][nx] =='0'){
                            deque.addLast(new int[]{ny,nx});
                        }else{
                            deque.addFirst(new int[]{ny,nx});
                        }
                    }


                }
            }

        }

    }
}
