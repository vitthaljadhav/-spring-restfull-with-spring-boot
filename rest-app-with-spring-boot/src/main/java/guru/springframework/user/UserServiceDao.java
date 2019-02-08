package guru.springframework.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserServiceDao {

	int count=3;
	public static List<User> users=new ArrayList<>();
   static {
	   users.add(new User(1, "adam", new Date()));

	   users.add(new User(2, "james", new Date()));

	   users.add(new User(3, "todo", new Date()));
   }
    
  public List<User> findAll(){
	   return users;
   }
  
  public User save(User user) {
	  if(user.getId()==null) {
		  user.setId(++count);
	  }
	  users.add(user);
	  return user;
  }
  
  public User findOne(Integer id) {
	  for (User user : users) {
		if(user.getId()==id) {
			return user;
		}
	}
	  
	  return null;
  }
  
  public User delete(Integer id) {
	  for (User user : users) {
		if(user.getId()==id) {
			boolean removed = users.remove(user);
			return user;
		}
	}
	  return null;
  }
}
