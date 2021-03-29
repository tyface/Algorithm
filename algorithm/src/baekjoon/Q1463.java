package baekjoon;

/*
1로 만들기

문제	https://www.acmicpc.net/problem/1463
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.

입력
첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.

출력
첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.

 * */

import java.io.*;

public class Q1463 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int dp[][] = new int[n + 3][3];
		
		dp[1][0] = 0;	// 1을 뺀경우
		dp[2][1] = 1;	// 2로 나눈경우
		dp[3][2] = 1;	// 3으로 나눈경우
		
		for (int i = 4; i < dp.length; i++) {
			int case1 = -1;	// 1빼기
			int case2 = -1;	// 2나누기
			int case3 = -1;	// 3나누기
			
			// 1빼기 케이스
			case1 = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + 1;
			dp[i][0] = dp[i - 1][0] + 1;
			dp[i][1] = dp[i - 1][1];
			dp[i][2] = dp[i - 1][2];
			
			// 2로 나누어질때 케이스
			if(i%2 == 0) {
				case2 = dp[i / 2][0] + dp[i / 2][1] + dp[i / 2][2] + 1;
				//2로 나눈 케이스의 횟수가 case1 보다 낮을경우
				if(case1 >= case2) {	
					dp[i][0] = dp[i / 2][0];
					dp[i][1] = dp[i / 2][1] + 1;
					dp[i][2] = dp[i / 2][2];
				}
			}
			
			// 3으로 나누어질때 케이스
			if(i%3 == 0) {
				case3 = dp[i / 3][0] + dp[i / 3][1] + dp[i / 3][2] + 1;
				// 3으로 나눈 케이스가 case1 과 case2 보다 낮을경우
				if(case1 >= case3 && (case2 == -1 || case2 >= case3)) {
					dp[i][0] = dp[i / 3][0];
					dp[i][1] = dp[i / 3][1];
					dp[i][2] = dp[i / 3][2] + 1;
				}
			}
		}
		
		System.out.println(dp[n][0] + dp[n][1] + dp[n][2]);
	}
}