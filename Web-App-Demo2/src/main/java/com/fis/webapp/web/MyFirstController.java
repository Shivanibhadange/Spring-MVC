package com.fis.webapp.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fis.webapp.service.getNameDomain;

@Controller
public class MyFirstController {

	@Autowired
	getNameDomain ms;
	
	public MyFirstController() {
		super();
		System.out.println("Inside Web Controller - default constructor called ");
	}
	
	@RequestMapping("/")
	public String showHomePage()
	{
		return "homepage";
	}

	// ------------          request from client (done by post method)
	@RequestMapping(value = "/doProcessForm",method = RequestMethod.POST)
	public String doThings(HttpServletRequest req,Model model)
	{
		String email = req.getParameter("email");
		
		// business logic
	
		String result=ms.getName(email);
		String result2=ms.getDomain(email);
		
		
		
		
		System.out.println(" ---->> email "+email);
		System.out.println("username "+result);
		System.out.println("Domain "+result2);

		
		model.addAttribute("username","Ms."+result);
		model.addAttribute("Domain",result2);
		
		return "displayPage"; // response from Server
	}
	
}