package baekjoon.binarysearch;

import java.util.*;

public class BaekJoon_3079_re {
    static int N, M;
    static int[] arr;
    static long answer =0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        binarySearch();
        System.out.println(answer);
    }

    private static void binarySearch() {
        long start = 1;
        long end =0;

        for (int i = 0; i < N; i++) {
            end = Math.max(M * (long)arr[i],end);
        }

        while(start<=end){
            long mid = (start+ end)/2;
            long total = 0;

            // mid 시간에서 각 라인당 최소 인원수체크
            for (int i = 0; i < N; i++) {
                total += mid/arr[i];
                if(total>=M) break;
            }

            //전체 인원보다 더 많이 들어가거나 같으면 끝 시간을 mid보다 -1 줄이기
            //전체 인원보다 더 적게 들어갈경우 mid를 높이기 위해 좌측(start) 시간을 높인다.
            if(total>=M){
                answer = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }

        }

    }
}
