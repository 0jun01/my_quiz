package com.tenco.quiz.ver3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tenco.quiz.DBConnectionManager;

public class QuizRepositoryImpl implements QuizRepository {

	public static final String ADD_QUIZ = "  INSERT INTO quiz(question, answer) VALUES( ?,?) ";
	public static final String VIEW_QUIZ = "  SELECT * FROM quiz";
	public static final String RANDOM_QUIZ = " select * from quiz order by rand() limit 1 ";

	@Override
	public int addQuizQuestion(String question, String answer) throws SQLException {

		int resultRow = 0;

		try (Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement pstm = conn.prepareStatement(ADD_QUIZ);
			// 트랜잭션 처리 가능 - 수동 모드 커밋 사용 가능
			pstm.setString(1, question);
			pstm.setString(2, answer);
			pstm.executeUpdate();

		}
		return resultRow;
	}

	@Override
	public List<QuizDTO> viewQuizQuestion() throws SQLException {

		List<QuizDTO> list = new ArrayList<>();

		try (Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement psmt = conn.prepareStatement(VIEW_QUIZ);
			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String question = rs.getString("question");
				String answer = rs.getString("answer");

				list.add(new QuizDTO(id, question, answer));
			}
		}
		return list;
	}

	@Override
	public QuizDTO playQuizGame() throws SQLException {
		QuizDTO quizDTO = null;

		try (Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement psmt = conn.prepareStatement(RANDOM_QUIZ);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String question = rs.getString("question");
				String answer = rs.getString("answer");

				quizDTO = new QuizDTO(id, question, answer);
			}
		}

		return quizDTO;
	}

}
