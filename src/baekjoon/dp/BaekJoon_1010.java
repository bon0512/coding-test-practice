package baekjoon.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 다리 놓기
 * 문제를 보니 조합문제, d
 */
public class BaekJoon_1010 {

    static int N;
    static int M;

    static int[][] arr = new int[31][31];
    static int count = 0;

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            N = sc.nextInt();       //서쪽
            M = sc.nextInt();       //동쪽


            System.out.println(comb(M, N));

        }
    }

    private static int comb(int n, int r) {

        if (arr[n][r] != 0) return arr[n][r];

        if (n == r || r == 0) return arr[n][r] = 1;

        return arr[n][r] = comb(n - 1, r) + comb(n - 1, r - 1);

    }

    /*private static void dfs(int start,  List<Integer> list) {
        if(list.size()==N){
            count++;
            return ;
        }

        for (int i = start; i <= M; i++) {
            list.add(i);
            dfs(i+1,list);
            list.remove(list.size()-1);
        }


    }*/
}
