/* client�� 
 * 1. ���ý� ��� �� ����
 * 2. ���ý� �Ѹ��� �� ����
 * 3. ���� - ����
 * 4. ���� - ���� 
 * 5. ���� - ����
 */

package burger.controller;

import burger.CRUD.FeelingsModel;
import burger.model.dto.Burger;
import burger.model.dto.Feelings;
import burger.model.dto.Milkshake;
import burger.model.dto.Sidemenu;
import burger.model.dto.Toppings;
import burger.view.EndView;
import lombok.extern.slf4j.Slf4j;

@Slf4j

public class FeelingsController {
	private static FeelingsModel fm = new FeelingsModel();

	public static void reqProcess(int reqNo) {
		if (reqNo == 1) { // ��� �˻�
			EndView.viewAllFeelings(fm.getFeelingsList());
		} else if (reqNo == 2) { // Happy �˻�
			Feelings feeling = fm.getFeelings("Happy");
			if (feeling != null) {
				log.info("���� ����: Happy");
				EndView.messageView("������ ��п� �� �´� ���� ��Ʈ�� �����ϰ� �־��.\n");
				EndView.viewFeeling(feeling);
			} else {
				EndView.validateReq("������ �ɼǿ����� ������ �� �ֽ��ϴ�.");
				log.debug("���� �־��� �ɼǿ��� ���� ����");
			}
		} else if (reqNo == 3) { // Angry �˻�
			Feelings feeling = fm.getFeelings("Angry");
			if (feeling != null) {
				log.info("���� ����: Angry");
				EndView.messageView("������ ��п� �� �´� ���� ��Ʈ�� �����ϰ� �־��.\n");
				EndView.viewFeeling(feeling);
			} else {
				EndView.invalidateReq("������ �ɼǿ����� ������ �� �ֽ��ϴ�.");
				log.error("���� �־��� �ɼǿ��� ���� ����");
			}
		} else if (reqNo == 4) { // Sad �˻�
			Feelings feeling = fm.getFeelings("Sad");
			if (feeling != null) {
				log.info("���� ����: Sad");
				EndView.messageView("������ ��п� �� �´� ���� ��Ʈ�� �����ϰ� �־��.\n");
				EndView.viewFeeling(feeling);
			} else {
				EndView.invalidateReq("������ �ɼǿ����� ������ �� �ֽ��ϴ�.");
				log.error("���� �־��� �ɼǿ��� ���� ����");
			}
		} else if (reqNo == 5) { // ���� �̸� ������Ʈ
			boolean result = fm.burgerUpdate("Bacon Cheese Burger", "Cheese Burger");
			if (result == true) {
				log.info("Bacon Cheese Burger�� Cheese Burger�� ������");
				EndView.validateReq("���� �̸� ���� �Ϸ�");
			} else {
				EndView.invalidateReq("���� �̸��� �� �����ؼ� ���� ����");
				log.error("���� �̸� ������� ���� ����");
			}
		} else if (reqNo == 6) { // ��� ���� ���
			int result = fm.delete("Happy");
			if (result == 1) {
				EndView.validateReq("��� ���� �Ϸ�");
				log.info("Happy ��� ����");
			} else {
				EndView.invalidateReq("�����Ϸ��� ����� �����ϴ�");
				log.error("���� ��û�� ��� ������� ���� ����");
			}

		} else if (reqNo == 7) { // ���ο� ��� ������ �Է�
			try {
				fm.feelingsInsert(new Feelings("Gloomy", "Hello Burger",
						new Burger("Hell Poktan Burger", 100000, "This burger will make you forget everything else."),
						new Toppings("Hot Sauce", 1000, "premium"), new Sidemenu("Italian Sandwich", 10000, "Sandwich"),
						new Milkshake("Strawberry", 9800)));
				log.info("���ο� ��� Gloomy data ������Ʈ �Ϸ�");
				EndView.validateReq("���ο� ��й� ���� �޺���̼� ��� �Ϸ�");
			} catch (Exception e) {
				e.printStackTrace();
				EndView.invalidateReq("�ߺ� ���, �� �õ� �ϼ���");
				log.error("�ߺ��� ������ ������Ʈ �õ�");
			}
		} else if (reqNo == 8) { // ����� ���ż�Ʈ �� �հ� ���
			try {
				EndView.messageView("����� ���ż�Ʈ�� ");
				fm.printSum("Happy");
				EndView.validateReq("�հ谡 ���Ǿ����ϴ�.");
				log.info("����� ���ż�Ʈ �հ� ���Ϸ�.");
			} catch (Exception e) {
				e.printStackTrace();
				EndView.invalidateReq("��õ��ϼ���.");
				log.error("����� ���ż�Ʈ �հ� ��� ����");
			}
		} else if (reqNo == 9) { // �ٸſ� ���ż�Ʈ �� �հ� ���
			try {
				EndView.messageView("�ٸſ� ���ż�Ʈ�� ");
				fm.printSum("Angry");
				EndView.validateReq("�հ谡 ���Ǿ����ϴ�.");
				log.info("�ٸſ� ���ż�Ʈ �հ� ���Ϸ�.");
			} catch (Exception e) {
				e.printStackTrace();
				EndView.invalidateReq("��õ��ϼ���.");
				log.error("�ٸſ� ���ż�Ʈ �հ� ��� ����");
			}
		} else if (reqNo == 10) { // ������ ���ż�Ʈ �� �հ� ���
			try {
				EndView.messageView("������ ���ż�Ʈ�� ");
				fm.printSum("Sad");
				EndView.validateReq("�հ谡 ���Ǿ����ϴ�.");
				log.info("������ ���ż�Ʈ �հ� ���Ϸ�.");
			} catch (Exception e) {
				e.printStackTrace();
				EndView.invalidateReq("��õ��ϼ���.");
				log.error("������ ���ż�Ʈ �հ� ��� ����");
			}
		} else { // ��ó��
			EndView.invalidateReq("��û�� ���յǴ� ���񽺰� �����ϴ�.");
			log.info("�������� ���� ����");
		}
	}
}
