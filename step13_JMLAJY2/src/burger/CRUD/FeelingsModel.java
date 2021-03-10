package burger.CRUD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateName;

import burger.model.BurgerModelVirtualDB;
import burger.model.dto.Burger;
import burger.model.dto.Feelings;

public class FeelingsModel {
//	private static FeelingsModel instance = new FeelingsModel();
	private BurgerModelVirtualDB data = BurgerModelVirtualDB.getInstance();
	// virtual ���� �ּҰ� ȣ�� ox

	public ArrayList<Feelings> getFeelingsList() {
		return data.getFeelingsList();
	}

	// ��� ��� �˻� - ��п� ���� ���� ���� ��ȯ Happy, Sad, Angry
	public Feelings getFeelings(String feelings) {
		ArrayList<Feelings> feelingsList = data.getFeelingsList();
		for (Feelings f : feelingsList) {
			if (f.getFeelingName().equals(feelings)) {
				return f;
			}
		}
		return null;
	}

	// ���� �̸����� �˻�
	public Burger getBurgers(String burgerName) {
		Burger burgerList = data.getFeelingsList().get(0).getBurger();
		List<Burger> burgerList2 = Arrays.asList(burgerList);
		for (Burger b : burgerList2) {
			if (b.getBurgerName().equals(burgerName)) {
				return b;
			}
		}
		return null;
	}

	// ���� ��Ʈ �� �հ� ���
	public void printSum(String feelings) {
		Feelings v = getFeelings(feelings);
		int s = 0;
		if (v != null) {
			int a = v.getBurger().getPrice();
			int b = v.getToppings().getPrice();
			int c = v.getSidemenu().getPrice();
			int d = v.getMilkshake().getPrice();
			s = a + b + c + d;
		}
		System.out.println(" " + s + "���Դϴ�.");
		System.out.println(" ���Ⱓ�̹Ƿ� 10% ������ �������� " + Math.round(s * 0.9) + "���Դϴ�.");
	}

	// ���ο� ��й� ���ż�Ʈ ������ �߰�
	public void feelingsInsert(Feelings newFeelings) throws DuplicateName {
		ArrayList<Feelings> feelingsList = data.getFeelingsList();
		Feelings feeling = getFeelings(newFeelings.getFeelingName());
		if (feeling == null)
			feelingsList.add(newFeelings);
		else {
			throw new DuplicateName("�ش� Feeling��� ������ �̸��� Feeling�� �̹� �����ϴ� ������ �߻��߽��ϴ�.");
		}
	}

	// ���ο� �����̸����� ������ ���� ������Ʈ
	public boolean burgerUpdate(String BurgerName, String newBurgerName) throws NoSuchElementException {
		boolean result = false;
		Burger b = getBurgers(BurgerName);
		if (b == null) {
			throw new NoSuchElementException("���� �̸��� ������Ʈ �ϰ��� �ϴ� ���Ű� �� �����ϴ� ������ �߻��߽��ϴ�.");
		} else {
			b.setBurgerName(newBurgerName);
			result = true;
		}
		return result;
	}

	// ���� ��� ������ ����
	public int delete(String feeling) {
		ArrayList<Feelings> feelingsList = data.getFeelingsList();
		int result = 0;
		Feelings v = getFeelings(feeling);
		if (v != null) {
			if (feelingsList.remove(v) == true) {
				result = 1;
			}
		}
		return result;
	}

}
