package practice.array;

public class ArrayProblem02 {
    public static void main(String[] args) {


        int n =4;

        int[][] array = new int[n][n];

        int col =0, row = 0;
        int count=1;

        while(true){

            //가로로 내려갈때
            while(true){
                array[col][row]=count++;
                if(col+1==n||array[col+1][row]!=0) break;
                col++;
            }

            if(row+1==n || array[col][row+1]!=0) break;
            row++;

            //세로로 내려갈때
            while(true){
                array[col][row] = count++;
                if(row+1==n|| array[col][row+1]!=0) break;
                row++;

            }

            if(col-1 < 0 || row-1 < 0 || array[col-1][row-1]!=0) break;
            col--;
            row--;

            //왼쪽 대각선으로 올라갈때
            while(true){
                array[col][row]= count++;
                if(array[col-1][row-1]!=0) break;
                col--;
                row--;
            }

            if(col+1>=n || array[col+1][row]!=0)break;
            col++;
        }

        int[] result = new int[count-1];
        int index=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <=i; j++) {
                result[index++]=array[i][j];

            }

        }




    }
}
