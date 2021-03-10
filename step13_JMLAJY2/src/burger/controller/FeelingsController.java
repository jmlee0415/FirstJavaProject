/* client가 
 * 1. 선택시 모든 고객 보기
 * 2. 선택시 한명의 고객 보기
 * 3. 선택 - 수정
 * 4. 선택 - 삭제 
 * 5. 선택 - 저장
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
		if (reqNo == 1) { // 모든 검색
			EndView.viewAllFeelings(fm.getFeelingsList());
		} else if (reqNo == 2) { // Happy 검색
			Feelings feeling = fm.getFeelings("Happy");
			if (feeling != null) {
				log.info("고객의 선택: Happy");
				EndView.messageView("고객님의 기분에 딱 맞는 버거 세트를 생각하고 있어요.\n");
				EndView.viewFeeling(feeling);
			} else {
				EndView.validateReq("세가지 옵션에서만 선택할 수 있습니다.");
				log.debug("고객이 주어진 옵션에서 선택 오류");
			}
		} else if (reqNo == 3) { // Angry 검색
			Feelings feeling = fm.getFeelings("Angry");
			if (feeling != null) {
				log.info("고객의 선택: Angry");
				EndView.messageView("고객님의 기분에 딱 맞는 버거 세트를 생각하고 있어요.\n");
				EndView.viewFeeling(feeling);
			} else {
				EndView.invalidateReq("세가지 옵션에서만 선택할 수 있습니다.");
				log.error("고객이 주어진 옵션에서 선택 오류");
			}
		} else if (reqNo == 4) { // Sad 검색
			Feelings feeling = fm.getFeelings("Sad");
			if (feeling != null) {
				log.info("고객의 선택: Sad");
				EndView.messageView("고객님의 기분에 딱 맞는 버거 세트를 생각하고 있어요.\n");
				EndView.viewFeeling(feeling);
			} else {
				EndView.invalidateReq("세가지 옵션에서만 선택할 수 있습니다.");
				log.error("고객이 주어진 옵션에서 선택 오류");
			}
		} else if (reqNo == 5) { // 버거 이름 업데이트
			boolean result = fm.burgerUpdate("Bacon Cheese Burger", "Cheese Burger");
			if (result == true) {
				log.info("Bacon Cheese Burger가 Cheese Burger로 수정됨");
				EndView.validateReq("버거 이름 수정 완료");
			} else {
				EndView.invalidateReq("버거 이름이 미 존재해서 수정 실패");
				log.error("버거 이름 미존재로 수정 실패");
			}
		} else if (reqNo == 6) { // 기분 삭제 기능
			int result = fm.delete("Happy");
			if (result == 1) {
				EndView.validateReq("기분 삭제 완료");
				log.info("Happy 기분 삭제");
			} else {
				EndView.invalidateReq("삭제하려는 기분이 없습니다");
				log.error("삭제 요청한 기분 미존재로 삭제 실패");
			}

		} else if (reqNo == 7) { // 새로운 기분 데이터 입력
			try {
				fm.feelingsInsert(new Feelings("Gloomy", "Hello Burger",
						new Burger("Hell Poktan Burger", 100000, "This burger will make you forget everything else."),
						new Toppings("Hot Sauce", 1000, "premium"), new Sidemenu("Italian Sandwich", 10000, "Sandwich"),
						new Milkshake("Strawberry", 9800)));
				log.info("새로운 기분 Gloomy data 업데이트 완료");
				EndView.validateReq("새로운 기분및 버거 콤비네이션 등록 완료");
			} catch (Exception e) {
				e.printStackTrace();
				EndView.invalidateReq("중복 기분, 재 시도 하세요");
				log.error("중복된 데이터 업데이트 시도");
			}
		} else if (reqNo == 8) { // 담백한 버거세트 총 합계 계산
			try {
				EndView.messageView("담백한 버거세트는 ");
				fm.printSum("Happy");
				EndView.validateReq("합계가 계산되었습니다.");
				log.info("담백한 버거세트 합계 계산완료.");
			} catch (Exception e) {
				e.printStackTrace();
				EndView.invalidateReq("재시도하세요.");
				log.error("담백한 버거세트 합계 계산 실패");
			}
		} else if (reqNo == 9) { // 핵매운 버거세트 총 합계 계산
			try {
				EndView.messageView("핵매운 버거세트는 ");
				fm.printSum("Angry");
				EndView.validateReq("합계가 계산되었습니다.");
				log.info("핵매운 버거세트 합계 계산완료.");
			} catch (Exception e) {
				e.printStackTrace();
				EndView.invalidateReq("재시도하세요.");
				log.error("핵매운 버거세트 합계 계산 실패");
			}
		} else if (reqNo == 10) { // 달콤한 버거세트 총 합계 계산
			try {
				EndView.messageView("달콤한 버거세트는 ");
				fm.printSum("Sad");
				EndView.validateReq("합계가 계산되었습니다.");
				log.info("달콤한 버거세트 합계 계산완료.");
			} catch (Exception e) {
				e.printStackTrace();
				EndView.invalidateReq("재시도하세요.");
				log.error("달콤한 버거세트 합계 계산 실패");
			}
		} else { // 잔처리
			EndView.invalidateReq("요청에 부합되는 서비스가 없습니다.");
			log.info("선택지중 선택 안함");
		}
	}
}
