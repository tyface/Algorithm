package programmers;

public class LevelTest01_2 {
	public long solution(int a, int b) {
		long answer = 0;
		long max = a > b ? a : b;
		long min = a < b ? a : b;

		while (min <= max) {
			answer += min;
			min++;
		}

		return answer;
	}
}
