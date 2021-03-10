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
	private String sidemenuName; // ��ü �����ÿ� ��ü�� ���� �޸� ���ο� ���� �� ���� -> ��� ����
	private int price;
	private String type;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[���̵�޴���]");
		builder.append(sidemenuName);
		builder.append(", [���ϰ�]");
		builder.append(price + "��");
		builder.append(", [Ÿ��]");
		builder.append(type);
		return builder.toString();

	}
}
