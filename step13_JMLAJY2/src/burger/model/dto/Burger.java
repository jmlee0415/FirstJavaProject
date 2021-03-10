package burger.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Burger { 
	private String burgerName; 
	private int price;
	private String burgerDetails;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[버거명]");
		builder.append(burgerName);
		builder.append(", [단일가]");
		builder.append(price + "원");
		builder.append(", [추가설명]");
		builder.append(burgerDetails);
		return builder.toString();
	}
}