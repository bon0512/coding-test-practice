package array;

import java.util.Scanner;

public class ArrayProblem05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        

        int[] dir = new int[6];
        int[] len = new int[6];
        int maxWidth = 0;
        int maxHeight = 0;
        int maxHeightIndex = -1;
        int maxWidthIndex = -1;


        for (int i = 0; i < 6; i++) {
            dir[i] = sc.nextInt();
            len[i] = sc.nextInt();

            if(dir[i]==1 || dir[i]==2){
                if(len[i]>maxHeight){
                    maxHeight= len[i];
                    maxHeightIndex = i;
                }
            }else{
                if(len[i]>maxWidth){
                    maxWidth = len[i];
                    maxWidthIndex = i;
                }

            }
        }

        int cutWidth = Math.abs(len[(maxHeightIndex+1) % 6] - len[(maxHeightIndex+5) % 6]);
        int cutHeight = Math.abs(len[(maxWidthIndex+1) % 6] -len[(maxWidthIndex +1)%6]);

        int answer = (maxHeight*maxWidth - cutWidth*cutHeight) * k;
        System.out.println(answer);

    }
}
