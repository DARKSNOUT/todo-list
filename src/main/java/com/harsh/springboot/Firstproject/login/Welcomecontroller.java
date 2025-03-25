package com.harsh.springboot.Firstproject.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class Welcomecontroller {
	// removed the old authnetication meathod and added security dependendcy meathod 
	
	/*
	private AuthenticationService authenticationservice;

	public logincontroller(AuthenticationService authenticationservice) {
		super();
		this.authenticationservice = authenticationservice;
	}

	@RequestMapping(value="login",method=RequestMethod.GET)
	public String loginpage() {
		return "login";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String gowelcomepage(@RequestParam String password,@RequestParam String name, ModelMap model) {
			if(authenticationservice.authenticate(name,password)) {
				model.put("name", name);
				//model.put("password", password);
				return "welcome";
			}
			
			model.put("errormessage","Invalid Credintials ,please tr again");
			return "login";
	}*/
	
	//directly locating to the welcome page
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String GotoWelcomePage(ModelMap model) {
		model.put("name","harsh");
		return "welcome";
	}
}
