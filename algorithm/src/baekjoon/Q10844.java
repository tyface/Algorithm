package baekjoon;

/*
쉬운 계단 수

문제	https://www.acmicpc.net/problem/10844
45656이란 수를 보자.

이 수는 인접한 모든 자리수의 차이가 1이 난다. 이런 수를 계단 수라고 한다.

세준이는 수의 길이가 N인 계단 수가 몇 개 있는지 궁금해졌다.

N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구하는 프로그램을 작성하시오. (0으로 시작하는 수는 없다.)

입력
첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.

출력
첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.

 * */

import java.io.*;

public class Q10844 {
	public static final int MOD = 1000000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());	// 자릿수
        long[][] dp = new long[n][10];				// dp 배열
        long result = 0;							// 정답

        //첫번째 dp구하는 로직
        for(int i = 1; i < 10; i++) {
            dp[0][i] = 1;
        }

        //두번째 이후 dp구하는 로직
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 10; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i-1][j+1] % MOD;
                } else if(j == 9) {
                    dp[i][j] = dp[i-1][j-1] % MOD;
                } else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % MOD;
                }
            }
        }
        
        for(int i = 0; i < 10; i++) {
        	result += dp[n - 1][i];
        }
        
        System.out.println(result % 1000000000);
    }
}
