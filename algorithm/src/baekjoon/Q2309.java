package baekjoon;

/*
블랙잭 

문제 https://www.acmicpc.net/problem/2798
카지노에서 제일 인기 있는 게임 블랙잭의 규칙은 상당히 쉽다. 카드의 합이 21을 넘지 않는 한도 내에서, 카드의 합을 최대한 크게 만드는 게임이다. 블랙잭은 카지노마다 다양한 규정이 있다.

한국 최고의 블랙잭 고수 김정인은 새로운 블랙잭 규칙을 만들어 상근, 창영이와 게임하려고 한다.

김정인 버전의 블랙잭에서 각 카드에는 양의 정수가 쓰여 있다. 그 다음, 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다. 그런 후에 딜러는 숫자 M을 크게 외친다.

이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다. 블랙잭 변형 게임이기 때문에, 플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.

N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.

입력
첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100)과 M(10 ≤ M ≤ 300,000)이 주어진다. 둘째 줄에는 카드에 쓰여 있는 수가 주어지며, 이 값은 100,000을 넘지 않는 양의 정수이다.

합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어진다.

출력
첫째 줄에 M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력한다.
*/

import java.io.*;
import java.util.*;

public class Q2309{
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	    String[] firstInput = bf.readLine().split(" ");
	    String[] secondInput = bf.readLine().split(" ");
		int n = Integer.parseInt(firstInput[0]);			// 카드의 개수
		int m = Integer.parseInt(firstInput[1]);			// 딜러가 말한 숫자 M
		int[] numList = new int[n];							// 카드에 적혀있는 숫자 리스트   
		int result = 0;										// 결과
		
		// 문자열 배열에서 정수배열로 변환
		for (int i = 0; i < secondInput.length; i++) {
			numList[i] = Integer.parseInt(secondInput[i]);;
		}
		Arrays.sort(numList);					// 오름차순 정렬

		// 세가지수의 합이 M과 가장 가까운 수를 구하는 로직
		label1:
		for (int i = numList.length - 1; i > 1; i--) {	// 역순 반복
			int firstNum = numList[i];					// 첫번째 숫자
			
			for (int j = i - 1; j > 0; j--) { 		    // 역순 반복
				int secondNum = numList[j];				// 두번째 숫자
				
				if(firstNum + secondNum > m) continue;	// 역순 반복에서 첫번째수와 두번째수의 합이 m보다 클경우 더이상 로직을 수행할 필요X
				
				for (int k = 0; k < j; k++) { 			// 정상 반복
					int thirdNum = numList[k];			// 세번째 숫자
					int sum = firstNum + secondNum + thirdNum;	// 세수의 합
					
					if(sum == m) {
						result = sum; 		// 세수의 합이 딜러가말한 M과 같은경우 더이상 연산X
						break label1;		// 최상위 반복문 종료
					} else if(sum > m){		// i j k 세수의 합이 m보다 클경우 가장하위 반복물 중지(오름차순 정렬을 하였기때문에 이후 연산은 의미없음)
						break;
					} else { // sum < m
						if(sum > result) result = sum;	// 최대값을 구하는 로직
					}
				}
			}
		}
		
		System.out.println(result);
	}
}
