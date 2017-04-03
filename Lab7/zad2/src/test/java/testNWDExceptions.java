

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testNWDExceptions {

	private NWD test;
	
	@Before
	public void setUp() throws Exception {
		test = new NWD();
	}



	@Test(expected=IllegalArgumentException.class)
	public void FirstArgumentIsNegativeNumber() {
		int a=-4;
		int b=4;
		assertEquals(4,test.nwd(a, b));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void SecondArgumentIsNegativeNumber() {
		int a=-4;
		int b=4;
		assertEquals(4,test.nwd(b, a));
	}
	
	@After
	public void tearDown() throws Exception {
		test = null;
	}

}
