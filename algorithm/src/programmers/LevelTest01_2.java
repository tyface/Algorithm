package programmers;

public class LevelTest01_2 {
	public long solution(int a, int b) {
		long answer = 0;
		long max = a > b ? a : b;	// 입력받는 두수중 큰값
		long min = a < b ? a : b;	// 입력받는 두수중 작은값

		// 입력받은 두수를 포함한 두수사이의 모든수의 합을 구하는 반복문
		while (min <= max) {
			answer += min;
			min++;
		}

		return answer;
	}
}
