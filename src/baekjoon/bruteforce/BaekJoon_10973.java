package baekjoon.bruteforce;

import java.util.Scanner;

/**
 * 이전순열
 * 1. 끝에서 내려오면서 내림차순을 깨는 인덱스를 찾는다 i-1>i;
 * 2. 그후 피봇 보다 작으면서 가장 큰수를 찾고 피봇이랑 스왑한다.
 * 3. 그후 내림차순으로만드는데 사실 이미 내림차순 상태라 단순히 reverse만 해주면 된다.
 *
 */

public class BaekJoon_10973 {


    static void main() {


        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int pivot = -1;
        for (int i = N-1; i >0; i--) {
            if(arr[i-1]>arr[i]){
                pivot = i-1;
                break;
            }

        }

        if(pivot ==-1){
            System.out.println(-1);
            return ;
        }
        int maxIndex = pivot+1;
        for (int i = pivot+1; i < N; i++) {
            if(arr[pivot]>arr[i] && arr[maxIndex]<arr[i]){
                maxIndex = i;
            }
        }

        int temp = arr[maxIndex];
        arr[maxIndex] = arr[pivot];
        arr[pivot] = temp;

        int left = pivot+1;
        int right = N -1;
        while(left<right){
            int t = arr[right];
            arr[right]=arr[left];
            arr[left] =t;
            left++;
            right--;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i]+" ");
        };

    }
}
