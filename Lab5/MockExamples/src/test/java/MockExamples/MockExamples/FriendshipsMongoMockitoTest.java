package MockExamples.MockExamples;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

// Ta linia jest wymagana
@RunWith(MockitoJUnitRunner.class)
public class FriendshipsMongoMockitoTest {
	
	//Nasza atrapa
	@InjectMocks
	FriendshipsMongo friendships;
	
	//Co zastepujemy
	@Mock
	FriendsCollection friends;
	
	
	@Test
	public void mockingWorskAsExpected()
	{
		Person joe = new Person("Joe");
		doReturn(joe).when(friends).findByName("Joe");
		assertThat(friends.findByName("Joe")).isEqualTo(joe);
	}
	
	@Test
	public void alexDoesNotHaveFriends()
	{
		assertThat(friendships.getFriendsList("Alex")).isEmpty();
	}
	
	@Test
	public void joeHas5Friends()
	{
		List<String> expected = Arrays.asList(new String[]{"Karol","Dawid","Maciej","Tomek","Adam"});
		//Spy przechwytuje wywołania z przekazywanymi pośrednio danymi w celu
		// późniejszego zbadania tych danych w teście - tutaj w przykładzie lista przyjaciół Joe
		Person joe = spy(new Person("Joe"));
		doReturn(joe).when(friends).findByName("Joe");
		doReturn(expected).when(joe).getFriends();
		assertThat(friendships.getFriendsList("Joe")).hasSize(5).containsOnly("Karol","Dawid","Maciej","Tomek","Adam");
	}
	
	@Test
	public void joeAndTimMakeFriends()
	{
		Person joe = new Person("Joe");
		Person tim = new Person("Tim");
		doReturn(joe).when(friends).findByName("Joe");
		doReturn(tim).when(friends).findByName("Tim");
		friendships.makeFriends(joe.name, tim.name);
		assertThat(friendships.areFriends(joe.name, tim.name)).isTrue();
	}

	@Test
	public void joeAndTimAreFriends()
	{
		Person joe = spy(new Person("Joe"));
		Person tim = spy(new Person("Tim"));
		List<String> joeFriends = Arrays.asList(new String[]{tim.name});
		doReturn(joe).when(friends).findByName(joe.name);
		doReturn(tim).when(friends).findByName(tim.name);
		doReturn(joeFriends).when(joe).getFriends();
		assertThat(friendships.areFriends(joe.name, tim.name)).isTrue();
	}

	@Test
	public void joeHasFriends()
	{
		Person joe = spy(new Person("Joe"));	
		List<String> joeFriends = Arrays.asList(new String[]{"Tim"});	
		doReturn(joe).when(friends).findByName(joe.name);
		doReturn(joeFriends).when(joe).getFriends();
		assertThat(friendships.getFriendsList("Joe").size()).isGreaterThan(0);
	}
}
