package baekjoon;

/*
오르막 수

문제 https://www.acmicpc.net/problem/11057

오르막 수는 수의 자리가 오름차순을 이루는 수를 말한다. 이때, 인접한 수가 같아도 오름차순으로 친다.

예를 들어, 2234와 3678, 11119는 오르막 수이지만, 2232, 3676, 91111은 오르막 수가 아니다.

수의 길이 N이 주어졌을 때, 오르막 수의 개수를 구하는 프로그램을 작성하시오. 수는 0으로 시작할 수 있다.

입력
첫째 줄에 N (1 ≤ N ≤ 1,000)이 주어진다.

출력
첫째 줄에 길이가 N인 오르막 수의 개수를 10,007로 나눈 나머지를 출력한다.

 * */

import java.io.*;

public class Q11057 {
	private final static int mod = 10007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());	// 길이가 N인 오르막 수
		int intArry[] = new int[10];				// dp 배열
		
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			int tempArry[] = new int[10];			// 임시 dp배열
			
			for (int j = 0; j < 10; j++) {
				
				if(i == 1) {	// 1자리수인 경우 로직
					tempArry[j] = 1;
				} else {		// 2자리수 이상인 경우
					if(j == 0) {
						tempArry[j] = sum;
						continue;
					}
					tempArry[j] = tempArry[j - 1] - intArry[j - 1];
				}
			
				tempArry[j] = (tempArry[j] + mod) % mod;
				sum += tempArry[j];
			}
			intArry = tempArry;
		}
		System.out.println(sum % mod);
	}
}