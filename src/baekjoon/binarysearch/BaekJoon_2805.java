package baekjoon.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon_2805 {


    static int N;
    static long M;
    static long[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextLong();

        arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] =sc.nextInt();
        }

        Arrays.sort(arr);

        long answer = search();

        System.out.println(answer);

    }

    private static long search() {
        long start = 0;
        long end = arr[N-1];
        long answer =-1;

        while(start<=end){
            long mid = (start+end)/2;

            int index = Arrays.binarySearch(arr,mid);
            if(index<0) {
                index = (index * -1) -1;
            }

            long temp =0;
            for (int i = index; i <N; i++) {
                temp += (arr[i] - mid);
            }

            if(temp>=M){
                answer = mid;
                start = mid+1;
            }
            else{
                end = mid -1;
            }

        }

        return answer;

    }
}
