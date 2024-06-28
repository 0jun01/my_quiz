package com.tenco.quiz.ver2;

import java.sql.SQLException;

public class MainTest1 {

	public static void main(String[] args) {

		QuizRepositoryImpl quizRepositoryImpl = new QuizRepositoryImpl();
		try {
//			List<QuizDTO> dtos = quizRepositoryImpl.viewQuizQuestion();
//			for (QuizDTO quizDTO : dtos) {
//				System.out.println(quizDTO);
//			}
			QuizDTO dto = quizRepositoryImpl.playQuizGame();
			System.out.println(dto);
			
			System.out.println("정답을 맞춰 주세요!");
			System.out.println(dto.getQuestion());
			String userInput = "지구";
			if(dto.getAnswer().equalsIgnoreCase(userInput)) {
				System.out.println("정답이디");
			} else {
				System.out.println("틀렸다고");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
