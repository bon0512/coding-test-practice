package baekjoon.bruteforce;


import java.util.*;

/**
 * 다음 순열 알고리즘
 * 1. 오른쪽부터 현재요소 i와  오른쪽요소 i+1에 대해서  i<i+1 인 i를 pivot이라 설정한다.
 * 2. pivot부터 배열의 끝까지 pivot 보다 큰 수중, 가장 작은 숫자를 구한다.
 * 3. pivot과 2번에서 구한 가장 작은 숫자를 스왑
 * 4. 그후 피봇 이후 배열을 오름차순 정렬
 */

public class BaekJoon10972 {

    static int N;
    static int[] arr;
    static boolean[] back;
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new int[N];
        back = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }


        int pivot = -1;
        for (int i = N - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                pivot = i - 1;
                break;
            }
        }

        if (pivot == -1) {
            System.out.print(-1);
            return;
        }


        int minIndex = pivot + 1;
        for (int i = pivot; i < N; i++) {
            if (arr[pivot] < arr[i] && arr[i] <= arr[minIndex]) {
                minIndex = i;
            }
        }

        int temp = arr[pivot];
        arr[pivot] = arr[minIndex];
        arr[minIndex] = temp;

        int left = pivot + 1, right = N - 1;
        /* while(left<right){
            temp = arr[left];
            arr[left] = arr[right];
            arr[right]= temp;
            left++;
            right--;
        }*/

        Arrays.sort(arr, pivot + 1, N);

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }


    }


}
