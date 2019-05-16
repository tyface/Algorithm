package programmers;

import java.util.ArrayList;
import java.util.List;

/*
모의고사

문제 설명
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.

입출력 예
answers		return
[1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]

입출력 예 설명
입출력 예 #1

수포자 1은 모든 문제를 맞혔습니다.
수포자 2는 모든 문제를 틀렸습니다.
수포자 3은 모든 문제를 틀렸습니다.
따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.

입출력 예 #2

모든 사람이 2문제씩을 맞췄습니다.
 */
public class LevelTest2 {
	public int[] solution(int[] answers) {
		int[] answer = {};

		// 플레이어 리스트
		List<Player> playerList = new ArrayList<Player>();

		playerList.add(new Player(1, new int[]{1, 2, 3, 4, 5}, 0, 0));
		playerList.add(new Player(2, new int[]{2, 1, 2, 3, 2, 4, 2, 5}, 0, 0));
		playerList.add(new Player(3, new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}, 0, 0));

		Player temp; // 임시변수

		// 문제 횟수만큼 반복
		for(int i = 0;i < answers.length;i++) {
			// 수포자명 만큼 반복
			for(int j = 0;j < playerList.size();j++) {
				temp = playerList.get(j);	//Player 객체를 임시변수에 저장 (코딩 편의용)
				// 정답과 패턴의 답안 비교
				if(answers[i] == temp.pattern[i % temp.pattern.length]) {
					temp.point++;
				}
			}
		}

		int maxPoint = 0;

		List<Player> tempList = new ArrayList<Player>();

		for(int i = 0;i < playerList.size();i++) {
			if(maxPoint < playerList.get(i).point) {
				maxPoint = playerList.get(i).point;
			}
		}

		answer = new int[tempList.size()];

		int index = 0;

		for(Player p : tempList){

			answer[index++] = p.name;

		}

		return answer;
	}
}


class Player {
	int name;
	int[] pattern;
	int point;

	public Player(int name, int[] pattern, int point, int index) {
		this.name = name;
		this.pattern = pattern;
		this.point = point;
	}
}
