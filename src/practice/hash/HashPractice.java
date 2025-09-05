package practice.hash;

import java.util.HashMap;

public class HashPractice {


    public static void main(String[] args) {

        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("ABC",10);
        hashMap.put("ABB",11);
        hashMap.put("ABD",12);
        hashMap.put("ABC",12);


        System.out.println("hashMap = " + hashMap);
    }

}
