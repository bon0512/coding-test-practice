package programmers.Implement;

import java.util.Arrays;


//문제에서 나와있는 순서대로 구현하면 된다..

public class 테이블_해시_함수 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int colIdx = col - 1;

        Arrays.sort(data, (a, b) -> {
            if (a[colIdx] == b[colIdx]) {
                return Integer.compare(b[0], a[0]);
            }
            return Integer.compare(a[colIdx], b[colIdx]);
        });

        int answer = 0;

        for (int i = row_begin; i <= row_end; i++) {
            int sum = 0;

            for (int value : data[i - 1]) {
                sum += value % i;
            }

            answer ^= sum;
        }

        return answer;
    }

}
