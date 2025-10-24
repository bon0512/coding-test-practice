package baekjoon.bfs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon_6593 {

    static int L, R, C;
    static char[][][] grid;
    static boolean[][][] visited;
    static int time;
    static boolean answer ;

    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while (true) {
            L = sc.nextInt();
            R = sc.nextInt();
            C = sc.nextInt();

            if (L == 0 && R == 0 && C == 0) break;

            grid = new char[L][R][C];
            visited = new boolean[L][R][C];
            sc.nextLine();

            int floor = 0;
            int x = 0;
            int y = 0;

            int endF = 0;
            int endX = 0;
            int endY = 0;

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String s = sc.nextLine();
                    for (int k = 0; k < C; k++) {

                        grid[i][j][k] = s.charAt(k);

                        if (grid[i][j][k] == 'S') {
                            floor = i;
                            y = j;
                            x = k;
                        } else if (grid[i][j][k] == 'E') {
                            endF = i;
                            endX = k;
                            endY = j;
                        }
                    }
                }
                sc.nextLine();
            }

            answer = bfs(floor, y, x ,endF,endY,endX);

            if(answer){
                System.out.println("Escaped in " + time+" minute(s).");
            }else{
                System.out.println("Trapped!");
            }

            answer =false;
            time = 0;

        }
    }

    private static boolean bfs(int floor, int y, int x, int endF, int endY , int endX) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{floor, y, x, 0});

        visited[floor][y][x] = true;


        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curF = poll[0];
            int curY = poll[1];
            int curX = poll[2];
            int curT = poll[3];

            if(curF==endF&& curY ==endY && curX ==endX){
                time = curT;
                return true;
            }

            for (int i = 0; i < 6; i++) {
                int nF = curF + dz[i];
                int nY = curY + dy[i];
                int nX = curX + dx[i];

                if(nF>=0&& nY>=0 && nX>=0 && nF<L && nX<C && nY < R){

                    if(!visited[nF][nY][nX] && grid[nF][nY][nX] !='#'){
                        visited[nF][nY][nX] = true;
                        queue.add(new int[]{nF,nY,nX,curT+1});
                    }
                }
            }


        }

        return false;

    }
}
