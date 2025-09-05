package programmers.bfs;

import java.util.Arrays;

/**
 * 피보나치 수
 */


public class 피보나치 {
    public static int[] mem = new int[100001];
    public int solution(int n) {

        Arrays.fill(mem,-1);

        int answer = fibo(n);

        return answer;
    }

    public static int fibo(int n){
        if(mem[n]!=-1) return mem[n];
        if(n==0||n==1) return n;

        mem[n] = (fibo(n-1) + fibo(n-2))%1234567;
        return mem[n];


    }
}
