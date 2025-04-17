package hash;

import java.util.HashMap;
import java.util.Map;

public class HashPractice {


    public static void main(String[] args) {

        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("ABC",10);
        hashMap.put("BBB",20);
        hashMap.put("AAA",30);
        hashMap.put("ABC",15);
        hashMap.put("ACC",15);

        System.out.println("hashMap = " + hashMap);
        System.out.println("hashMap.isEmpty() = " + hashMap.isEmpty());
        System.out.println("hashMap.get(\"ABC\") = " + hashMap.get("ABC"));
        System.out.println("hashMap.containsKey(\"ABC\") = " + hashMap.containsKey("ABC"));
        System.out.println("hashMap.containsValue(15) = " + hashMap.containsValue(15));


        Integer abc = hashMap.remove("ABC");
        System.out.println("abc = " + abc);
        int size = hashMap.size();
        System.out.println("size = " + size);
    }

}
