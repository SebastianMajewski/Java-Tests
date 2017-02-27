import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;

public class FriendshipsHTest 
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
		assertThat(fs.areFriends("Jacek", "Beata"), equalTo(true));
		assertThat(fs.areFriends("Beata", "Jacek"), equalTo(true));
	}
	
	@Test
	public void areNotFriends()
	{
		fs.friendships.put("Jacek", Arrays.asList("Magda"));
		fs.friendships.put("Magda", Arrays.asList("Jacek"));
		assertThat(fs.areFriends("Jacek", "Beata"), equalTo(false));
		assertThat(fs.areFriends("Beata", "Jacek"), equalTo(false));
	}
	
	@Test
	public void makeFriendsEmptyMap()
	{
		fs.makeFriends("Jacek", "Beata");
		assertThat(fs.friendships.get("Jacek").contains("Beata"), equalTo(true));
		assertThat(fs.friendships.get("Beata").contains("Jacek"), equalTo(true));
	}
	
	@Test
	public void makeFriendsIncrementListSize()
	{
		fs.makeFriends("Jacek", "Beata");
		assertThat(fs.friendships.get("Jacek"), hasSize(1));
		assertThat(fs.friendships.get("Beata"), hasSize(1));
	}
	
	@Test
	public void getFriendListNull()
	{
		assertThat(fs.getFriendsList("Jacek"), nullValue());
	}

	@Test
	public void getFriendListContainsTwoFriends()
	{
		fs.makeFriends("Jacek", "Beata");
		fs.makeFriends("Jacek", "Magda");
		assertThat(fs.getFriendsList("Jacek"), hasSize(2));
	}
	
	@Test
	public void getFriendListContainsNames()
	{
		fs.makeFriends("Jacek", "Beata");
		fs.makeFriends("Jacek", "Magda");
		assertThat(fs.getFriendsList("Jacek"), containsInAnyOrder("Beata","Magda"));
	}
	
	@Test
	public void makeFriendsDontDuplicate()
	{
		fs.makeFriends("Jacek", "Beata");
		fs.makeFriends("Jacek", "Beata");
		assertThat(fs.friendships.get("Jacek"), hasSize(1));
		assertThat(fs.friendships.get("Beata"), hasSize(1));
	}
}
