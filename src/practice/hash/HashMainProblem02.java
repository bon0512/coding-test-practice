package practice.hash;

import java.util.*;
public class HashMainProblem02 {



    private static int solution(String[] want,int[] number, String[] discount){

        HashMap<String, Integer> hashMap = new HashMap<>();
        int result = 0;
        for(int i = 0; i < want.length;i++){
            hashMap.put(want[i],number[i]);
        }

        for(int i =0; i < discount.length-9;i++){

            HashMap<String, Integer> discount10 = new HashMap<>();

            for(int j =i; j<i+10;j++){

                if(discount10.containsKey(discount[j]))
                    discount10.put(discount[j],discount10.get(discount[j])+1);
                else{
                    discount10.put(discount[j],1);
                }

            }

            if(hashMap.equals(discount10)){
                result++;
            }
        }

        return result;

    }
}
