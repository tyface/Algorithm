package baekjoon;

/*
체스판 다시 칠하기

문제	https://www.acmicpc.net/problem/1018
지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M*N 크기의 보드를 찾았다. 어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다. 지민이는 이 보드를 잘라서 8*8 크기의 체스판으로 만들려고 한다.

체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다. 구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다. 따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다. 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.

보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8*8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다. 당연히 8*8 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 M이 주어진다. N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다. B는 검은색이며, W는 흰색이다.

출력
첫째 줄에 지민이가 다시 칠해야 하는 정사각형 개수의 최솟값을 출력한다.

 * */

import java.io.*;

public class Q1018 {
	final static int CHESS_SIZE = 8;					// 체스판 크기
	final static char BLACK = 'B';						// 검은색
	final static char WHITE = 'W';						// 흰색
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strs = bf.readLine().split(" ");
		int n = Integer.parseInt(strs[0]);			// 보드판의 가로 사이즈
		int m = Integer.parseInt(strs[1]);			// 보드판의 세로 사이즈
		char[][] boardArr = new char[n][m];		    // 보드판 배열
		int result = 64;							// 결과
		
		// 보드판의 색깔 입력받기
		for (int i = 0; i < n; i++) {				
			boardArr[i] = bf.readLine().toCharArray();
		}
		
		// 보드판 완전탐색
		char[][] tempArr = boardArr;
	    for (int i = 0; i < boardArr.length - CHESS_SIZE + 1; i++) {
	    	for (int j = 0; j < boardArr[i].length - CHESS_SIZE + 1; j++) {
	    		tempArr = cutBoard(boardArr, i, j);					// 보드판 자르기
	    		result = Math.min(result, chackCnt(tempArr));		// 가장 낮은 색칠횟수 구하기
			}
		}
	    
	    System.out.println(result);
	}
	
	// 보드판 자르기
	public static char[][] cutBoard(char[][] cahrArr, int x, int y) {
		char[][] tempArr = new char[CHESS_SIZE][CHESS_SIZE];
		
		for (int i = 0;i < tempArr.length; i++) {
			for (int j = 0;j < tempArr[i].length; j++) {
				tempArr[i][j] = cahrArr[i + x][j + y];
			}
		}
		
		return tempArr;
	}
	
	// 최대 색칠 개수 구하기
	public static int chackCnt(char[][] cahrArr) {
		int countB = 0;				// 좌측 상단이 B로 시작하는경우 카운트
		int countW = 0;				// 좌측 상단이 W로 시작하는경우 카운트
		boolean temp = true;		// 순서대로 바뀌는경우에 사용되는 임시변수 *코드를 줄이는 핵심키
		
		for (int i = 0;i < cahrArr.length; i++) {
			for (int j = 0;j < cahrArr[i].length; j++) {
				char tempChar = cahrArr[i][j];
				if(tempChar == BLACK == temp)countB++;
				if(tempChar == WHITE == temp)countW++;
				temp = !temp;
			}
			temp = !temp;
		}
		
		return Math.min(countB, countW);
	}
}
