import java.sql.Array;
import java.util.Arrays;

public class Sorting 
{
	int[] array;
	
	public void SortArray() throws MyException
	{
		if(array.length == 0) throw new MyException();
		Arrays.sort(array);
	}
}
