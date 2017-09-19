package com.demo.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import com.demo.model.Account;
import com.demo.userdao.AccountDAO;

@Controller

public class LoginController {
	@RequestMapping(value="/loginPage")
	public String loginAccount(HttpServletRequest request, HttpServletResponse response,@Valid @ModelAttribute ("loginAccount") Account account, BindingResult result) {
		System.out.println(result.toString());
		boolean login = false;
		HttpSession session = request.getSession();
		/*System.out.println((String)
				session.getAttribute("email"));
		System.out.println((String) session.getAttribute("password"));*/
		if(session.getAttribute("email") != null) {
			System.out.println((String)
					session.getAttribute("email"));
			System.out.println((String) session.getAttribute("password"));
			Account sessionAccount = new Account();
			account.setEmail( (String)
					session.getAttribute("email"));
			account.setPassword((String) session.getAttribute("password"));
			
			sessionAccount.setEmail((String)
					session.getAttribute("email"));
			sessionAccount.setPassword((String) session.getAttribute("password"));
			login = validateLogin(sessionAccount);
			
		}
		else {
			if(result.hasErrors()) {
				System.out.println("Form has Errors");
				
			}
			else {
				login = validateLogin(account);
			}
		}
		if(login) {
			session.setAttribute("email",account.getEmail());
			session.setAttribute("password",account.getPassword());
			return "UserPage";
		}
		else 
			return "loginPage";

	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("Check");
		HttpSession session = request.getSession();
		session.setAttribute("email",null);
		session.setAttribute("password", null);
		return "index";
	}
	
	private boolean validateLogin(Account account) {
		

		AccountDAO accountDao = new AccountDAO();
		Account accountLogin = accountDao.loginAccount(account);
		if (accountLogin != null) {
			System.out.println(accountLogin.toString());
		}
		if(accountLogin != null) {
			if(accountLogin.getPassword().equals(account.getPassword())){
				System.out.println("Login Successful");
				return true;
			}
			else {
				System.out.println("Wrong Password");
				return false;
			}
		}
		return false;
		
	}
	
	


}
