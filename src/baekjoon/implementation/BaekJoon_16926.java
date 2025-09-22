package baekjoon.implementation;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon_16926 {

    static int N,M,R;
    static int[][] grid;

    public static void main(String[] args) {


        Scanner sc= new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();

        grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int T = Math.min(N,M)/2;

        for (int i = 0; i < T; i++) {
            rotate(i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }


    }

    private static void rotate(int T) {

        Queue<Integer> queue = new LinkedList<>();

        for (int j = T; j <M-T ; j++) {
            int i = T;
            queue.add(grid[i][j]);

        }

        /*System.out.println("맨 윗줄 가로에서 세로 이동");
        System.out.println(queue);*/

        for (int i = T+1; i <N-T ; i++) {
            int j = M-T-1;

            queue.add(grid[i][j]);
        }

        /*System.out.println("오른쪽 줄 위에서 아래로 이동");
        System.out.println(queue);*/

        for (int j = M-T-2; j >=T ; j--) {
            int i = N-T-1;

            queue.add(grid[i][j]);
        }



        for (int i = N-T-2; i >T ; i--) {
            int j =T;


            queue.add(grid[i][j]);
        }

        for (int i = 0; i < R; i++) {
            Integer temp = queue.poll();
            queue.add(temp);
        }
        for (int j = T; j <M-T ; j++) {
            int i = T;
            grid[i][j] = queue.poll();

        }



        for (int i = T+1; i <N-T ; i++) {
            int j = M-T-1;

            grid[i][j] = queue.poll();
        }



        for (int j = M-T-2; j >=T ; j--) {
            int i = N-T-1;

            grid[i][j] = queue.poll();
        }



        for (int i = N-T-2; i >T ; i--) {
            int j =T;


            grid[i][j] = queue.poll();
        }




    }

}
