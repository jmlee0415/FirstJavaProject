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
		builder.append("[고객님의 기분]");
		builder.append(feelingName + "\n");
		builder.append("[기분에 따른 추천 버거 세트]");
		builder.append(burger + "\n");
		builder.append("[토핑추가]");
		builder.append(toppings + "\n");
		builder.append("[사이드]");
		builder.append(sidemenu + "\n");
		builder.append("[밀크쉐이크]");
		builder.append(milkshake + "\n");
		return builder.toString();
	}
}