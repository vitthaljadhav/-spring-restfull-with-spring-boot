package guru.springframework;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping("/")
	public ModelAndView doLogin() {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("name") String name,@RequestParam("pass") String pass) {
	if(name.equals("admin")&&(pass.equals("12345"))) {
		return new ModelAndView("success");
	}
	
		return new ModelAndView("fail");
	}
}
