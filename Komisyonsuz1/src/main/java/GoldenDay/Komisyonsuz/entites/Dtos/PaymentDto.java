package GoldenDay.Komisyonsuz.entites.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {

	private int id;
	private Boolean state;
	
	private int dayId;
	private int userİd;
}
