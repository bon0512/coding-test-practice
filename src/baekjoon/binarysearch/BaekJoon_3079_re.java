package baekjoon.binarysearch;

import java.util.Scanner;

public class BaekJoon_3079_re {

    static int N;
    static long M;
    static long answer;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextLong();
        arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        binarySearch();
        System.out.println(answer);
    }

    private static void binarySearch() {
        long start = 1;
        long end = 0;

        for (int i = 0; i < arr.length; i++) {
            end = Math.max(end, (long) arr[i] * M);
        }

        while (start <= end) {
            long mid = (start + end) / 2;

            long total = 0;
            for(int i =0; i<N;i++){
                total+=mid/arr[i];
                if (total >= M) break;
            }

            if(total>=M){
                answer = mid;
                end = mid-1;
            }else{
                start = mid +1;
            }
        }

    }
}
