package com.in28minutes.jee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@RequestMapping(value="/welcome")
	public String sayWelcome() {
		return "welcome";
	}
}
