package baekjoon.implementation;

import java.util.*;

public class BaekJoon_2108 {

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        int num = sc.nextInt();
        int[] arr = new int[num];

        Map<Integer,Integer> map = new HashMap<>();

        int sum = 0;

        for (int i = 0; i < num; i++) {
            int temp = sc.nextInt();
            sum+=temp;
            arr[i] = temp;
            map.put(temp,map.getOrDefault(temp,0)+1);
        }

        //산술 평균
        System.out.println(Math.round((double)sum/num));



        Arrays.sort(arr);
        //중앙값
        System.out.println(arr[num/2]);


        //최빈값
        int max = -1;
        for (Integer value : map.values()) {
            max = Math.max(value,max);
        }

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == max){
                list.add(entry.getKey());
            }
        }
        Collections.sort(list);
        if(list.size()==1){
            System.out.println(list.get(0));
        }else {
            System.out.println(list.get(1));
        }



        //범위
        System.out.println(arr[num-1] - arr[0] );

    }
}
