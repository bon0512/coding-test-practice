package baekjoon.implementation;

import java.util.Scanner;

public class BaekJoon_19237 {

    static int N, M, K;  //배열 수 , 상어 수 , 냄새 유통기한
    static int[][] grid;
    static int[][] smellOwner;
    static int[] dir;
    static int[][] blood;
    static int[][][] priorityDir;
    static int[][] position;
    static boolean[] exist;
    static int time;

    static int[] dx = {999,0, 0, -1, 1};  // index 1부터 시작 위 아래 왼쪽 오른쪽
    static int[] dy = {999,-1, 1, 0, 0};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        grid = new int[N][N]; //현재 판
        exist = new boolean[M+1];
        blood = new int[N][N];
        smellOwner = new int[N][N];
        position = new int[M+1][2]; //상어 현재 위치

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();

                if(grid[i][j]!=0){
                    int shark = grid[i][j];
                    position[shark][0] = i;
                    position[shark][1] = j;
                    blood[i][j] = K;
                    smellOwner[i][j] = shark;
                }
            }
        }

        dir = new int[M+1];

        for (int i = 1; i <=M; i++) {
            dir[i] = sc.nextInt();
        }

        priorityDir = new int[M+1][5][5];

        for (int i = 1; i <=M; i++) {
            for (int j = 1; j <=4; j++) {
                for (int k = 1; k <=4; k++) {
                    priorityDir[i][j][k]  = sc.nextInt();
                }
            }
        }


        for (int i = 1; i <=M ; i++) {
            exist[i] = true;
        }

        int answer = move();

        System.out.println(answer   );

    }

    private static int move(){


        while(time<=1000){
            //상어 1명만 살아있을때 빠져나옴
            if(liveShark()==1){
                return time;
            }
            int[][] nextGrid= new int[N][N];
            int[] nextDir = new int[M+1];
            int[][] nextPosition = new int[M+1][2];

            for (int i = 1; i <=M; i++) {
                if(!exist[i]) continue;

                int curY = position[i][0];
                int curX = position[i][1];

                int nextX =999;
                int nextY =999;
                int nextD =999;
                boolean zeroBlood = false;

                for (int j = 1; j <= 4; j++) {

                    int curDir = priorityDir[i][dir[i]][j];
                    int ny = curY +dy[curDir];
                    int nx = curX +dx[curDir];

                    if(ny<0 || nx <0 || ny>=N || nx>=N) continue;

                    if(blood[ny][nx] == 0){
                        nextY = ny;
                        nextX = nx;
                        zeroBlood = true;
                        nextD = curDir;
                        break;
                    }
                    //상어 이동
                }

                if(!zeroBlood){
                    for (int j = 1; j <=4 ; j++) {
                        int curDir = priorityDir[i][dir[i]][j];
                        int ny = curY +dy[curDir];
                        int nx = curX +dx[curDir];

                        if(ny<0 || nx <0 || ny>=N || nx>=N) continue;

                        if(smellOwner[ny][nx]==i){
                            nextY= ny;
                            nextX = nx;
                            nextD = curDir;
                            break;
                        }

                    }
                }


                if(nextGrid[nextY][nextX]==0){
                    nextGrid[nextY][nextX]=i;
                    nextPosition[i][0] = nextY;
                    nextPosition[i][1] = nextX;
                    nextDir[i]=nextD;
                }else{
                    int temp = nextGrid[nextY][nextX];
                    if(temp>i){
                        exist[temp]  = false;
                        nextGrid[nextY][nextX] = i;
                        nextPosition[i][0] = nextY;
                        nextPosition[i][1] = nextX;
                        nextDir[i]=nextD;
                    }
                    else{
                        exist[i] =false;
                    }
                }

            }

            grid = nextGrid;
            position = nextPosition;
            dir = nextDir;

            declineBlood();

            for (int i = 1; i <=M ; i++) {
                if(!exist[i]) continue;
                int y = position[i][0];
                int x = position[i][1];
                blood[y][x] = K;
                smellOwner[y][x]=i;
            }

            time++;



        }
        return -1;

    }

    private static void declineBlood() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(blood[i][j]>=1){
                    blood[i][j]--;

                    if(blood[i][j]==0){
                        smellOwner[i][j]=0;
                    }
                }

            }
        }

    }

    private static int liveShark() {
        int count =0;
        for (int i = 1; i <=M ; i++) {
            if(exist[i]) count++;
        }
        return count;
    }


}
