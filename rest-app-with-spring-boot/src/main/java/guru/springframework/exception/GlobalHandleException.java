package guru.springframework.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import guru.springframework.user.NewExceptionResponse;
import guru.springframework.user.UserDeleteNotFoundException;

@ControllerAdvice
public class GlobalHandleException extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ExceptionResponse> handleUserNotFoundException(Exception ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_GATEWAY);
	}

	/*@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundEception(UserNotFoundException ue, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ue.getMessage(),
				"User Not Found Exception");
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}*/
	
	@ExceptionHandler(value=UserDeleteNotFoundException.class)
	public ResponseEntity<Object> handleUserDeleteNotFoundException(UserDeleteNotFoundException ex,WebRequest request){
		NewExceptionResponse newExceptionResponse = new NewExceptionResponse(new Date(),ex.getMessage(),"You provied Id Dont Found");
	return new ResponseEntity<Object>(newExceptionResponse,HttpStatus.BAD_REQUEST);
	
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
	ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(), ex.getBindingResult().toString());
		return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
	}


}

