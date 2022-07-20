package GoldenDay.Komisyonsuz.entites.concretes;

import java.util.List; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name="CreateDay")

@JsonIgnoreProperties({"hibernateLazyInitializer","handler","user","payment"})
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","payment"})

public class CreateDay {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	
	@Column(name="amount")
	private Double Amount;
	
	@Column(name="month")
	private int month;
	
//	@Column(name="userId")
//	private int userId;
	
	@Column(name="userQueue")
	private int UserQueu;
	

	//@JsonIgnore()
	@OneToMany(mappedBy = "createDay")
	private List<Payment> payment;

//	@ManyToOne()
//	//@JsonIgnore()
//	@JoinColumn(name = "user_id")
//	private User user;


	@OneToMany(mappedBy = "createDay")
	private List<User> user;
}
