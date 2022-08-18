/*
 * Project One - Test
 * @author Sarah C Jodrey
 * CS-320:Software Test Automation & QA
 * @version August 7, 2022 
*/
package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ContactTest {
	
	//Initialize testing variables
	private String validContactID, invalidContactID;
	private String validFirstName, invalidFirstName;
	private String validLastName, invalidLastName;
	private String validPhone, tooShortPhone, tooLongPhone;
	private String validAddress, invalidAddress;
	
	@BeforeEach
	void variablesForTestingContact() {
		validContactID = "1234567891";
		invalidContactID = "10000123456789";
		validFirstName = "Geordi";
		invalidFirstName = "Constantine";
		validLastName = "LaForge";
		invalidLastName = "Supermassive";
		validPhone = "7709872341";
		tooShortPhone = "603456";
		tooLongPhone = "60312345678910";
		validAddress = "1701 Enterprise Drive";
		invalidAddress = "19090 Youve Gone Too Long Boulevard";
	}
	
	//Test the contact class with all fields complete and requirements met.
	@Test	
	void testContact() {
		Contact contact = new Contact(validContactID,validFirstName,validLastName,validPhone,validAddress);
		assertTrue(contact.getContactID().equals(validContactID));
		assertTrue(contact.getFirstName().equals(validFirstName));
		assertTrue(contact.getLastName().equals(validLastName));
		assertTrue(contact.getPhone().equals(validPhone));
		assertTrue(contact.getAddress().equals(validAddress));			
	}
	
	//Test the contact class with all fields null
	@Test
	void testNullContact() {		
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(null,null,null,null,null));		
			
	}

	//Test for a valid contact ID
	@Test
	void testContactIDRequirements() {
		assertAll("invalid contact ID",
				() -> assertThrows(IllegalArgumentException.class, () -> new Contact(invalidContactID, validFirstName, validLastName, validPhone, validAddress)),
				() -> assertThrows(IllegalArgumentException.class, () -> new Contact(null, validFirstName, validLastName, validPhone, validAddress)));		
	}
	
	//Test for a valid first name
	@Test
	void testFirstNameRequirements() {
		assertAll("invalid first name",
				() -> assertThrows(IllegalArgumentException.class, () -> new Contact(validContactID, invalidFirstName, validLastName, validPhone, validAddress)),
				() -> assertThrows(IllegalArgumentException.class, () -> new Contact(validContactID, null, validLastName, validPhone, validAddress)));		
	}
	
	//Test for a valid last name
	@Test
	void testLastNameRequirements() {
		assertAll("invalid last name",
				() -> assertThrows(IllegalArgumentException.class, () -> new Contact(validContactID, validFirstName, invalidLastName, validPhone, validAddress)),
				() -> assertThrows(IllegalArgumentException.class, () -> new Contact(validContactID, validFirstName, null, validPhone, validAddress)));		
	}

	//Test for a valid phone 
	@Test
	void testPhoneRequirements() {
		assertAll("invalid phone number",
				() -> assertThrows(IllegalArgumentException.class, () -> new Contact(validContactID, validFirstName, validLastName, tooShortPhone, validAddress)),
				() -> assertThrows(IllegalArgumentException.class, () -> new Contact(validContactID, validFirstName, validLastName, tooLongPhone, validAddress)),
				() -> assertThrows(IllegalArgumentException.class, () -> new Contact(validContactID, validFirstName, validLastName, null, validAddress)));		
	}	
	
	//Test for a valid address
	@Test
	void testAddressRequirements() {
		assertAll("invalid address",
				() -> assertThrows(IllegalArgumentException.class, () -> new Contact(validContactID, validFirstName, validLastName, validPhone, invalidAddress)),
				() -> assertThrows(IllegalArgumentException.class, () -> new Contact(validContactID, validFirstName, validLastName, validPhone, null)));		
	}
		
}
