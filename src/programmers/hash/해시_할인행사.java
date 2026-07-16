package programmers.hash;

import java.util.*;

public class 해시_할인행사 {
    public static void main(String[] args) {

        class Solution {
            public int solution(String[] want, int[] number, String[] discount) {
                //해쉬 맵을 통해 각 상품을 카운트해 저장한다.

                Map<String,Integer> map = new HashMap<>();

                for(int i = 0 ; i <want.length;i++){
                    map.put(want[i],number[i]);
                }

                boolean clear = true;
                int answer = 0;

                //반복문을 통해 discount를 처음부터 총 상품 수만큼 순회하면서 체크한다.
                for(int i =0; i<=discount.length-10;i++){

                    for(int j = i ;j < i+10; j++){

                        String temp = discount[j];

                        int count = map.getOrDefault(temp,0);

                        if(count>0){
                            map.put(temp,map.get(temp)-1);
                        }
                    }

                    for(String key: map.keySet()){
                        if(map.get(key)>0){
                            clear = false;
                            break;
                        }
                    }

                    if(clear == true){
                        answer++;
                    }else{
                        clear = true;
                    }

                    map.clear();

                    for(int k = 0 ; k < want.length;k++){
                        map.put(want[k],number[k]);
                    }
                }
                return answer;
            }
        }
    }
}
