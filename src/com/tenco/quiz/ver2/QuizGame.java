package com.tenco.quiz.ver2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.tenco.quiz.DBConnectionManager;

public class QuizGame {

	

	public static void main(String[] args) {

		try (Connection conn = DBConnectionManager.getConnection(); Scanner sc = new Scanner(System.in)) {

			while (true) {
				Printmenu();

				int choice = sc.nextInt(); // 블로킹
				if (choice == 1) {
					// 퀴즈 문제 추가 --> 함수로 만들기
					//addQuizQuestion(conn, sc);
				} else if (choice == 2) {
					// 퀴즈 문제 조회 --> 함수로 만들기
					//viewQuizQuestion(conn);
				} else if (choice == 3) {
					// 퀴즈 게임 시작 --> 함수로 만들기
					//playQuizGame(conn, sc);
				} else if (choice == 4) {
					System.out.println("프로그램을 종료합니다.");
					break;
				} else {
					System.out.println("다시 선택하세요?");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void Printmenu() {
		System.out.println();
		System.out.println("------------------------------------");
		System.out.println("1. 퀴즈 문제 추가");
		System.out.println("2. 퀴즈 문제 조회");
		System.out.println("3. 퀴즈 게임 시작");
		System.out.println("4. 종료");
		System.out.print("옵션을 선택 하세요 : ");
	} // end of main

//	private static void playQuizGame(Connection conn, Scanner sc) {
//
//		try (PreparedStatement psmt = conn.prepareStatement(RANDOM_QUIZ)) {
//			ResultSet rs = psmt.executeQuery();
//
//			if (rs.next()) {
//				String question = rs.getString("question");
//				String answer = rs.getString("answer");
//
//				System.out.println("퀴즈 문제 : " + question);
//				// 버그처리
//				sc.nextLine();
//				System.out.println("당신의 답: ");
//				String userAnswer = sc.nextLine();
//
//				if (userAnswer.equalsIgnoreCase(answer)) {
//					System.out.println("정답을 맞혔습니다. 점수 얻음");
//				} else {
//					System.out.println("틀렸는데?");
//					System.out.println("퀴즈 정답 : " + answer);
//				}
//			} else {
//				System.out.println("죄송합니다 아직 퀴즈 문제르 만들고 있습니다.");
//
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void viewQuizQuestion(Connection conn) {
//
//		try (PreparedStatement psmt = conn.prepareStatement(VIEW_QUIZ);) {
//
//			ResultSet resultSet = psmt.executeQuery();
//			while (resultSet.next()) {
//				System.out.println("문제 ID : " + resultSet.getInt("id"));
//				System.out.println("문제 : " + resultSet.getString("question"));
//				System.out.println("정답 : " + resultSet.getString("answer"));
//
//				if (!resultSet.isLast()) {
//					System.out.println("------------------------------------");
//				}
//				;
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	private static void addQuizQuestion(Connection conn, Scanner sc) {
//		System.out.println("퀴즈 문제를 입력하세요 : ");
//		sc.nextLine();
//		String question = sc.nextLine();
//		System.out.println("퀴즈 정답을 입력하세요 : ");
//		String answer = sc.nextLine();
//
//		try (PreparedStatement psmt = conn.prepareStatement(ADD_QUIZ);) {
//			psmt.setString(1, question);
//			psmt.setString(2, answer);
//
//			int rowInsertedCount = psmt.executeUpdate();
//			System.out.println("추가된 행의 수 : " + rowInsertedCount);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	// 퀴즈 추가 함수 만들기
	// 사용자 퀴즈와 답을 입력 받아야하 함
	// Connection 을 활용해서 query 날려야 한다.

} // end of class
