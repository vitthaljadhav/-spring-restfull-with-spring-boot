package guru.springframework.post;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import guru.springframework.user.User;
import guru.springframework.user.UserNotFoundException;

@RestController
public class UserJpaController {
	
	@Autowired
	private User1Repository userRepository;

	@Autowired
	private PostRepository postRepository;


	
	@GetMapping
	@RequestMapping(value = "/jpa/users")
	public List<User1> findAll() {
		return userRepository.findAll();
	}

	@GetMapping
	@RequestMapping("/jpa/users/{id}")
	public Resource<User1> FindOne(@PathVariable("id") Integer id) {

		User1 user = userRepository.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("Id -> " + id);

		}

		//HATEOS
		
		Resource<User1> resource=new Resource<User1>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAll());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}

	@PostMapping
	@RequestMapping("/jpa/save")
	public ResponseEntity save(@Valid @RequestBody User1 user) {
		if (user.getName().length()<2) {
			throw new UserNotFoundException("Id -> " );

		}
		User1 saved = userRepository.save(user);
		// save/{id} ->user.getId();
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/jpa/users/{id}")
	public ResponseEntity delete(@PathVariable("id") Integer id) {
		userRepository.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	@RequestMapping(value = "/jpa/users/{id}/posts")
	public List<Post> retriveAllPostOfSpecificUser(@PathVariable("id") Integer id) {
		
		User1 user = userRepository.findOne(id);
		if(user==null) {
			throw new UserNotFoundException(" id -> :"+id);
		}
	
		return user.getPosts();
	}
	
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity save(@Valid @PathVariable("id") int id, @RequestBody Post posts) {
		
		User1 user1 = userRepository.findOne(id);
		if(user1==null) {
			throw new UserNotFoundException(" id -> :"+id);
		}
		
		posts.setUser(user1);
		Post savedPosts = postRepository.save(posts);
	  
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPosts.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

}
