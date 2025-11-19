package baekjoon.binarysearch;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 기타 레슨
 */
public class BaekJoon_2343 {

    static int N, M;
    static int[] arr;
    static long answer = 0;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];

        long left = 0;
        long right = 0;
        for (int i = 0; i < N; i++) {

            arr[i] = sc.nextInt();
            left = Math.max(left,arr[i]);
            right+=arr[i];
        }


        while(left<=right){
            long mid = (left+right)/2;

            int count = countBluRay(mid);

            if(count<=M){
                answer = mid;
                right = mid -1;
            }else{
                left = mid +1;
            }


        }


        System.out.println(answer);

    }


    private static int countBluRay(long mid) {

        long sum = 0;
        int count=1;

        for (int i = 0; i < N; i++) {

            if(sum+arr[i]>mid){
                count++;
                sum= arr[i];
            }
            else{
                sum+=arr[i];
            }
        }

        return count;
    }
}
