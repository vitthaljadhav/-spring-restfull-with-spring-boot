package guru.springframework.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

//@ApiModel(description="All Details About the User")
@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer Id;
	
	@Size(min=2,max=15,message="Name Sholud be min 2 characters")
	//@ApiModelProperty(notes="Name Should at least 2 Chracter")
	private String name;
	
	//@ApiModelProperty(notes="Birth Date should be in the post")
	@Past
	private Date birthdate;

	
	
	public User() {
		super();
	}

	public User(Integer id, String name, Date birthdate) {
		super();
		Id = id;
		this.name = name;
		this.birthdate = birthdate;
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", name=" + name + ", birthdate=" + birthdate + "]";
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	
	
}
