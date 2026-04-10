package baekjoon.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon_14426 {

    static int N,M;
    static String[] words;
    static String[] target;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        words = new String[N];
        target = new String[M];
        for (int i = 0; i < N; i++) {
            words[i] = sc.next();
        }

        for (int i = 0; i < M; i++) {
            target[i] = sc.next();
        }

        Arrays.sort(words);

        for (int i = 0; i < M; i++) {
            String tmp = target[i];
            int index = binarySearch(tmp);
            if(index<N && words[index].startsWith(tmp)){
                answer++;
            }
        }

        System.out.println(answer);

    }

    static int binarySearch(String temp){
        int start = 0;
        int end = N;

        while(start<end){
            int mid = (start+end)/2;

            if(words[mid].compareTo(temp)>=0){
                end = mid;
            }else{
                start = mid +1;
            }
        }
        return start;
    }

}
