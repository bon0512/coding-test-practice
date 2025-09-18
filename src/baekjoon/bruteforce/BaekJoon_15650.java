package baekjoon.bruteforce;

import java.util.*;

/**
 * 백준 15650 N과M 2
 * 조합문제. 노드 트리를 그려보자. 힌트는 depth 1 숫자보다 depth2 숫자가 커야한다 .
 *
 */

public class BaekJoon_15650 {


    static int N,M;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        comb(1,0,new int[M]);

    }

    private static void comb(int start,int depth, int[] arr) {
        if(depth==M){
            for (int i : arr) {
                System.out.print(i+" ");
            }
            System.out.println();
            return ;
        }

        for (int i = start; i <=N; i++) {
            arr[depth]=i;
            comb(i+1,depth+1,arr);

        }



    }
}
