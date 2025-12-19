package baekjoon.dfs;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BaekJoon_11478 {

    static Set<String> set = new HashSet<>();
    static String s;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        s = sc.next();


        for (int i = 0; i < s.length(); i++) {
            dfs("",i);
        }



        //System.out.println(set);
        System.out.println(set.size());
    }

    private static void dfs(String temp, int index) {
        if(index==s.length()){
            return;
        }
        String a = temp+s.charAt(index);
        //System.out.println(a);
        set.add(a);
        dfs(a,index+1);
    }
}
