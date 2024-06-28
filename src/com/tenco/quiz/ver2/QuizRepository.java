package com.tenco.quiz.ver2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public interface QuizRepository {

	int addQuizQuestion(String question, String answer) throws SQLException;

	// TODO 수정 예정
	List<QuizDTO> viewQuizQuestion() throws SQLException;

	QuizDTO playQuizGame() throws SQLException;
}
