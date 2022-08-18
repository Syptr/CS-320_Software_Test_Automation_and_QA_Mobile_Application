/*
 * Project One
 * @author Sarah C Jodrey
 * CS-320:Software Test Automation & QA
 * @version August 7, 2022 
*/
package service;

import java.util.ArrayList;
import java.util.List;

import model.Contact;

public class ContactService {
	
	//Create a list to store contacts
	public static List<Contact> contactList = new ArrayList<Contact>(0);
	
	//The unique id is initialized with a 10 digit number
	private static long idCounter = 1000000001;
	
	
	//Generates a unique id for each contact
	public static synchronized String uniqueID() {
		return String.valueOf(idCounter++);		
	}
	
	//Add a new contact to the contact list
	public static void addContact(String firstName, String lastName, String phone, String address) {
		Contact newContact = new Contact(uniqueID(), firstName, lastName, phone, address);
		contactList.add(newContact);
	}
	
	//Locate the index of the unique ID in contact list for manipulation
	public static int locateContactID(String uniqueID) {
		int location = 0;
		for (int i = 0; i < contactList.size();i++) {
			if (uniqueID.equals(contactList.get(i).getContactID())) {
				location = i;
			}
		}		
		return location;
	}
	
	//Delete a contact from the contact list
	public static void deleteContact(String uniqueID) {
		contactList.remove(locateContactID(uniqueID));
	}
	
	
	//Modify contact first name with unique ID
	public static void updateFirstName(String uniqueID, String firstName) {
		contactList.get(locateContactID(uniqueID)).setFirstName(firstName);
	}
	
	//Modify contact last name with unique ID
	public static void updateLastName(String uniqueID, String lastName) {
		contactList.get(locateContactID(uniqueID)).setLastName(lastName);
	}
	
	//Modify contact phone with unique ID
	public static void updatePhone(String uniqueID, String phone) {
		contactList.get(locateContactID(uniqueID)).setPhone(phone);
	}
	
	//Modify contact address with unique ID
	public static void updateAddress(String uniqueID, String address) {
		contactList.get(locateContactID(uniqueID)).setAddress(address);		
	}
	
	

}
