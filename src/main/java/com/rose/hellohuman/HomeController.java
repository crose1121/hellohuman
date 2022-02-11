package com.rose.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping("/")
	public String hello(@RequestParam(value="firstname", required=false)String firstname,@RequestParam(value="lastname", required=false)String lastname,@RequestParam(value="times", required=false)String times) {
		if (firstname==null && lastname==null && times==null) {			
			return "Hello Human.";		
		}
		else if (firstname!=null && lastname==null) {
			return "Hello " + firstname;
		}
		else if (firstname==null && lastname!=null) {
			return "Hello Mr. " + lastname;
		}
		else if (firstname!=null && lastname!=null && times==null){
			return String.format("Hello, %s %s",firstname,lastname);
		}
		else {
			String message = "";
			int loops = Integer.parseInt(times);
			
			for (int i=0;i<=loops;i++) {
				message += (" hello "+firstname+" "+lastname);
			}
			return message;
		}	
	}
}