package com.demo.controllers;



import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.model.Account;
import com.demo.userdao.AccountDAO;

@Controller
public class MyDemoController {
	
		@RequestMapping(value="/index")
		public void loadIndexPage() {
			
		}
		
		@RequestMapping(value="/createAccount")
		public String createAccount(@Valid @ModelAttribute ("aNewAccount") Account account, BindingResult result){
			System.out.println(result.toString());
			if(result.hasErrors()) {
				System.out.println("Form has Errors");
				return "createAccount"; 
			}
			else {
				AccountDAO accountDao = new AccountDAO();
				accountDao.insertAccount(account);				
			}
			return "createAccount";
		}
		
		@RequestMapping(value="/deleteAccount")
		public String deleteAccount(@Valid @ModelAttribute ("deleteAnAccount") Account account, BindingResult result) {
			System.out.println(result.toString());
			if(result.hasErrors()) {
				System.out.println("Form has Errors");
				return "deleteAccount";
			}
			else {
				AccountDAO accountDao = new AccountDAO();
				accountDao.deleteAccount(account);
				System.out.println("Account Deleted");
			}
			return "deleteAccount";
		}
		
		}
