package baekjoon.greedy;

import java.util.*;

public class BaekJoon_1541 {

    static String s ="";


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();

        int result = 0;

        String[] split = s.split("-");

        //System.out.println(Arrays.toString(split));

        result = sum(split[0]);

        for (int i = 1; i < split.length; i++) {
            if(split[i]!="-"){
               int temp  = sum(split[i]);
                split[i] = Integer.toString(temp);
            }
        }
        //System.out.println(Arrays.toString(split));

        for (int i = 1; i <split.length ; i++) {

                result = result - Integer.parseInt(split[i]);

        }

        System.out.println(result);
    }

    private static int sum(String s){
        String[] plusNumber = s.split("\\+");
        int result = 0;

        for (String string : plusNumber) {
            if(!Objects.equals(string, "+")){
                result+=Integer.parseInt(string);
            }
        }


        return result;
    }
}
