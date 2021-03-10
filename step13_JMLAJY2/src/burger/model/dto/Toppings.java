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
	private String toppingsName; // ��ü �����ÿ� ��ü�� ���� �޸� ���ο� ���� �� ���� -> ��� ����
	private int price;
	private String grade; // normal vs. premium

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[���θ�]");
		builder.append(toppingsName);
		builder.append(", [���ϰ�]");
		builder.append(price + "��");
		builder.append(", [���ε��]");
		builder.append(grade);
		return builder.toString();
}
}