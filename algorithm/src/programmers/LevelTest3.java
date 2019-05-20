package programmers;

import java.util.Arrays;

/*
K번째수

문제 설명
배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
2에서 나온 배열의 3번째 숫자는 5입니다.
배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한사항
array의 길이는 1 이상 100 이하입니다.
array의 각 원소는 1 이상 100 이하입니다.
commands의 길이는 1 이상 50 이하입니다.
commands의 각 원소는 길이가 3입니다.

입출력 예
array					commands							return
[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]

입출력 예 설명
[1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.
[1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.
[1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.
*/

public class LevelTest3 {
	/* 수정 */
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];	// 정답 변수 초기화
		int[] rangeArr;								// 배열을 잘라내 담을 임시변수

		// command 케이스만큼 반복실행하는 반복문
		for (int i = 0; i < commands.length; i++) {
			int stNum = commands[i][0] - 1;		// 잘라낼 배열 시작 인덱스
			int endNum = commands[i][1] - 1;	// 잘라낼 배열 마지막 인덱스
			int findIndex = commands[i][2] - 1;	// 찾아낼 배열의 인덱스

			rangeArr = Arrays.copyOfRange(array, stNum, endNum + 1);	// 배열 잘라내기

			Arrays.sort(rangeArr);		// 배열 오름차순 정렬

			// n번째 값 찾아서 정답 배열에 입력
			for (int j = 0; j < rangeArr.length; j++) {
				if (j == findIndex) {
					answer[i] = rangeArr[j];
				}
			}
		}

		return answer;
	}

/*		내 풀이
 		public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length]; // 정답 변수 초기화
		int[] tempArr;	// 임시변수
		int index;		// tempArr에사용될 인덱스

		// command 케이스만큼 반복실행하는 반복문
		for (int i = 0; i < commands.length; i++) {
			int stNum = commands[i][0] - 1;		// 잘라낼 배열 시작 인덱스
			int endNum = commands[i][1] - 1;	// 잘라낼 배열 마지막 인덱스
			int findNum = commands[i][2] - 1;	// 찾아낼 배열의 인덱스

			tempArr = new int[commands[i][1] - commands[i][0] + 1];	// 변수 초기화
			index = 0;	// 인덱스 초기화

			// 배열 잘라내기
			for (int j = stNum; j <= endNum; j++) {
				tempArr[index] = array[j];
				index++;
			}

			// 배열 오름차순 정렬
			Arrays.sort(tempArr);

			// n번째 값 찾아서 정답 배열에 입력
			for (int j = 0; j < tempArr.length; j++) {
				if (j == findNum) {
					answer[i] = tempArr[j];
				}
			}
		}

		return answer;
	}
*/}
