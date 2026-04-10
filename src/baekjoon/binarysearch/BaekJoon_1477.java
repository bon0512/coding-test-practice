package baekjoon.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 ==========================
 * 주소 : https://www.acmicpc.net/problem/1477
 * 이름 : 휴게소 세우기
 * 난이도 : G4
 * @since 2026-04-10
 * ========================== */

public class BaekJoon_1477 {
    static int N,M,L;
    static int[] arr;
    static int answer=0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        L = sc.nextInt();

        arr = new int[N+2];
        arr[0] = 0;
        arr[N+1] = L;

        for (int i = 0; i <N ; i++) {
            arr[i+1] = sc.nextInt();
        }

        Arrays.sort(arr);

        binarySearch();
        System.out.println(answer);
    }

    private static void binarySearch() {
        int start = 1;
        int end = L;

        while(start<=end){
            int mid = (start+end)/2;

            int buildCount = 0;

            for (int i = 1; i <arr.length ; i++) {
                int dis = arr[i] - arr[i-1];
                buildCount += (dis-1)/mid;
            }

            if(buildCount>M){
                start = mid+1;
            }else{
                answer = mid;
                end = mid-1;
            }
        }
    }
}
