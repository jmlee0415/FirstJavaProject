package burger.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Milkshake {
	private String milkshakeName; // 객체 생성시에 객체의 실제 메모리 내부에 생성 및 구성 -> 멤버 변수
	private int price;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[밀크쉐이크명]");
		builder.append(milkshakeName);
		builder.append(", [단일가]");
		builder.append(price + "원");
		return builder.toString();
	}
}
