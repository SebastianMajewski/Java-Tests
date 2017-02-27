import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class NWDTest 
{
	private NWD nwd;
	
	@Before
	public void setUp()
	{
		nwd = new NWD();
	}
	
	@Test
	public void zeroAndZero() 
	{
		assertThat(nwd.nwd(0, 0), equalTo(0));
	}
	
	@Test
	public void zeroAndPositive() 
	{
		assertThat(nwd.nwd(0, 2), equalTo(0));
	}
	
	@Test
	public void zeroAndNegative() 
	{
		assertThat(nwd.nwd(0, -2), equalTo(0));
	}

	@Test
	public void PositiveAndNegative() 
	{
		assertThat(nwd.nwd(2, -2), lessThan(0));
	}
	
	@Test
	public void PositiveAndPositive() 
	{
		assertThat(nwd.nwd(2, 6), greaterThan(0));
	}
	
	@Test
	public void NegativeAndNegative() 
	{
		assertThat(nwd.nwd(-2, -6), equalTo(-2));
	}
}
