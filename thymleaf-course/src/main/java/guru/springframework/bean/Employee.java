package guru.springframework.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class Employee implements Serializable{

	//@JsonProperty(value="student_id")
	private String id;
	
	private String empName;
	
	@JsonProperty(access=Access.WRITE_ONLY)
	private String description;

	@JsonProperty(access=Access.READ_ONLY)
	private String responseCode;
	
	@JsonProperty(access=Access.READ_ONLY)
	private String requestCode;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getRequestCode() {
		return requestCode;
	}

	public void setRequestCode(String requestCode) {
		this.requestCode = requestCode;
	}
	
}
