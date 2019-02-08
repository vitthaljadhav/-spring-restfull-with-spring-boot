package guru.springframework;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.bean.Employee;
@RestController
public class TestController {
	
	@PostMapping("/")
	public Employee beforeTest(@RequestBody Employee employee) {
		employee.setResponseCode("response Code");
		employee.setRequestCode("request Code");
		return employee;
	}

}
