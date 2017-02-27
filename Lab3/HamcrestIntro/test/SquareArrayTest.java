import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class SquareArrayTest 
{
	private SquareArray array;
	
	@Before
	public void setUp()
	{
		array = new SquareArray();
	}
	
	@Test
	public void getArray() 
	{
		array.setList(Arrays.asList(1,2,3));
		List<Integer> templList = array.getArray();
		assertThat(templList, containsInAnyOrder(1,2,3));
	}
	
	@Test
	public void getPoweredByPositive()
	{
		array.setList(Arrays.asList(1,2,3));
		assertThat(array.getPowered(2), contains(1,4,9));
	}
	
	@Test
	public void getPoweredByNegative()
	{
		array.setList(Arrays.asList(1,2,3));
		assertThat(array.getPowered(-2), contains(1,0,0));
	}
	
	@Test
	public void getPoweredByZero()
	{
		array.setList(Arrays.asList(1,2,3));
		assertThat(array.getPowered(0), contains(1,1,1));
	}
	
	@Test
	public void findIdPresent()
	{
		array.setList(Arrays.asList(1,2,3));
		assertThat(array.findIndex(2), equalTo(1));
	}
	
	@Test
	public void findIdNotPresent()
	{
		array.setList(Arrays.asList(1,2,3));
		assertThat(array.findIndex(4), equalTo(-1));
	}
	
	@Test
	public void incrementByPositive()
	{
		array.setList(Arrays.asList(1,2,3));
		array.incrementBy(2);
		assertThat(array.getArray(), contains(3,4,5));
	}
	
	@Test
	public void incrementByNegative()
	{
		array.setList(Arrays.asList(1,2,3));
		array.incrementBy(-2);
		assertThat(array.getArray(), contains(-1,0,1));
	}

}
