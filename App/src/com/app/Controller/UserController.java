package com.app.Controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.Util.CodeUtil;
import com.app.Util.CommonUtil;
import com.app.model.User;
import com.app.service.IUserService;

@Controller
public class UserController {
	@Autowired
	private IUserService service;
	@Autowired
	private CodeUtil codeUtil;
	@Autowired
	private CommonUtil commonUtil;
	
	//.1 show reg Page
	@RequestMapping("/regUser")
	public String showReg(){
		return "UserRegister";
	}
	
	//2. save user
	@RequestMapping(value="insertUser",method=POST)
	public String saveUser(@ModelAttribute("user")User user,ModelMap map){
		
		//generate pwd 
		String pwd=codeUtil.genpwd();
		//set to user
		user.setUserPwd(pwd);
		
		//save user
		int userId = service.saveUser(user);
		
		String message="User Registered with Id:"+userId;
		
		//send email
		String text="Welcome to VDM User '"+user.getUserName()+"'.User Id is : "+user.getUserEmail()+" (or) "+user.getUserContact()+
				                 " .. Password is : "+user.getUserPwd();
		
		boolean flag=commonUtil.sendEmail(user.getUserEmail(), "User Reg. Done..", text,null);

		if(flag)
			 message+=",Email also sent..";
		
		//send msg to UI
		map.addAttribute("msg", message);
		
		return "UserRegister";
	}
	@RequestMapping("/getAllusers")
	public String getData(ModelMap map){
		   List<User> users=service.getAllUsers();
		   map.addAttribute("users",users);
		   return "UserData";
	}
	@RequestMapping("deleteuser")
	public String delUser(@RequestParam("userId")int u){
		   service.deleteUser(u);
		   return "redirect:getAllusers";
	}
	@RequestMapping("edituser")
	public String showEdit(@RequestParam("userId")int userId,ModelMap map){
		   User it=service.getUserById(userId);
		   map.addAttribute("it",it);
		   return "UserDataEdit";
	}
	@RequestMapping(value="updateuser",method=RequestMethod.POST)
	public String updateUser(@ModelAttribute("User")User i){
		   service.updateUser(i);
		   return "redirect:getAllusers";
	}
	@RequestMapping(value="userpwd")
	public String userPwd(@ModelAttribute("user")User user,ModelMap map){
	/*	 //generate pwd 
		String pwd=codeUtil.genpwd();
		//set to user
				user.setUserPwd(pwd);
              service.updateUser(user); */
		
              String message="Reset User Password";
      		
      		//send email
      		String text=" User Id is : "+user.getUserEmail()
      				+" .. Password is : "+user.getUserPwd();
      		
      		boolean flag=commonUtil.sendEmail(user.getUserEmail(), "User Reg. Done..", text,null);

      		if(flag)
      			 message+=",Email also sent..";
      		
      		//send msg to UI
      		map.addAttribute("msg", message);

		return "Userpwd";
		
	}
	  //3. show log in page
	@RequestMapping("login")
	public String showLogin(){
		return "UserLogin";
	}
	//4. Do login process
	@RequestMapping(value="logincheck",method=POST)
	public String doLocationCheck(@RequestParam("un")String un,
			@RequestParam("pwd")String pwd,ModelMap map,
			HttpServletRequest req) {
		String page=null;
		User user=service.getUserByNameAndPwd(un,pwd);
		if(user==null){
			map.addAttribute("msg","Invalid UserName/Password..");
			page="UserLogin";
		}else{
			page="CustomerRegister";
			//create one http session
			HttpSession ses=req.getSession();
			ses.setAttribute("UserName",user.getUserName());
		}
		return page;
	}
	
	@RequestMapping("logout")
	public String doUserLogout(HttpServletRequest req,ModelMap map){
		HttpSession ses=req.getSession(false);
		ses.setAttribute("userName","userPwd");
		ses.invalidate();
		map.addAttribute("msg","Logout Success");
		return "UserLogin";
	}
	@RequestMapping("enterpwd")
	   public String changPwd(){
		   return "UserChangPwd";
	   }
	@RequestMapping("changpwd")
	public String changePwd(@ModelAttribute("User")User user,ModelMap map){
		String pwd=user.getUserPwd();
		if(pwd==null){
			map.addAttribute("msg","Invalid OldPassword..");
		}
		else{
			
			user.setUserPwd(pwd);
          service.updateUser(user);
		}
		return "UserChangPwd";
	}

}
