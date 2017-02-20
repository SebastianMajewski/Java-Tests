import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class FriendshipsJTest 
{
Friendships fs;
	
	@Before
	public void setUp()
	{
		fs = new Friendships();
	}
	
	@Test
	public void areFriends()
	{
		fs.friendships.put("Jacek", Arrays.asList("Beata"));
		fs.friendships.put("Beata", Arrays.asList("Jacek"));
		assertEquals(true, fs.areFriends("Jacek", "Beata"));
		assertEquals(true, fs.areFriends("Beata", "Jacek"));
	}
	
	@Test
	public void areNotFriends()
	{
		fs.friendships.put("Jacek", Arrays.asList("Magda"));
		fs.friendships.put("Magda", Arrays.asList("Jacek"));
		assertEquals(false, fs.areFriends("Jacek", "Beata"));
		assertEquals(false, fs.areFriends("Beata", "Jacek"));
	}
	
	@Test
	public void makeFriendsEmptyMap()
	{
		fs.makeFriends("Jacek", "Beata");
		assertEquals(true, fs.friendships.get("Jacek").contains("Beata"));
		assertEquals(true, fs.friendships.get("Beata").contains("Jacek"));
	}
	
	@Test
	public void makeFriendsIncrementListSize()
	{
		fs.makeFriends("Jacek", "Beata");
		assertEquals(1, fs.friendships.get("Jacek").size());
		assertEquals(1, fs.friendships.get("Beata").size());
	}
	
	@Test
	public void getFriendListNull()
	{
		assertEquals(null, fs.getFriendsList("Jacek"));
	}

	@Test
	public void getFriendListContainsTwoFriends()
	{
		fs.makeFriends("Jacek", "Beata");
		fs.makeFriends("Jacek", "Magda");
		assertEquals(2, fs.getFriendsList("Jacek").size());
	}
	
	@Test
	public void getFriendListContainsNames()
	{
		fs.makeFriends("Jacek", "Beata");
		fs.makeFriends("Jacek", "Magda");
		assertEquals(true, fs.getFriendsList("Jacek").contains("Beata"));
		assertEquals(true, fs.getFriendsList("Jacek").contains("Magda"));
	}
	
	@Test
	public void makeFriendsDontDuplicate()
	{
		fs.makeFriends("Jacek", "Beata");
		fs.makeFriends("Jacek", "Beata");
		assertEquals(1, fs.getFriendsList("Jacek").size());
		assertEquals(1, fs.getFriendsList("Beata").size());
	}
}
