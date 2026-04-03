package baekjoon.bfs;

import java.util.*;

/**
 ==========================
 * 이름 : 두 동전
 * 링크  : https://www.acmicpc.net/problem/16197
 * 난이도 : G4
 * ========================== */

public class BaekJoon_16197_re {

    static int[][] grid;
    static int[] dy = {0,-1,0,1};
    static int[] dx = {1,0,-1,0};
    static int N,M;
    static int ay,ax,by,bx;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        grid = new int[N][M];
        int coinCount = 0;

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < M; j++) {
                grid[i][j] = s.charAt(j);
                if(s.charAt(j)=='o'){
                    if (coinCount == 0) {
                        ay = i;
                        ax = j;
                    } else {
                        by = i;
                        bx = j;
                    }
                    coinCount++;
                }
            }
        }

        bfs();

    }

    private static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{ay,ax,by,bx,0});

        //동전 두개 똑같은 위치 재방문시 건너뛰게 체크
        boolean[][][][] visited = new boolean[N][M][N][M];
        visited[ay][ax][by][bx] = true;


        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int cay = poll[0];
            int cax = poll[1];
            int cby = poll[2];
            int cbx = poll[3];
            int time =poll[4];

            if(time>=10){
                System.out.println(-1);
                return ;
            }

            for (int i = 0; i < 4; i++) {
                int nay = cay+dy[i];
                int nax = cax+dx[i];
                int nby = cby+dy[i];
                int nbx = cbx+dx[i];

                //밖으로 튕겨져 나갈때
                if((nay<0 || nax<0 || nay>=N || nax>=M) && (nby>=0 && nbx>=0 && nby<N && nbx<M)){
                    System.out.println(time+1);
                    return;
                }
                else if((nby<0 || nbx<0 || nby>=N || nbx>=M) && (nay>=0 && nax>=0 && nay<N && nax<M)){
                    System.out.println(time+1);
                    return;
                }

                //둘다 보드 밖인경우 넘어감
                if((nay<0 || nax<0 || nay>=N || nax>=M) && (nby<0 || nbx<0 || nby>=N || nbx>=M)){
                    continue;
                }

                // 벽일경우 안움직이고 제자리
                if(grid[nay][nax]=='#'){
                    nay = cay;
                    nax = cax;
                }

                if(grid[nby][nbx]=='#'){
                    nby = cby;
                    nbx = cbx;
                }

                //조건 맞을경우 큐에 넣고 진행
                if(!visited[nay][nax][nby][nbx]){
                    visited[nay][nax][nby][nbx] = true;
                    queue.add(new int[]{nay,nax,nby,nbx,time+1});
                }
            }
        }

        System.out.println(-1);
    }
}
