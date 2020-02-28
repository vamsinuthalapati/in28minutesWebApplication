package com.in28minutes.jee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@Autowired
	LoginService service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	// @ResponseBody
	public String showLogin() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	// @ResponseBody
	public String handleRequestLogin(@RequestParam String name, ModelMap model, @RequestParam String password) {

		boolean find = service.validateUser(name, password);

		if (find) {
			model.put("name", name);
			model.put("password", password);

			return "welcome";
		} else {
			model.put("errorMessage", "Invalid Credentials!!");
			return "login";
		}

	}
}
