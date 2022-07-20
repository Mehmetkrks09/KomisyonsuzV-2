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
@Table(name="users")

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
//	
//	@Column(name="day_id")
//	private int dayId;
	
	@Column(name="name")
	private String  name;
	
	@Column(name="password")
	private String  password;
	
	@Column(name="surName")
	private String SurName;
	
	@Column(name="dateOfBirth")
	private String BirtOfDate;
	
	@Column(name="identityNumber")
	private String identityNumber;
	
	@Column(name="email")
	private String email;
	
	@Column(name="photo")
	private String Photo;
	
	@Column(name="adress")
	private String Adress;
	
//	@JsonIgnore()
//	@OneToMany(mappedBy = "user")
//	private List<CreateDay> createDay; 
	
	@JsonIgnore()
	@OneToMany(mappedBy = "user")
	private List<Payment> payment;
	
	@ManyToOne()
	//@JsonIgnore()
	@JoinColumn(name = "day_id")
	private CreateDay createDay;
	
}
