package com.demo.model;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Email;

public class Account {

	    //@NotNull(message = "First name cannot be null")
	    @Size(min=1, max=15, message = "First namel")
		private String firstName;
		
		//@NotNull(message = "Last name cannot be null") 
		@Size(min=1, max=15)
		private String lastName;
		
		//@NotNull(message = "Address cannot be null") 
		@Size(min=1, max=100)
		private String address;
		
		//@NotNull(message = "Age cannot be null")
		@Min(value = 15, message = "Age should not be less than 15")
		private int age = 15;
		
		@Email(message = "Email cannot be null")
		//@NotNull @Size(min=1)
		private String email = null;
		
		@NotNull(message = "Please enter password") @Size(min=1)
		private String password = null;
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		@Override
		public String toString() {
			return "Account [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", age="
					+ age + ", email=" + email + ", password=" + password + "]";
		}
		
}
