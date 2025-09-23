package baekjoon.implementation;

import java.util.Scanner;

public class BaekJoon_2877 {


    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        int k =sc.nextInt();
        StringBuilder sb = new StringBuilder();


        int count = 2;
        int len = 1;
        while(true){

            if(k>count){
                k-=count;
                count*=2;
                len++;
            }else{
                break;
            }

        }

    }
}
