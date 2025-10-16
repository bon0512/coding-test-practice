package baekjoon.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaekJoon_1182 {

    static int S,N;
    static int[] arr;

    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i <N ; i++) {

            arr[i] = sc.nextInt();

        }
        
        
        dfs(0,0);

        if(S==0) answer--;

        System.out.println(answer);

        
    }

    private static void dfs(int depth ,int sum ) {

        if(depth==N){

            if(sum == S) answer++;
            //System.out.println(sum);
            return;
        }

        //선택안한다.
        dfs(depth+1,sum);


        //선택 한다.
        dfs(depth+1,sum+arr[depth]);
        
    }
}
