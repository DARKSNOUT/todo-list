package com.harsh.springboot.Firstproject.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	
	// say_hello command
	@ResponseBody
	@RequestMapping("say-hello")
	public String hello() {
		return "Hello world!!!";
	}
	
	// say-hello-jsp-->sayHello.jsp
	
	@RequestMapping("say-hello-jsp")
	// /Firstproject/src/main/resources/META-INF/resource/WEB-INF/jsp/sayhello.jsp
	public String sayHelloJSP() {
		return "sayHello";
		//return the name of jsp here 
	}
	
	
}
