import java.util.*;

public class Friendships 
{
    Map<String, List<String>> friendships = new HashMap<String, List<String>>();

    public void makeFriends(String person1, String person2) 
    {
        if(friendships.containsKey(person1))
        {
        	addFriend(person1, person2);
        }
        else
        {
        	List<String> friends = new ArrayList<String>();
        	friendships.put(person1, friends);
        	addFriend(person1, person2);
        }
        
        if(friendships.containsKey(person2))
        {
        	addFriend(person2, person1);
        }
        else
        {
        	List<String> friends = new ArrayList<String>();
        	friendships.put(person2, friends);
        	addFriend(person2, person1);
        }
    }
    
    public List<String> getFriendsList(String person) 
    {
        if(friendships.containsKey(person))
        {
        	return friendships.get(person);
        }
        else
        	return null;
    }
    
    public boolean areFriends(String person1, String person2) 
    {
        if(friendships.containsKey(person1))
        {
        	if(friendships.get(person1).contains(person2))
        		return true;
        }
        return false;
    }
    
    //Dodanie do listy przyjaciol do danej osoby
    private void addFriend(String person, String friend) 
    {
    	List<String> friends =  friendships.get(person);
    	if(!friends.contains(friend))
    	{
    		friends.add(friend);
    	}
    }
}
