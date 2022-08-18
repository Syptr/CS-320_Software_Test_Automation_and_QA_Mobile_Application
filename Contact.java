/*
 * Project One
 * @author Sarah C Jodrey
 * CS-320:Software Test Automation & QA
 * @version August 7, 2022 
*/
package model;

public class Contact {
	
	//Initialize contact class variables
	private String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
		
	//Constructor
	public Contact(String contactID, String firstName, String lastName, String phone,String address) {
		//ContactID cannot be changed so it does not have a setter
		if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID, please try again.");
		}
		this.contactID = contactID;		
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setAddress(address);
	}
	
	//Getters to be accessed by other classes
	public String getContactID() {return contactID;}
	public String getFirstName() {return firstName;}	 
	public String getLastName() {return lastName;}	 
	public String getPhone() {return phone;}	 
	public String getAddress() {return address;}
	 
	/*Setters to be accessed by the ContactService class.
	 * Requirements for the variables will be verified and an exception will be thrown for each entry
	 * that does not meet the requirement.
	*/
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("A first name is required and cannot be more than 10 characters, please try again.");
		}
		this.firstName =  firstName;		
	} 
	
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("A last name is required and cannot be more than 10 characters, please try again.");
		}
		this.lastName = lastName;
	}
	
	public void setPhone(String phone) {
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("A phone number is required and must be 10 digits, please try again.");
		}
		this.phone = phone;
	}
	
	public void setAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("An address is required and cannot be more than 30 characters, please try again.");
		}
		this.address = address;
	}	

}
