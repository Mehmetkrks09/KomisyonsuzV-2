package GoldenDay.Komisyonsuz.entites.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	
	private int id;
	private String  name;
	private String  password;
	private String surName;
	private String birtOfDate;
	private String identityNumber;
	private String email;
	private String Photo;
	private String Adress;
	private int dayId;
	private int paymentId;
}
