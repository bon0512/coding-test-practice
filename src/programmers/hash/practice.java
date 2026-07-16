package programmers.hash;

import java.util.*;

public class practice {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,8};


        Set<Integer> set = new HashSet<>();

        for (int i : arr) {
            set.add(i);
        }

        int target = 6;

        for(int i =0; i<arr.length;i++){
            int tmp = target - arr[i];

            if(set.contains(tmp)){
                System.out.println("true");
                return;
            }
        }

        System.out.println("false");



    }
}
