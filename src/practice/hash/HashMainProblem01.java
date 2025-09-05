package practice.hash;

import java.util.*;

public class HashMainProblem01 {

    public static void main(String[] args) {

    }

    private static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        String noCompletion = "";
        for (String s : participant) {
            if (hashMap.containsKey(s)) {
                hashMap.put(s, hashMap.get(s) + 1);
            }
            else {
                hashMap.put(s, 1);
            }
        }

        for (String s : completion) {
            if (hashMap.containsKey(s)) {
                hashMap.put(s, hashMap.get(s) - 1);
            }
        }

        for(String s : hashMap.keySet()){
            if(hashMap.get(s)!=0){
                noCompletion = s;
            }
        }
        return noCompletion;
    }
}
