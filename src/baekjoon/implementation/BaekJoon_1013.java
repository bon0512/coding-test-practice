package baekjoon.implementation;

import java.util.Scanner;

public class BaekJoon_1013 {

    public static void main(String[] args) {


        Scanner sc= new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();
        String pattern = "(100+1+|01)+";

        for (int i = 0; i < T; i++) {
            String s = sc.nextLine();

            if(s.matches(pattern)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
