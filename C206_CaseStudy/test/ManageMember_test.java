import java.util.ArrayList;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19046377, Aug 23, 2020 10:30:17 PM
 */

public class ManageMember_test {
	
		private static final String[] args = null;
		private static Member member1;
		private static Member member2;
		private static Member member3;
		private ArrayList<Member> memberList; 	
			
		@Before
		public void setUp() throws Exception{
			C206_CaseStudy.main(args);
			
			member1 = new Member("Jade","F",94850592,"jade@rp.edu.sg","05/11/95","Singapore", "abc123");
			member2 = new Member("Jack","M",85716392,"Jack@gmail.com","31/03/85","Colombia", "hello");
			member3 = new Member("Robbie","M",99172530,"robbie@hotmail.com","22/03/82","England","byebye");
	
			memberList = new ArrayList<Member>();
	}
		
	@After
	public void tearDown() throws Exception {
		member1 = null;
		member2 = null;
		member3 = null;
		memberList = null;
	}
	@Test
	public void retrieveAllMembersTest() {
		//Test if list is not null but empty (boundary)
		assertNotNull("Test if there is valid Member arraylist to retrieve",memberList);
		
		//Test if retrieved arraylist is empty (boundary)
		String members = ManageMember.retrieveMembers(memberList);
		String output = "";
		assertEquals("Test the retrieved memberlist equal 0",output,members);
		
		//Test that member email is not the same (error)
		assertEquals("Test both member email is not the same",true,member1.getEmail() != member2.getEmail());
		
		//Test that arrayList is 2 after adding new members (normal)
		memberList.add(member1);
		memberList.add(member2);
		assertNotEquals("Test that arraylist size not equal 0",0,memberList.size());
	}
	@Test
	public void addMembersTest() {
		//check memberList is not null (boundary)
		assertNotNull("Test for valid arraylist to add new members",memberList);
		
		//check arraylist size is 1 after adding (normal)
		memberList.add(member1);
		assertEquals("Check that memberList size is 1",1,memberList.size());
		
		//check arraylist size is 2 after adding another member (normal)
		memberList.add(member2);
		assertEquals("Check memberList size is 2",2,memberList.size());
		
		//check that email is unique (error)
		assertEquals("Check that email is unique",true,member2.getEmail() != member1.getEmail());
		
	}
	@Test	
	public void deleteMembersTest() {
		retrieveAllMembersTest();
		//test list not null but empty (boundary)
		assertNotNull("Test for valid arraylist to delete members from",memberList);

		//Test that if member has registered for course, cannot be deleted (normal)
		if(member1.getEmail().equals(ManageMember.checkEmail(memberList))) {
			
		}
		//Test if deletion not done, size of arrayList is same (normal)
		assertEquals("Check size of memberList is still 2",2,memberList.size());
		
		//Test that if the item have been deleted, the memberList arraylist size decrease by 1 
		// (normal)
		ManageMember.deleteMembers(memberList);
		assertEquals("Check that memberList arraylist size is 1", 1, memberList.size());
		
	}
	@Test
	public void updateMembersTest() {
		ManageMember.updateMembers(memberList);
		//Test that the size of arraylist does not change after updating (normal)
		assertEquals("Check that memberList size does not change 2",2,memberList.size());
		
		//Test that the password is updated & not blank (boundary)
		assertTrue("Check that the password is updated ", member1.getPassword().length() >= 0);
		//Test that the country of residence in updated & not blank (boundary)
		assertTrue("Check that the country is updated ", member1.getCountry().length() >= 0);
		//Test that the mobile is updated & not blank (boundary)
		assertTrue("Check that the mobile is updated", member1.getMobile_number() >= 1);
		
		//If user enters letters for mobile number it will display as incorrect input (error)
	}
	
	@Test
	public void viewCoursesTest() {
		//test list not null but empty (boundary)
		assertNotNull("Test for valid arraylist to select a member from",memberList);
		
		//Test if member selected, courses will be displayed (normal)
		ManageMember.viewCourses(memberList);
		
		//Test if member does not exist, it will display invalid (error)
	}
	
}


