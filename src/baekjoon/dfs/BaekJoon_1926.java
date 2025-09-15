package baekjoon.dfs;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class BaekJoon_1926 {

    static int[] dx = new int[] {1,-1,0,0}; //동사무소
    static int[] dy = new int[] {0,0,-1,1}; //동사무소
    static int[][] paper;
    static int N; //세로
    static int M; //가로
    static boolean[][] visited;
    static int drawCount = 0;
    static int drawMaxCount = 0;
    static int drawTempCount = 0;
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        paper = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                paper[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(paper[i][j] == 1 && !visited[i][j]){
                    drawCount++;
                    drawTempCount=0;
                    dfs(j,i);

                    drawMaxCount= Math.max(drawTempCount,drawMaxCount);
                }
            }
        }

        System.out.println(drawCount);
        System.out.println(drawMaxCount);


    }
    public static void dfs(int x, int y){

        drawTempCount++;
        visited[y][x] =true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];


            if(nx>=0 && ny>=0 && nx<M && ny <N){

                if(paper[ny][nx]==1 && !visited[ny][nx]){
                    dfs(nx,ny);
                }

            }
        }

    }
}
