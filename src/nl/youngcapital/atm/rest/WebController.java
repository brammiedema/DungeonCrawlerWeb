package nl.youngcapital.atm.rest;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
	
	@RequestMapping(value = "/index")
	public String getIndexPage(HttpSession session) {
		
		return "index";
	}
	
	@RequestMapping(value = "/")
	public String goToIndexPage(HttpSession session) {
		
		return "index";
	}
}
