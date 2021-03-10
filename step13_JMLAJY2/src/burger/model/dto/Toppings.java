package burger.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Toppings {
	private String toppingsName; // 객체 생성시에 객체의 실제 메모리 내부에 생성 및 구성 -> 멤버 변수
	private int price;
	private String grade; // normal vs. premium

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[토핑명]");
		builder.append(toppingsName);
		builder.append(", [단일가]");
		builder.append(price + "원");
		builder.append(", [토핑등급]");
		builder.append(grade);
		return builder.toString();
}
}