package guru.springframework.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//whats is rest  -> rest is style  of How to create rest and how to expose resouces using http 

@RestController // this restController handle the all the Rest Request
public class HelloWord {

	@Autowired
	private MessageSource messageSourcs;
	
	@GetMapping
	@RequestMapping(value = "/hello")
	public String helloWord() {
		return "Hello World Bro";
	}
	@GetMapping
	@RequestMapping(value = "/hello-bean")
	public HelloWoldBean helloWordBean() {
		return new HelloWoldBean("Hello World Bro changed");
	}
	
	@GetMapping
	@RequestMapping(value = "/hello/{name}")
	public HelloWoldBean helloWordPath(@PathVariable("name") String name) {
		return new HelloWoldBean(String.format("Hello World Bro changed ,%s",name));
	}
	
	@GetMapping
	@RequestMapping(value = "/hello-internal")
	public String helloWordInternationlization(@RequestHeader(value="Accept-Language", required=false) Locale locale) {
		return messageSourcs.getMessage("good.moring.messages",null, locale);
	}
}
