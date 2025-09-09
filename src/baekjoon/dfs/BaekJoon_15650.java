package baekjoon.dfs;

import java.util.*;

public class BaekJoon_15650 {

    static int N;
    static int M;
    static int [] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];

        combination(1,0);

    }
    public static void combination(int start,int depth){

        if( depth>=M){
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return ;
        }



        for (int i = start; i <=N ;i++) {
            arr[depth] = i;
            combination(i+1,depth+1);
        }

    }
}
