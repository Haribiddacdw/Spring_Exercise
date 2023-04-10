package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/users")
/**
* The class User controller
*/ 
public class UserController {
	
	/** 
	 * User one
	 */
	@RequestMapping(value = "1", method = RequestMethod.GET)
	public void userOne()
	{
		System.out.println("I'm User One");
	}
	
	/** 
	 * User two
	 * @return String
	 */
	@RequestMapping(value = "2",method = RequestMethod.GET)
	public String userTwo()
	{
		return "I'm User Two";
	}
	
	/** 
	 * User three
	 * @return ResponseEntity<String>
	 */
	@RequestMapping(value = "3",method = RequestMethod.GET)
	public ResponseEntity<String> userThree()
	{
		return ResponseEntity.ok("Hello I'm User Three");
	}
	
	/** 
	 * User four
	 * @return ModelAndView
	 */
	@RequestMapping(value = "4",method = RequestMethod.GET)
	public ModelAndView userFour()
	{
		ModelAndView mandv = new ModelAndView();
		mandv.addObject("usermessage", "Hello I'm User Four");
		mandv.setViewName("userPage");
		return mandv;
	}
	
	/** 
	 * User five
	 * @param mandv  the mandv. 
	 * @return ModelAndView
	 */
	@RequestMapping(value = "5",method = RequestMethod.GET)
	public ModelAndView userFive(ModelAndView mandv)
	{
		mandv.addObject("usermessage", "Hello I'm User Five");
		mandv.setViewName("userPage");
		return mandv;
	}
	
	/**
	 * User six
	 * @param mandv  the mandv. 
	 * @param request  the request. 
	 * @return ModelAndView
	 */
	@RequestMapping(value = "6",method = RequestMethod.GET)
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
	
	/** 
	 * User identifier
	 * @param name  the name.  It is PathVariable 
	 * @param mandv  the mandv. 
	 * @return ModelAndView
	 */
	@RequestMapping(value = "{id}/{name}", method = RequestMethod.GET)
	public ModelAndView userId(@PathVariable String id,@PathVariable String name,ModelAndView mandv) {
		
		mandv.addObject("userid",id);
		mandv.addObject("username",name);
		mandv.setViewName("userDetail");
		return mandv;
	}
	
	/** 
	 * User identifier
	 * @param uname  the username.  It is PathVariable 
	 * @param mandv  the mandv. 
	 * @return ModelAndView
	 */
	@RequestMapping(value = "8", method = RequestMethod.GET)
	public ModelAndView userEight(@RequestParam("uname") String name,ModelAndView mandv) {
		mandv.addObject("userid",8);
		mandv.addObject("username",name);
		mandv.setViewName("userDetail");
		return mandv;
	}
	
	
	/** 
	 * User Nine
	 * return User Object it will displayed as JSON
	 * @return ResponseEntity<String>
	 */
	@RequestMapping(value ="9",method = RequestMethod.GET)
	public ResponseEntity<User> userNine()
	{
		User user= new User();
		user.setUid(9);
		user.setUname("BIDDA");
		return ResponseEntity.ok(user);
	}
	
	/** 
	 * User10
	 * Passing User Object in Body as JSON 
	 * Here we updating those values and return that object
	 * @return ResponseEntity<String>
	 */
	@RequestMapping(value="10",method = RequestMethod.POST)
	public ResponseEntity<User> userTen(@RequestBody User user)
	{
		user.setUid(10);
		user.setUname("BIDDAHARI");
		return ResponseEntity.ok(user);
	}
	
	/** 
	 * User11 
	 * @return User Object
	 */
	@RequestMapping(value="11",method = RequestMethod.POST)
	public User userElevan(@RequestBody User user)
	{
		return user;
	}
	
}