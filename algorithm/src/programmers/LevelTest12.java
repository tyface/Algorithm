package programmers;

import java.util.Arrays;

/*

문자열 내림차순으로 배치하기

문제 설명
문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.

제한 사항
str은 길이 1 이상인 문자열입니다.

입출력 	예
s		return
Zbcdefg	gfedcbZ

*/

public class LevelTest12 {
	/* 수정본 */
	public String solution(String s) {
		char[] strArr = s.toCharArray();	// 입력받은 문자열을 1글자씩 배열로 생성

		Arrays.sort(strArr);				// 오름차순 정렬

		StringBuilder sb = new StringBuilder(new String(strArr));	// 문자 배열 이어붙이기

		// 문자 뒤집기 + 답안 작성
		String answer = sb.reverse().toString();

		return answer;
	}
	/*	내 풀이
  	public String solution(String s) {
		char[] strArr = s.toCharArray();	// 입력받은 문자열을 1글자씩 배열로 생성

		Arrays.sort(strArr);				// 오름차순 정렬

		StringBuilder sb = new StringBuilder();

		// 역방향 포문으로 내림차순으로 문자열 붙이기
		for (int i = strArr.length - 1; i >= 0; i--) {
			sb.append(strArr[i]);
		}

		// 정답 작성
		String answer = sb.toString();

		return answer;
	}
	*/
}
