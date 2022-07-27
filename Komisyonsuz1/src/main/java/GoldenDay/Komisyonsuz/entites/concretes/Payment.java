package GoldenDay.Komisyonsuz.entites.concretes;

import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Payment")

public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
//	@Column(name="day_id")
//	private int dayId;
	
//	@Column(name="userId")
//	private int userİd;
	
	@Column(name="state")
	private Boolean state;

	@ManyToOne()
	//@JsonIgnore()
	@JoinColumn(name = "day_id")
	private CreateDay createDay;
	
	@ManyToOne()
	//@JsonIgnore()
	@JoinColumn(name = "user_id")
	private User user;
	
}
