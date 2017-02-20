import java.util.ArrayList;
import java.util.List;

public class SquareArray 
{
	private List<Integer> list = new ArrayList<Integer>();
	
	public void setList(List<Integer> l)
	{
		list = new ArrayList<Integer>(l);
	}
	
	public List<Integer> getArray()
	{
		return list;
	}
	
	public List<Integer> getPowered(int p)
	{
		List<Integer> result = new ArrayList<Integer>();
		for(int i : list)
		{
			result.add((int)Math.pow(i, p));
		}
		return result;
	}
	
	public int findIndex(int f)
	{
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i) == f) return i;
		}
		return -1;
	}
	
	public void incrementBy(int i)
	{
		List<Integer> result = new ArrayList<Integer>();
		for(int h : list)
		{
			result.add(h + i);
		}
		list = result;
	}
}
