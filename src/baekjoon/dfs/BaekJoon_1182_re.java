package baekjoon.dfs;

import java.util.Scanner;

/**
 ==========================
 * 링크 : https://www.acmicpc.net/problem/1182
 * 이름 : 부분수열의 합
 * 난이도 : S2
 * ========================== */
public class BaekJoon_1182_re {

    static int N,S,count;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        count = 0;
        dfs(0,0);

        if(S == 0){
            count--;
        }
        System.out.println(count);

    }

    private static void dfs(int index, int sum) {
        if(index==N) {
            if(sum == S) {
                count++;
            }

            return;
        }
        //추가 안한다.
        dfs(index+1,sum);

        //추가한다.
        dfs(index+1,sum+arr[index]);

    }
}
