package baekjoon.bruteforce;

import java.util.Scanner;

public class BaekJoon_15649 {

    static int N,M;
    static int[] arr ;
    static boolean[] visited;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        visited = new boolean[N];



        per(0, new int[M]);

    }

    private static void per(int depth, int[] temp) {
        if (depth == M){
            for (int i : temp) {
                System.out.print(i + " ");
            }
            System.out.println();
            return ;
        }

        for (int i = 0; i < arr.length; i++) {
            if(!visited[i]){
                visited[i] =true;
                temp[depth] = i+1;
                per(depth+1,temp);
                visited[i] =false;
            }
        }

    }
}
