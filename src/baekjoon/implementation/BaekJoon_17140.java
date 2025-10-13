package baekjoon.implementation;

import java.util.*;

public class BaekJoon_17140 {

    static int r, c, k;
    static int[][] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        k = sc.nextInt();

        arr = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i <= 100; i++) {
            if (arr[r - 1][c - 1] == k) {
                System.out.println(i);
                return;
            }

            if (arr.length >= arr[0].length) calR();
            else calL();


        }


    }

    private static void calL() {
    }

    private static void calR() {

        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j]==0) continue;
                map.put(arr[i][j],map.getOrDefault(arr[i][j],0)+1);

            }

            List<int[]> list= new ArrayList<>();

            for(Map.Entry<Integer,Integer> entry : map.entrySet()){

                list.add(new int[]{entry.getKey(),entry.getValue()});

            }
            Collections.sort(list,(a,b)->{
                if(a[1]==b[1]) return a[0]-b[0];
                return a[1]-b[1];
                    }
            );

            List<Integer> tempRow = new ArrayList<>();

            for (int[] ints : list) {
                tempRow.add(ints[0]);
                tempRow.add(ints[1]);
            }

            answer.add(tempRow);

        }

        int minLen = 0;

        for(List<Integer>list : answer){
            minLen = Math.max(minLen,list.size());
        }

        minLen = Math.min(minLen,100);

        arr = new int[answer.size()][minLen];
        for (int i = 0; i < arr.length; i++) {

        }


    }
}
