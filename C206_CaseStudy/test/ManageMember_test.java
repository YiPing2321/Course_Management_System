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

		private static Member member1;
		private static Member member2;
		private ArrayList<Member> memberList; 	
			
		@Before
		public void setUp() throws Exception{
			
			member1 = new Member("Jade","F",94850592,"jade@rp.edu.sg","05/11/95","Singapore");
			member2 = new Member("Jack","M",85716392,"Jack@gmail.com","31/03/85","Colombia");
			memberList = new ArrayList<Member>();
	}
		
	@After
	public void tearDown() throws Exception {
		member1 = null;
		member2 = null;
		memberList = null;
	}
	@Test
	public void retrieveAllMembersTest() {
		//Test if list is not null but empty
		assertNotNull("Test if there is valid Member arraylist to retrieve",memberList);
		//Check if size of empty arraylist becomes 2 after adding 
		ManageMember.addMembers(memberList, member1);
		ManageMember.addMembers(memberList,member2);
		assertEquals("Test arraylist size == 2",2,memberList.size());
	}
	@Test
	public void addMembersTest() {
		//check memberList is not null
		assertNotNull("Test for valid arraylist to add new members",memberList);
	}
	public void deleteMembersTest() {
		retrieveAllMembers();
		//test list not null but empty
		assertNotNull("Test for valid arraylist to delete members from",memberList);
		//Test that if the item have been deleted, the memberList arraylist size decrease by 1 
		//0 is normal
		ManageMember.deleteMembers(memberList, member1.getName());
		assertEquals("Check that memberList arraylist size is 0", 0, memberList.size());
		
	}
	
	
}

