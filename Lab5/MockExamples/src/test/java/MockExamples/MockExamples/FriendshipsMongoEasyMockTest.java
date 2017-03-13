package MockExamples.MockExamples;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.MockType;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.Arrays;
import java.util.List;

@RunWith(EasyMockRunner.class)
public class FriendshipsMongoEasyMockTest {

	@TestSubject
	FriendshipsMongo friendships = new FriendshipsMongo();
	
	//A nice mock expects recorded calls in any order and returning null for other calls
	@Mock(type = MockType.NICE)
	FriendsCollection friends;
	
	@Test
	public void mockingWorksAsExpected(){
		Person joe = new Person("Joe");
		//Zapisanie zachowania - co sie ma stac
		expect(friends.findByName("Joe")).andReturn(joe);
		//Odpalenie obiektu do sprawdzenia zachowania
		replay(friends);
		assertThat(friends.findByName("Joe")).isEqualTo(joe);
	}
	
	@Test
	public void alexDoesNotHaveFriends(){
		assertThat(friendships.getFriendsList("Alex")).isEmpty();
	}
	
	@Test
	public void joeHas5Friends(){
		List<String> expected = Arrays.asList(new String[]{"Karol","Dawid","Maciej","Tomek","Adam"});
		Person joe = createMock(Person.class);
		expect(friends.findByName("Joe")).andReturn(joe);
		expect(joe.getFriends()).andReturn(expected);
		replay(friends);
		replay(joe);
		assertThat(friendships.getFriendsList("Joe")).hasSize(5).containsOnly("Karol","Dawid","Maciej","Tomek","Adam");
	}
	
	@Test
	public void joeAndTimMakeFriends()
	{
		Person joe = createMock(Person.class);
		Person tim = createMock(Person.class);
		List<String> joeFriends = Arrays.asList(new String[]{"Tim"});
		expect(friends.findByName("Joe")).andReturn(joe);
		expect(friends.findByName("Tim")).andReturn(tim);
		expect(joe.getFriends()).andReturn(joeFriends);
		replay(joe);
		replay(tim);
		replay(friends);

		System.out.println(friendships.getFriendsList("Joe").size());
		//friendships.makeFriends("Joe", "Tim");
		assertThat(friendships.getFriendsList("Joe")).hasSize(1);
	}

	@Test
	public void joeAndTimAreFriends()
	{
		Person joe = createMock(Person.class);
		Person tim = new Person("Tim");	
		List<String> joeFriends = Arrays.asList(new String[]{"Tim"});	
		expect(friends.findByName("Joe")).andReturn(joe);
		expect(friends.findByName("Tim")).andReturn(tim);
		expect(joe.getFriends()).andReturn(joeFriends);
		replay(joe);
		replay(friends);
		assertThat(friendships.areFriends("Joe", "Tim")).isTrue();
	}
	
	@Test
	public void joeHasFriends()
	{
		Person joe = createMock(Person.class);	
		List<String> joeFriends = Arrays.asList(new String[]{"Tim"});	
		expect(friends.findByName("Joe")).andReturn(joe);
		expect(joe.getFriends()).andReturn(joeFriends);
		replay(joe);
		replay(friends);
		assertThat(friendships.getFriendsList("Joe").size()).isGreaterThan(0);
	}
}
