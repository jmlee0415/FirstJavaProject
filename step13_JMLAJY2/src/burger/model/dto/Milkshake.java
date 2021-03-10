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
	private String milkshakeName; // ��ü �����ÿ� ��ü�� ���� �޸� ���ο� ���� �� ���� -> ��� ����
	private int price;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[��ũ����ũ��]");
		builder.append(milkshakeName);
		builder.append(", [���ϰ�]");
		builder.append(price + "��");
		return builder.toString();
	}
}
