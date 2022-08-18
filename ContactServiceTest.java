/*
 * Project One - Test
 * @author Sarah C Jodrey
 * CS-320:Software Test Automation & QA
 * @version August 7, 2022
*/
package service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Contact;

class ContactServiceTest {
	
	//Initialize variables for testing
	private static String validFirstName, invalidFirstName;
	private static String validLastName, invalidLastName;
	private static String validPhone, invalidPhone;
	private static String validAddress, invalidAddress;	
	
	//Add contact information to the list for testing
	@BeforeAll
	 static void addTestContactsToList() {
		ContactService.addContact("Sarah", "Janeway", "7892567890", "1027 Quasar Drive");
		ContactService.addContact("Neelix", "Tuvix", "1234567891", "17 Illogical Lane");
		ContactService.addContact("Seven", "Ofnine", "3778904786", "10 Unimatrix Court");
		ContactService.addContact("Brent","Denteest", "4032456789", "34 Drag Drive");				
	}
	
	@BeforeEach
	void testingVariables() {
		validFirstName = "JeanLuc";
		invalidFirstName = "Chrysanthemum";
		validLastName = "Picard";
		invalidLastName = "Timetraveler";
		validPhone = "6031234567";
		invalidPhone = "6031234567891";
		validAddress = "18 Valid Lane";
		invalidAddress = "270965 Too Long For Requirement Lane";
	}
		
	//Confirm that contacts are added correctly
	@Test
	void testAddNewContact() {		
		assertTrue(ContactService.contactList.get(1).getContactID().equals("1000000002"));
		assertTrue(ContactService.contactList.get(1).getFirstName().equals("Neelix"));
		assertTrue(ContactService.contactList.get(1).getLastName().equals("Tuvix"));
		assertTrue(ContactService.contactList.get(1).getPhone().equals("1234567891"));
		assertTrue(ContactService.contactList.get(1).getAddress().equals("17 Illogical Lane"));		
	}
	
	//Confirm that each contact ID is in fact unique	
	@Test
	void testUniqueContactID() {
		for(int i = 1; i< ContactService.contactList.size();i++) {
			assertNotEquals(ContactService.contactList.get(0).getContactID(),
					ContactService.contactList.get(i).getContactID());
		}
	}
	
	//Test deleting a contact from the list with the unique ID
	@Test
	void testDeleteContact() {
		assertEquals("1000000003", ContactService.contactList.get(2).getContactID());
		ContactService.deleteContact("1000000003");
		assertEquals("1000000004",ContactService.contactList.get(2).getContactID());		
	}
		
	//Test update first name per contact ID
	@Test
	void testUpdateFirstName() {
		ContactService.updateFirstName("1000000001","Captain");
		assertTrue(ContactService.contactList.get(0).getFirstName().equals("Captain"));		
	}
	
	//Test update last name per contact ID
	@Test
	void testUpdateLastName() {
		ContactService.updateLastName("1000000001", "Kathryn");
		assertTrue(ContactService.contactList.get(0).getLastName().equals("Kathryn"));
	}
	
	//Test update phone per contact ID
	@Test
	void testUpdatePhone(){
		ContactService.updatePhone("1000000001", "6903354637");
		assertTrue(ContactService.contactList.get(0).getPhone().equals("6903354637"));
	}
	
	//Test update address per contact ID
	@Test
	void testUpdateAddress() {
		ContactService.updateAddress("100000001", "94 Starship Voyager");
		assertTrue(ContactService.contactList.get(0).getAddress().equals("94 Starship Voyager"));		
	}
	
	//Test invalid contact values for id, first name, last name, phone, and address
	@Test
	void testInvalidContactValues() {		
		
		assertAll("invalid contact values",
				() -> assertThrows(IllegalArgumentException.class, () -> new Contact(null, validFirstName, validLastName, validPhone, validAddress)),
				() -> assertThrows(IllegalArgumentException.class, () -> new Contact("123456789102", validFirstName,validLastName,validPhone,validAddress)),
				() -> assertThrows(IllegalArgumentException.class, () -> ContactService.addContact(null,null,null,null)),
				() -> assertThrows(IllegalArgumentException.class, () -> ContactService.addContact(invalidFirstName, validLastName, validPhone, validAddress)),
				() -> assertThrows(IllegalArgumentException.class, () -> ContactService.addContact(validFirstName, invalidLastName, validPhone, validAddress)),
				() -> assertThrows(IllegalArgumentException.class, () -> ContactService.addContact(validFirstName, validLastName, invalidPhone, validAddress)),
				() -> assertThrows(IllegalArgumentException.class, () -> ContactService.addContact(validFirstName, validLastName, validPhone, invalidAddress)));
	}

}
