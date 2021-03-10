package burger.view;

import java.util.ArrayList;

import burger.model.dto.Feelings;

public class EndView {

	public static void invalidateReq(String message) {
		System.out.println("�߻��� ����: " + message);
	}

	public static void validateReq(String message) {
		System.out.println("���� ����: " + message);
	}

	public static void viewFeeling(Feelings feelings) {
		System.out.println("���� ����� ���: \n" + feelings);
	}

	public static void viewAllFeelings(ArrayList<Feelings> feelingsList) {
		System.out.println("��ſ��� ��õ�� ����");
		for (Feelings v : feelingsList) {
			System.out.println(v);
		}
	}
	
	//Text �ִϸ��̼� ȿ��
	public static void messageView(String message) {
		String text = message;
		int i;
		for (i = 0; i < text.length(); i++) {
			System.out.printf("%c", text.charAt(i));
			try {
				Thread.sleep(90);// 0.5s pause between characters
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
	}

}