package guru.springframework.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class UserDeleteNotFoundException extends RuntimeException {

	public UserDeleteNotFoundException(String message) {
		super(message);
	}

}
