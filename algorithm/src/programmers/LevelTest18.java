package programmers;

/*

시저 암호

문제 설명

어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
예를 들어 AB는 1만큼 밀면 BC가 되고, 3만큼 밀면 DE가 됩니다.
z는 1만큼 밀면 a가 됩니다. 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.

제한 조건

공백은 아무리 밀어도 공백입니다.
s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
s의 길이는 8000이하입니다.
n은 1 이상, 25이하인 자연수입니다.

입출력 예
s		n	result
AB		1	BC
z		1	a
a B z	4	e F d

*/

public class LevelTest18 {
	public static void main(String[] args) {
		solution("AZaz", 4);
	}
	
	static int ALPABET_COUNT = 26;	// 알파벳 개수
	
	public static String solution(String s, int n) {
		char[] arr = s.toCharArray();
		
		for (int i = 0; i < arr.length; i++) {
			if (Character.isLowerCase(arr[i])) {
				arr[i] = (char)((arr[i] - 'a' + n) % ALPABET_COUNT + 'a');
			} else if(Character.isUpperCase(arr[i])) {
				arr[i] = (char)((arr[i] - 'A' + n) % ALPABET_COUNT + 'A');
			}
		}
		
		return String.valueOf(arr);
	}
	
//	내소스	
//	static int CODE_A = 65;			// 알파벳 'A' 아스키코드
//	static int CODE_Z = 90;			// 알파벳 'Z' 아스키코드
//	static int CODE_a = 97;			// 알파벳 'a' 아스키코드
//	static int CODE_z = 122;		// 알파벳 'z' 아스키코드
//	static int ALPABET_COUNT = 26;	// 알파벳 개수
//	
//	public static String solution(String s, int n) {
//		char[] arr = s.toCharArray();
//		
//		// 아스키코드 65 ~ 90 , 97 ~ 122 사이의 문자에 변수 n을 더하는 공식
//		for (int i = 0; i < arr.length; i++) {
//			if (arr[i] >= CODE_a && arr[i] <= CODE_z) {
//				arr[i] = (char)((int)(arr[i] - CODE_a + n) % (ALPABET_COUNT) + CODE_a);
//			} else if(arr[i] >= CODE_A && arr[i] <= CODE_Z) {
//				arr[i] = (char)((int)(arr[i] - CODE_A + n) % (ALPABET_COUNT) + CODE_A);
//			}
//		}
//		
//		return String.valueOf(arr);
//	}
	
}
