package baekjoon;

/*
사탕게임

문제	https://www.acmicpc.net/problem/3085
상근이는 어렸을 적에 "봄보니 (Bomboni)" 게임을 즐겨했다.

가장 처음에 N×N크기에 사탕을 채워 놓는다. 사탕의 색은 모두 같지 않을 수도 있다. 상근이는 사탕의 색이 다른 인접한 두 칸을 고른다. 그 다음 고른 칸에 들어있는 사탕을 서로 교환한다. 이제, 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열)을 고른 다음 그 사탕을 모두 먹는다.

사탕이 채워진 상태가 주어졌을 때, 상근이가 먹을 수 있는 사탕의 최대 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 보드의 크기 N이 주어진다. (3 ≤ N ≤ 50)

다음 N개 줄에는 보드에 채워져 있는 사탕의 색상이 주어진다. 빨간색은 C, 파란색은 P, 초록색은 Z, 노란색은 Y로 주어진다.

사탕의 색이 다른 인접한 두 칸이 존재하는 입력만 주어진다.

출력
첫째 줄에 상근이가 먹을 수 있는 사탕의 최대 개수를 출력한다.

 * */

import java.io.*;

public class Q3085 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());	// 보드판의 사이즈
		char[][] candyArr = new char[n][n];		    // 사탕 배열
		int result = 1;								    // 결과
		
		// 보드판의 색깔 입력받기
		for (int i = 0; i < n; i++) {				
			candyArr[i] = bf.readLine().toCharArray();
		}
		
		/* 
		 * 가로세로 n 크기의 보드판(candyArr)에 가로와 새로 방향으로 
		 *  두개의 캔디교환을 모든 경우의 수 실행
		 */ 
	    for (int i = 0; i < n; i++) {
	    	char[][] tempArr;
	    	int maxCnt1;
	    	int maxCnt2;
	    	int maxCnt3;
	    	
	    	
	    	for (int j = 0; j < n - 1; j++) {
	    		tempArr = changeCandy(candyArr, i, j, 'h');	// 가로방향 사탕 바꾸기
	    		maxCnt1 = hMaxCount(tempArr, i);			// 가로열 최대 개수 카운트 
	    		maxCnt2 = vMaxCount(tempArr, j);			// 세로행 최대 개수 카운트
	    		maxCnt3 = vMaxCount(tempArr, j + 1);		// 세로행 최대 개수 카운트
	    		
	    		result = Math.max(result, maxCnt1);
	    		result = Math.max(result, maxCnt2);
	    		result = Math.max(result, maxCnt3);
			}
	    	
	    	for (int j = 0; j < n - 1; j++) {
		    	tempArr = changeCandy(candyArr, i, j,'v');	// 세로방향 사탕 바꾸기
		    	maxCnt1 = vMaxCount(tempArr, i);			// 세로열 최대 개수 카운트 
	    		maxCnt2 = hMaxCount(tempArr, j);			// 가로행 최대 개수 카운트
	    		maxCnt3 = hMaxCount(tempArr, j + 1);		// 가로행 최대 개수 카운트
		    	
	    		result = Math.max(result, maxCnt1);
	    		result = Math.max(result, maxCnt2);
	    		result = Math.max(result, maxCnt3);
			}
	    	
		}
	    
	    System.out.println(result);								// 정답출력
	}
	
	// 가로열 최대값 출력
	public static int hMaxCount(char[][] cahrArr, int i) {
		int result = 1;				// 최대값
		char compareChar = 0;		// 임시 문자열 저장 변수

		int maxCnt = 1;			// 임시 최대값 저장 변수
		compareChar = cahrArr[i][0];
		
		for (int j = 1; j < cahrArr[i].length; j++) {	// 가로열 탐색
			char tempChar = cahrArr[i][j];
			
			if(compareChar == tempChar) {	// 문자가 같은경우
				maxCnt++;
			} else {						// 문자가 다를경우
				compareChar = tempChar;
				maxCnt = 1;
			}
			
			result = Math.max(result, maxCnt);
		}
		
		return result;
	}
	
	// 세로행 최대값 출력
	public static int vMaxCount(char[][] cahrArr, int i) {
		int result = 1;				// 최대값
		char compareChar = 0;		// 임시 문자열 저장 변수

		int maxCnt = 1;			// 임시 최대값 저장 변수
		compareChar = cahrArr[0][i];
		
		for (int j = 1; j < cahrArr[0].length; j++) {	// 가로열 탐색
			char tempChar = cahrArr[j][i];
			
			if(compareChar == tempChar) {	// 문자가 같은경우
				maxCnt++;
			} else {						// 문자가 다를경우
				compareChar = tempChar;
				maxCnt = 1;
			}
			
			result = Math.max(result, maxCnt);
		}
		
		return result;
	}
		
	// 인접해있는 사탕의 위치 바꾸기 
	public static char[][] changeCandy(char[][] cahrArr, int i, int j, char changeType) {
		char[][] tempArr = new char[cahrArr.length][cahrArr[0].length];
		char tempChar;
		
		//이중배열 복사
	    for (int k = 0; k < cahrArr.length; k++) {
	        System.arraycopy(cahrArr[k], 0, tempArr[k], 0, cahrArr[k].length);
	    }
	    
		switch (changeType) {	// changeType: h 가로, v 세로
		case 'h':
		case 'H':
			tempChar = tempArr[i][j];
			tempArr[i][j] = tempArr[i][j + 1];
			tempArr[i][j + 1] = tempChar;
			break;
		case 'v':
		case 'V':
			tempChar = tempArr[j][i];
			tempArr[j][i] = tempArr[j + 1][i];
			tempArr[j + 1][i] = tempChar;
			break;
		default:
			break;
		}
		
		return tempArr;
	}
}
