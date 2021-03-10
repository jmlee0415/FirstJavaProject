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
	// virtual 에서 주소값 호출 ox

	public ArrayList<Feelings> getFeelingsList() {
		return data.getFeelingsList();
	}

	// 모든 기분 검색 - 기분에 따른 버거 정보 반환 Happy, Sad, Angry
	public Feelings getFeelings(String feelings) {
		ArrayList<Feelings> feelingsList = data.getFeelingsList();
		for (Feelings f : feelingsList) {
			if (f.getFeelingName().equals(feelings)) {
				return f;
			}
		}
		return null;
	}

	// 버거 이름으로 검색
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

	// 버거 세트 총 합계 계산
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
		System.out.println(" " + s + "원입니다.");
		System.out.println(" 행사기간이므로 10% 할인한 가격으로 " + Math.round(s * 0.9) + "원입니다.");
	}

	// 새로운 기분및 버거세트 데이터 추가
	public void feelingsInsert(Feelings newFeelings) throws DuplicateName {
		ArrayList<Feelings> feelingsList = data.getFeelingsList();
		Feelings feeling = getFeelings(newFeelings.getFeelingName());
		if (feeling == null)
			feelingsList.add(newFeelings);
		else {
			throw new DuplicateName("해당 Feeling명과 동일한 이름의 Feeling이 이미 존재하는 문제가 발생했습니다.");
		}
	}

	// 새로운 버거이름으로 기존의 버거 업데이트
	public boolean burgerUpdate(String BurgerName, String newBurgerName) throws NoSuchElementException {
		boolean result = false;
		Burger b = getBurgers(BurgerName);
		if (b == null) {
			throw new NoSuchElementException("버거 이름을 업데이트 하고자 하는 버거가 미 존재하는 문제가 발생했습니다.");
		} else {
			b.setBurgerName(newBurgerName);
			result = true;
		}
		return result;
	}

	// 기존 기분 데이터 삭제
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
