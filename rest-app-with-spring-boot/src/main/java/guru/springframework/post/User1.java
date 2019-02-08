package guru.springframework.post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class User1 {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private Date birthdate;
	
    @OneToMany(mappedBy="user")
	private List<Post> posts=new ArrayList<Post>();
    
    
	public User1(Integer id, String name, Date birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}

	public User1() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User1 [id=" + id + ", name=" + name + ", birthdate=" + birthdate + ", posts=" + posts + "]";
	}
	
	
}
