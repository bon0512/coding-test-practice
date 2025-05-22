package samsungexpert;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_1206 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] height = new int[N];

        for(int i =0; i <N;i++){
            height[i] = sc.nextInt();
        }

        int count =0;
        for(int i =2; i<N-2;i++){
            int leftMaxHeight =Math.max(height[i-2],height[i-1]);
            int rightMaxHeight = Math.max(height[i+2],height[i+1]);

            int maxHeight = Math.max(leftMaxHeight,rightMaxHeight);

            if(height[i]>maxHeight){
                count+=height[i]-maxHeight;
            }

        }

        System.out.println(count);

    }
}
