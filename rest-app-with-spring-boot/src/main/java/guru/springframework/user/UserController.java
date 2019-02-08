package guru.springframework.user;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.annotation.DeterminableImports;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ch.qos.logback.core.status.Status;
import guru.springframework.exception.ExceptionResponse;

@RestController
public class UserController {
	@Autowired
	private UserServiceDao dao;

	@GetMapping
	@RequestMapping(value = "/users")
	public List<User> findAll() {
		return dao.findAll();
	}

	@GetMapping
	@RequestMapping("/users/{id}")
	public Resource<User> FindOne(@PathVariable("id") Integer id) {

		User user = dao.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("Id -> " + id);

		}

		//HATEOS
		
		Resource<User> resource=new Resource<User>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAll());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}

	@PostMapping
	@RequestMapping("/save")
	public ResponseEntity save(@Valid @RequestBody User user) {
		if (user.getName().length()<2) {
			throw new UserNotFoundException("Id -> " );

		}
		User saved = dao.save(user);
		// save/{id} ->user.getId();
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@SuppressWarnings("null")
	@RequestMapping("/delete/{id}")
	public ResponseEntity delete(@PathVariable("id") Integer id) {
		User deleted = dao.delete(id);

		if (deleted == null) {

			throw new UserDeleteNotFoundException("id --"+id);
		}

		return null;
	}
}
