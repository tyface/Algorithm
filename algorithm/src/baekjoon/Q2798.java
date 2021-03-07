package baekjoon;
/*
일곱난쟁이

문제 https://www.acmicpc.net/problem/2309
왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.

아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.

아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.

입력
아홉 개의 줄에 걸쳐 난쟁이들의 키가 주어진다. 주어지는 키는 100을 넘지 않는 자연수이며, 아홉 난쟁이의 키는 모두 다르며, 가능한 정답이 여러 가지인 경우에는 아무거나 출력한다.

출력
일곱 난쟁이의 키를 오름차순으로 출력한다. 일곱 난쟁이를 찾을 수 없는 경우는 없다.

 * */

import java.io.*;
import java.util.*;

public class Q2798 {
	static int SEVEN_SUM = 100;			// 일곱 난쟁이들의 키의 합
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	    List<Integer> tallList = new ArrayList<Integer>();	// 난쟁이 9명의 키 리스트
	    int tallSum = 0;								  	// 난쟁이들의 키의 합
	    
	    for (int i = 0; i < 9; i++) {			// 난쟁이들의 키 입력받기
	    	int inputInt = Integer.parseInt(bf.readLine()); 
	    	tallList.add(inputInt);
			tallSum += inputInt;  
		}
	    
	    int remainder = tallSum - SEVEN_SUM;				// 전체의 합중 일곱난쟁이의 키의합을 뺀 나머지
	    
	    label:
	    for (int i = 0; i < tallList.size() - 1; i++) {
	    	for (int j = i + 1; j < tallList.size(); j++) {
	    		// 9명 전체의 키의 합중 2명의 키의 합을 뺏을때 SEVEN_SUM 과 같은경우 탐색 종료
	    		if(remainder == tallList.get(i) + tallList.get(j)) {
	    			tallList.remove(j);
	    			tallList.remove(i);
	    			break label;
	    		}
			}
		}
	    
	    tallList.sort(null);	// 오름차순 정렬
	    
	    // 정답 출력
	    for (int i = 0; i < tallList.size(); i++) {
	    		System.out.println(tallList.get(i));
		}
	}
}
