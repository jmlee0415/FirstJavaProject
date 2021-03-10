package burger.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Feelings { 
	private String feelingName;
	
	private String assignedburger;
	
	private Burger burger;
	
	private Toppings toppings;
	
	private Sidemenu sidemenu;
	
	private Milkshake milkshake;
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[������ ���]");
		builder.append(feelingName + "\n");
		builder.append("[��п� ���� ��õ ���� ��Ʈ]");
		builder.append(burger + "\n");
		builder.append("[�����߰�]");
		builder.append(toppings + "\n");
		builder.append("[���̵�]");
		builder.append(sidemenu + "\n");
		builder.append("[��ũ����ũ]");
		builder.append(milkshake + "\n");
		return builder.toString();
	}
}