package baekjoon.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon_16197 {

    static int N,M;
    static char[][]  grid;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};


    static int answer;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        sc.nextLine();
        grid = new char[N][M];
        ArrayList<Integer> coin = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String s= sc.nextLine();
            for (int j = 0; j < M; j++) {
                if(s.charAt(j)=='o'){
                    coin.add(i);
                    coin.add(j);
                }
                grid[i][j] = s.charAt(j);
            }
        }
        //System.out.println(coin);

        bfs(coin.get(0),coin.get(1),coin.get(2),coin.get(3));
        System.out.println(answer);

    }

    private static void bfs(int y1, int x1, int y2, int x2) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y1,x1,y2,x2,0});
        boolean[][][][] visited = new boolean[N][M][N][M];
        visited[y1][x1][y2][x2] = true;

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int curY = poll[0];
            int curX = poll[1];
            int curY2 = poll[2];
            int curX2 = poll[3];
            int curK = poll[4];

            if(curK >=10){
                //System.out.println("10 이상에서 찍힘");
                answer = -1;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = curX+dx[i];
                int ny = curY+dy[i];

                int nx2 = curX2+dx[i];
                int ny2 = curY2+dy[i];

                if((nx<0 || ny<0 || nx>=M || ny>=N) && (nx2>=0 &&ny2>=0 &&nx2<M && ny2<N)){
                    answer = curK+1;
                    return;
                } else if((nx2<0 || ny2<0 || nx2>=M || ny2>=N) && (nx>=0 && ny>=0 &&nx<M && ny<N)){

                    answer = curK+1;
                    return ;
                }

                if((nx>=0 && ny>=0 && nx<M && ny<N) && (nx2>=0 && ny2>=0 && nx2<M && ny2<N)){
                    if(grid[ny][nx] =='#' && grid[ny2][nx2]!='#'){
                        if(!visited[curY][curX][ny2][nx2]) {
                            visited[curY][curX][ny2][nx2] = true;
                            queue.add(new int[]{curY, curX, ny2, nx2, curK + 1});
                        }
                    }else if(grid[ny][nx] !='#' && grid[ny2][nx2]=='#'){
                        if(!visited[ny][nx][curY2][curX2]) {
                            visited[ny][nx][curY2][curX2] = true;
                            queue.add(new int[]{ny, nx, curY2, curX2, curK + 1});
                        }
                    }else if(grid[ny][nx] !='#' && grid[ny2][nx2]!='#'){
                        if(!visited[ny][nx][ny2][nx2]) {
                            visited[ny][nx][ny2][nx2] = true;
                            queue.add(new int[]{ny, nx, ny2, nx2, curK + 1});
                        }
                    }
                }

            }
        }

        //System.out.println("여기서 찍힘");
        answer = -1;

    }
}
