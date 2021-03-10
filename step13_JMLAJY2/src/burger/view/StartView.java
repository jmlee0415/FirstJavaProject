package burger.view;

import javax.swing.JOptionPane;

import burger.controller.FeelingsController;

public class StartView {
	public static void main(String[] args) {

		// CRUD 실행 여부 확인
//		System.out.println("\n-- 판매하는 모든 버거 --");
//		FeelingsController.reqProcess(1);
//
//		System.out.println("\n-- 버거 이름 업데이트 --");
//		FeelingsController.reqProcess(5);
//		System.out.println("\n-- 업데이트 한 후 버거 결과 --");
//		FeelingsController.reqProcess(1);
//
//		System.out.println("\n-- 버거 삭제 --");
//		FeelingsController.reqProcess(6);
//		System.out.println("\n-- 삭제 후 버거 결과 --");
//		FeelingsController.reqProcess(1);
//
//		System.out.println("\n-- 새로운 기분및 버거 세트 데이터 입력--");
//		FeelingsController.reqProcess(7);
//		System.out.println("\n-- 업데이트 한 후 버거 결과 --");
//		FeelingsController.reqProcess(1);

		// 메인 기능 구현
		System.out.println("\n-- 오늘의 당신의 기분에 추천할 버거세트 --");

		int i = 0; // iterator to be used later for the askQuestion loop
		String response = ""; // holds the answer the user supplied temporarily
		String response2 = "";

		String[][] question = new String[10][4]; // Array to store questions
//		ImageIcon icon = new ImageIcon("src/images/eT3NLcPB.jpg");
		question[0][0] = "오늘 기분이 어때요? A,B,C중 하나를 선택해주세요.";
		question[0][1] = "A. Happy:)";
		question[0][2] = "B. Angry!";
		question[0][3] = "C. Sad:(";

		response = askQuestion1(question[0]);
		if (response.equals("ABORT"))
			return;
		if (response.equals("a")) {
			FeelingsController.reqProcess(2);
			FeelingsController.reqProcess(8);
			JOptionPane.showMessageDialog(null, "고객님의 행복이 저의 행복입니다. 고객님께 담백한 버거 세트를 추천드립니다.");
			// return :
		} else if (response.equals("b")) {
			FeelingsController.reqProcess(3);
			FeelingsController.reqProcess(9);
			JOptionPane.showMessageDialog(null, "기분 나쁘시죠? 그럴땐 매운 버거죠! 고객님께 핵매운 버거 세트를 추천드립니다.");
			// return :
		} else if (response.equals("c")) {
			FeelingsController.reqProcess(4);
			FeelingsController.reqProcess(10);
			JOptionPane.showMessageDialog(null, "고객님이 슬프다니 저도 슬픕니다. 버거를 먹으면서 기분전환해요. 고객님께 달콤한 버거 세트를 추천드립니다.");
			// return:
		} else {
			JOptionPane.showMessageDialog(null, "Bye Bye");
		}

		question[1][0] = "주문하시겠습니까? A,B,C중 하나를 선택해주세요. ";
		question[1][1] = "A) Yes";
		question[1][2] = "B) No";
		question[1][3] = "C) Cancel";
		response2 = askQuestion2(question[1]);

		if (response2.equals("a")) {
			JOptionPane.showMessageDialog(null, "탁월한 선택이십니다.");
			// return :
		} else if (response2.equals("b")) {
			JOptionPane.showMessageDialog(null, "후회하실겁니다....");
			// return :
		}
	}

	private static String askQuestion1(String[] q) {
		String fmtQuestion = ""; // String to hold the formatted question
		String answer = "";

		for (int i = 0; i < q.length; i++)
			fmtQuestion += q[i] + "\n";

		do {
			answer = JOptionPane.showInputDialog(null, fmtQuestion);
			if (answer == null) {
				int quit = JOptionPane.showConfirmDialog(null, "정말로 끝내시겠습니까?", "종료", JOptionPane.YES_NO_OPTION);
				if (quit == 0) {
					answer = "ABORT";
					return answer;
				} else
					continue;
			}
		} while (answer == null || !(isValid(answer)));

		return answer;
	}

	private static String askQuestion2(String[] q) {
		String fmtQuestion = ""; // String to hold the formatted question
		String answer = "";

		for (int i = 0; i < q.length; i++)
			fmtQuestion += q[i] + "\n";

		do {
			answer = JOptionPane.showInputDialog(null, fmtQuestion);
			if (answer == null) {
				int quit = JOptionPane.showConfirmDialog(null, "정말로 끝내시겠습니까?", "종료", JOptionPane.YES_NO_OPTION);
				if (quit == 0) {
					answer = "ABORT";
					return answer;
				} else
					continue;
			}
		} while (answer == null || !(isValid(answer)));

		return answer;
	}

	private static boolean isValid(String a) {
		a = a.toLowerCase();
		if (a.equals("a") || a.equals("b") || a.equals("c")) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "A,B,C중 하나를 선택해주세요.");
			return false;
		}
	}

}
