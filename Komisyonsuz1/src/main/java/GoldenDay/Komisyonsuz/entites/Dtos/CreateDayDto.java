package GoldenDay.Komisyonsuz.entites.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDayDto {

	private int id;
	private Double Amount;
	private int month;
	private int UserQueu;
	
	
	private int UserId;
	private int PaymentId;
	
	
}
