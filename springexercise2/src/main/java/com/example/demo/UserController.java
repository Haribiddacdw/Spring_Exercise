package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@RequestMapping(value = "user1", method = RequestMethod.GET)
	public void userOne()
	{
		System.out.println("I'm User One");
	}
	
	@RequestMapping(value = "user2",method = RequestMethod.GET)
	public String userTwo()
	{
		return "I'm User Two";
	}
	
	@RequestMapping(value = "user3",method = RequestMethod.GET)
	public ResponseEntity<String> userThree()
	{
		return ResponseEntity.ok("Hello I'm User Three");
	}
	
	@RequestMapping(value = "user4",method = RequestMethod.GET)
	public ModelAndView userFour()
	{
		ModelAndView mandv = new ModelAndView();
		mandv.addObject("usermessage", "Hello I'm User Four");
		mandv.setViewName("userPage");
		return mandv;
	}
	
	@RequestMapping(value = "user5",method = RequestMethod.GET)
	public ModelAndView userFive(ModelAndView mandv)
	{
		mandv.addObject("usermessage", "Hello I'm User Five");
		mandv.setViewName("userPage");
		return mandv;
	}
	
	@RequestMapping(value = "user6",method = RequestMethod.GET)
	public ModelAndView userSix(ModelAndView mandv,HttpServletRequest request)
	{
		mandv.addObject("usermessage","Hello I'm User Six From MODEL AND VIEW");
		mandv.setViewName("userPage");
		HttpSession session = request.getSession();
		
		request.setAttribute("usermessage1", "Hello I'm User Six From Http Request Object");
		session.setAttribute("usermessage2", "Hello I'm User Six From session object");
		return mandv;
	}
	
	@RequestMapping(value = "repeat",method = RequestMethod.GET)
	public ModelAndView userSixRepeat(ModelAndView mandv,HttpServletRequest request)
	{
		mandv.addObject("usermessage","Hello I'm User Six From MODEL AND VIEW");
		mandv.setViewName("userPage");
		request.setAttribute("usermessage1", "Hello I'm User Six From Http Request Object");
		return mandv;
	}
	
	@RequestMapping(value = "user/{name}", method = RequestMethod.GET)
	public ModelAndView userId(@PathVariable String name,ModelAndView mandv) {
		
		mandv.addObject("usermessage",name);
		mandv.setViewName("userDetail");
		return mandv;
	}
	
	@RequestMapping(value = "user8", method = RequestMethod.GET)
	public ModelAndView userEight(@RequestParam("uname") String name,ModelAndView mandv) {
		mandv.addObject("usermessage",name);
		mandv.setViewName("userDetail");
		return mandv;
	}
	
	
	@RequestMapping(value ="user9",method = RequestMethod.GET)
	public ResponseEntity<User> userNine()
	{
		User user= new User();
		user.setUid(9);
		user.setUname("BIDDA");
		return ResponseEntity.ok(user);
	}
	
	@RequestMapping(value="user10",method = RequestMethod.POST)
	public ResponseEntity<User> userTen(@RequestBody User user)
	{
		user.setUid(10);
		user.setUname("BIDDAHARI");
		return ResponseEntity.ok(user);
	}
	
	@RequestMapping(value="user11",method = RequestMethod.POST)
	public User userElevan(@RequestBody User user)
	{
		return user;
	}
	
}