package baekjoon.greedy;

import java.util.Scanner;

public class BaekJoon_1080 {

    static int N,M;
    static int[][] grid;
    static int[][] answerGrid;
    static int answer = -2;

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        sc.nextLine();

        grid = new int[N][M];
        answerGrid = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = s.charAt(j)-'0';
            }
        }

        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < M; j++) {
                answerGrid[i][j] =  s.charAt(j)-'0';
            }
        }
        if(N<3 || M <3){
            if(isSame()){
                answer =0;
            }else{
                answer = -1;
            }
            System.out.println(answer);
            return;
        }

        answer = greed();
        if(!isSame()) answer = -1;
        System.out.println(answer);
    }

    private static int greed(){
        int count =0;
        for (int i = 0; i <= N-3; i++) {
            for (int j = 0; j <=M-3; j++) {
                if(grid[i][j]!=answerGrid[i][j]){
                    reverse(i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void reverse(int y, int x){
        for (int i = y; i <y+3 ; i++) {
            for (int j = x; j <x+3 ; j++) {
                if(grid[i][j]==1){
                    grid[i][j] = 0;
                }else{
                    grid[i][j]=1;
                }
            }
        }

    }

    private static boolean isSame(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(grid[i][j]!=answerGrid[i][j]) return false;
            }
        }

        return true;
    }
}
