package baekjoon.binarysearch;

import java.util.List;
import java.util.Scanner;

/**
 * 백준
 */
public class BaekJoon_1300 {

    static int N;
    static long K;
    static long[][] A;
    static List<Long> B;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextLong();

        long start = 0;
        long end = (long)N*N;
        long answer = 0;

        while(start<=end){
            long mid = (start+end)/2;

            long count = 0;
            for (int i = 1; i <=N ; i++) {
                count+=Math.min(mid/i,N);
            }

            if(count<K){
                start = mid+1;

            }else{
                answer = mid;
                end = mid-1;

            }
        }

        System.out.println(answer);


    }
}
