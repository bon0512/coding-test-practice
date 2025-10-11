package baekjoon.implementation;

import java.util.Scanner;
import java.util.Stack;

public class BaekJoon_16120 {

    static Stack<Character> stack = new Stack<>();
    static String s ;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();


        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'P') {
                stack.push('P');
            } else if (i != s.length() - 1 && stack.size() >= 2 && s.charAt(i + 1) == 'P') {
                stack.pop();
                stack.pop();
            } else {
                System.out.println("NP");
                return;
            }

        }

        if(stack.size()==1){
            System.out.println("PPAP");
        }else{
            System.out.println("NP");
        }

        System.out.println(stack);
    }
}
