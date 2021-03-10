package burger.view;

import java.util.ArrayList;

import burger.model.dto.Feelings;

public class EndView {

	public static void invalidateReq(String message) {
		System.out.println("발생된 문제: " + message);
	}

	public static void validateReq(String message) {
		System.out.println("정상 실행: " + message);
	}

	public static void viewFeeling(Feelings feelings) {
		System.out.println("지금 당신의 기분: \n" + feelings);
	}

	public static void viewAllFeelings(ArrayList<Feelings> feelingsList) {
		System.out.println("당신에게 추천할 버거");
		for (Feelings v : feelingsList) {
			System.out.println(v);
		}
	}
	
	//Text 애니메이션 효과
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