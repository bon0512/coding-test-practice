package baekjoon.binarysearch;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BaekJoon_2143 {

    static int T, n, m;
    static int[] A, B;
    static int[] prefixA, prefixB;
    static Map<Long,Long> countA = new HashMap<>(), countB = new HashMap<>();
    static Long result = 0L;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        n = sc.nextInt();

        A = new int[n];
        prefixA = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
            countA.put((long) A[i],countA.getOrDefault((long)A[i],0L)+1);
        }
        prefixA[0] = A[0];

        for (int i = 1; i < n; i++) {
            prefixA[i] = prefixA[i - 1] + A[i];
        }

        m = sc.nextInt();
        B = new int[m];
        prefixB = new int[m];

        for (int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
            countB.put((long) B[i],countB.getOrDefault((long)B[i],0L)+1);
        }
        prefixB[0] = B[0];
        for (int i = 1; i < m; i++) {
            prefixB[i] = prefixB[i - 1] + B[i];
        }



        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <n ; j++) {
                long sum = sumPrefix(prefixA,i,j);
                countA.put(sum,countA.getOrDefault(sum,0L)+1);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = i+1; j <m ; j++) {
                long sum = sumPrefix(prefixB,i,j);
                countB.put(sum,countB.getOrDefault(sum,0L)+1);
            }

        }
        //System.out.println(countA);
        //System.out.println(countB);

        for (Long keyA : countA.keySet()) {
            Long temp = T - keyA;
            //System.out.println("temp = " + temp +" keyA = "+ keyA );
            if(!countB.containsKey(temp)) continue;
            result += countA.get(keyA) * countB.get(temp);

        }

        System.out.println(result);

    }


    private static long sumPrefix(int[] prefix, int start, int end){
        if(start ==0) return prefix[end];
        else return prefix[end] - prefix[start-1];
    }
}
