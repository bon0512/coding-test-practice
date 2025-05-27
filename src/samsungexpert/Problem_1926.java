package samsungexpert;

import java.util.Scanner;

public class Problem_1926 {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int N;
        N=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        String[] strInput = new String[N];

        for(int i =0; i<N;i++){
            strInput[i] = String.valueOf(i+1);

        }
        for(int i =0;i<N;i++){
            String tmp ="";
            for(int j =0; j<strInput[i].length();j++){


                if(strInput[i].charAt(j)=='3'|| strInput[i].charAt(j)=='6'|| strInput[i].charAt(j)=='9') {
                    tmp= tmp+"-";
                }

            }

            if(tmp.equals("")){
                System.out.print(strInput[i]+" ");
            }
            else{
                System.out.print(tmp + " ");
            }
        }
    }
}
