package programmers;

import java.util.Calendar;
import java.util.Locale;

/*
2016년

문제 설명
2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요?
두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요.
요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT

입니다. 예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 TUE를 반환하세요.

제한 조건
2016년은 윤년입니다.
2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)

입출력 예
a	b	result
5	24	TUE
*/

public class LevelTest5 {
	/* 수정본 */
	public String solution(int a, int b) {

		/* 입력받은 날짜 셋팅 */
		Calendar cal = Calendar.getInstance();
		cal.set(2016, a - 1, b);

		/* 요일 출력 */
		String answer = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("ko-KR"));

		return answer.toUpperCase();
	}

	/*나의 풀이
	 * public String solution(int a, int b) {
		String answer = "";

		 입력받은 날짜 셋팅
		Calendar cal = Calendar.getInstance();
		cal.set(2016, a - 1, b);

		int dayNum = cal.get(Calendar.DAY_OF_WEEK); // 요일을 구해온다.

		switch (dayNum) {
		case 1:
			answer = "SUN";
			break;
		case 2:
			answer = "MON";
			break;
		case 3:
			answer = "TUE";
			break;
		case 4:
			answer = "WED";
			break;
		case 5:
			answer = "THU";
			break;
		case 6:
			answer = "FRI";
			break;
		case 7:
			answer = "SAT";
			break;
		}

		return answer;
	}*/
}
