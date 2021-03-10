package burger.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Sidemenu {
	private String sidemenuName; // 객체 생성시에 객체의 실제 메모리 내부에 생성 및 구성 -> 멤버 변수
	private int price;
	private String type;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[사이드메뉴명]");
		builder.append(sidemenuName);
		builder.append(", [단일가]");
		builder.append(price + "원");
		builder.append(", [타입]");
		builder.append(type);
		return builder.toString();

	}
}
