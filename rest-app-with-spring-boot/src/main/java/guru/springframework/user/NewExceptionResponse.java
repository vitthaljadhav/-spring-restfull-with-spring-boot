package guru.springframework.user;

import java.util.Date;

public class NewExceptionResponse {

	private Date date;
	
	private String message;
	
	private String descriptions;

	
	public NewExceptionResponse() {
		super();
	}


	public NewExceptionResponse(Date date, String message, String descriptions) {
		super();
		this.date = date;
		this.message = message;
		this.descriptions = descriptions;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getDescriptions() {
		return descriptions;
	}


	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	
}
