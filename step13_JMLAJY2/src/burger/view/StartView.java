package burger.view;

import javax.swing.JOptionPane;

import burger.controller.FeelingsController;

public class StartView {
	public static void main(String[] args) {

		// CRUD ���� ���� Ȯ��
//		System.out.println("\n-- �Ǹ��ϴ� ��� ���� --");
//		FeelingsController.reqProcess(1);
//
//		System.out.println("\n-- ���� �̸� ������Ʈ --");
//		FeelingsController.reqProcess(5);
//		System.out.println("\n-- ������Ʈ �� �� ���� ��� --");
//		FeelingsController.reqProcess(1);
//
//		System.out.println("\n-- ���� ���� --");
//		FeelingsController.reqProcess(6);
//		System.out.println("\n-- ���� �� ���� ��� --");
//		FeelingsController.reqProcess(1);
//
//		System.out.println("\n-- ���ο� ��й� ���� ��Ʈ ������ �Է�--");
//		FeelingsController.reqProcess(7);
//		System.out.println("\n-- ������Ʈ �� �� ���� ��� --");
//		FeelingsController.reqProcess(1);

		// ���� ��� ����
		System.out.println("\n-- ������ ����� ��п� ��õ�� ���ż�Ʈ --");

		int i = 0; // iterator to be used later for the askQuestion loop
		String response = ""; // holds the answer the user supplied temporarily
		String response2 = "";

		String[][] question = new String[10][4]; // Array to store questions
//		ImageIcon icon = new ImageIcon("src/images/eT3NLcPB.jpg");
		question[0][0] = "���� ����� ���? A,B,C�� �ϳ��� �������ּ���.";
		question[0][1] = "A. Happy:)";
		question[0][2] = "B. Angry!";
		question[0][3] = "C. Sad:(";

		response = askQuestion1(question[0]);
		if (response.equals("ABORT"))
			return;
		if (response.equals("a")) {
			FeelingsController.reqProcess(2);
			FeelingsController.reqProcess(8);
			JOptionPane.showMessageDialog(null, "������ �ູ�� ���� �ູ�Դϴ�. ���Բ� ����� ���� ��Ʈ�� ��õ�帳�ϴ�.");
			// return :
		} else if (response.equals("b")) {
			FeelingsController.reqProcess(3);
			FeelingsController.reqProcess(9);
			JOptionPane.showMessageDialog(null, "��� ���ڽ���? �׷��� �ſ� ������! ���Բ� �ٸſ� ���� ��Ʈ�� ��õ�帳�ϴ�.");
			// return :
		} else if (response.equals("c")) {
			FeelingsController.reqProcess(4);
			FeelingsController.reqProcess(10);
			JOptionPane.showMessageDialog(null, "������ �����ٴ� ���� ���Ŵϴ�. ���Ÿ� �����鼭 �����ȯ�ؿ�. ���Բ� ������ ���� ��Ʈ�� ��õ�帳�ϴ�.");
			// return:
		} else {
			JOptionPane.showMessageDialog(null, "Bye Bye");
		}

		question[1][0] = "�ֹ��Ͻðڽ��ϱ�? A,B,C�� �ϳ��� �������ּ���. ";
		question[1][1] = "A) Yes";
		question[1][2] = "B) No";
		question[1][3] = "C) Cancel";
		response2 = askQuestion2(question[1]);

		if (response2.equals("a")) {
			JOptionPane.showMessageDialog(null, "Ź���� �����̽ʴϴ�.");
			// return :
		} else if (response2.equals("b")) {
			JOptionPane.showMessageDialog(null, "��ȸ�Ͻǰ̴ϴ�....");
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
				int quit = JOptionPane.showConfirmDialog(null, "������ �����ðڽ��ϱ�?", "����", JOptionPane.YES_NO_OPTION);
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
				int quit = JOptionPane.showConfirmDialog(null, "������ �����ðڽ��ϱ�?", "����", JOptionPane.YES_NO_OPTION);
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
			JOptionPane.showMessageDialog(null, "A,B,C�� �ϳ��� �������ּ���.");
			return false;
		}
	}

}
