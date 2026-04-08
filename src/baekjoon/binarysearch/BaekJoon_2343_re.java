package baekjoon.binarysearch;

import java.util.Scanner;

public class BaekJoon_2343_re {

    static int N,M;
    static int[] arr;
    static int answer;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        binarySearch();
        System.out.println(answer);
    }

    private static void binarySearch() {
        int start = 0;
        int end = 0;

        for (int i = 0; i <arr.length ; i++) {
            start = Math.max(start,arr[i]);
            end+=arr[i];
        }

        while(start<=end) {
            int mid = (start + end) / 2;
            int count = 1;
            int sum=0;

            for (int i = 0; i <arr.length; i++) {
                if(sum+arr[i]>mid){
                    count++;
                    sum = arr[i];
                }else{
                    sum+=arr[i];
                }
            }
            if (count <= M) {
                answer = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

    }
}
