package com.tenco.quiz.ver3;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class QuizRepositoryTest1 {

	public static void main(String[] args) {
		int score = 0;
		Scanner sc = new Scanner(System.in);
		// 메서드 호출해서 실행 확인 디버깅 확인 테스트 반드시 한다 !!
		// QuizRepository 구현 클래스 테스트
		QuizRepositoryImpl quizRepositoryImpl = new QuizRepositoryImpl();

		try {
			List<QuizDTO> dtos = quizRepositoryImpl.viewQuizQuestion();

			System.out.println("퀴즈 스타트");
			while (true) {
				QuizDTO dto = quizRepositoryImpl.playQuizGame();
				System.out.println(dto.getQuestion());
				String inputData = sc.nextLine();

				if (dto.getAnswer().equalsIgnoreCase(inputData)) {
					System.out.println("정답이디");
					score += 5;
					System.out.println("현재 점수 : " + score + "점");
					if (score == 100) {
						System.out.println("100점 달성!!!!!!");
						break;
					}
				} else {
					System.out.println("틀렸는데");
					score -= 5;
					System.out.println("현재 점수 : " + score + "점");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 실행에 흐름 직접 만들기
	}
}
