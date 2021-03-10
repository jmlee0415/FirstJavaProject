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
		builder.append("[���Ÿ�]");
		builder.append(burgerName);
		builder.append(", [���ϰ�]");
		builder.append(price + "��");
		builder.append(", [�߰�����]");
		builder.append(burgerDetails);
		return builder.toString();
	}
}