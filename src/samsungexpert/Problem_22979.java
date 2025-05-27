package samsungexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Problem_22979 {
    public static void main(String args[]) throws Exception {
        // 표준입력 System.in 으로부터 버퍼리더를 통해 입력을 받습니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());  // 테스트 케이스 수

        for (int test_case = 1; test_case <= T; test_case++) {
            String S = br.readLine().trim();                     // 문자열 S
            int K = Integer.parseInt(br.readLine().trim());      // 연산 개수

            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int total = 0;

            for (int i = 0; i < K; i++) {
                total += Integer.parseInt(st.nextToken());
            }

            int n = S.length();
            total %= n;
            if (total < 0) {
                total += n;
            }

            String rotated = S.substring(total) + S.substring(0, total);
            System.out.println(rotated);
        }

        br.close();
    }
}

