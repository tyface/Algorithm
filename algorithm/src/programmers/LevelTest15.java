package programmers;

/*

소수 찾기

문제 설명
1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.

소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
(1은 소수가 아닙니다.)

제한 조건
n은 2이상 1000000이하의 자연수입니다.

입출력예
n		result
10		4
5		3

입출력 예 설명

입출력 예 #1
1부터 10 사이의 소수는 [2,3,5,7] 4개가 존재하므로 4를 반환

입출력 예 #2
1부터 5 사이의 소수는 [2,3,5] 3개가 존재하므로 3를 반환

*/

public class LevelTest15 {
	public int solution(int n) {
		int[] arr = new int[n - 1];

		// n이하 2이상의 모든수를 배열에 입력
		for (int i = 2; i <= n; i++) {
			arr[i - 2] = i;
		}

		// 소수를 구하는 공식
		for (int i = 2; i <= Math.sqrt(n); i++) {	//소수는 해당수의 제곱근보다 작은 정수로 나누었을대 나눠지지 않는수이다
			if (arr[i - 2] != 0) {		//해당배열에 있는숫자가 0이아닐경우
				for (int j = i + i; j <= n; j += i) {
					if(arr[j - 2] % i == 0) {
						arr[j - 2] = 0;	//소수가 아니면 해당배열에 0을 입력
					}
				}
			}
		}

		int count = 0;

		//소수의 개수 구하기
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] != 0) {
				count++;
			}
		}

		return count;
	}
}
