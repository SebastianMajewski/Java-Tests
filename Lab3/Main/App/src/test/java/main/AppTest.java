package main;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AppTest 
{	
	private App app;
	
	@Before
	public void setUp()
	{
		app = new App();
	}
	
	@Test(expected = NullPointerException.class)
	public void nullArrayInt()
	{
		Integer[] arr = null;
		Assert.assertEquals(-1, app.BinSearch(arr, 1));
	}
	
	@Test
	public void emptyArrayInt()
	{
		Integer[] arr = {};			
		Assert.assertEquals(-1, app.BinSearch(arr, 1));
	}
	
	@Test
	public void presentElementInt()
	{
		Integer[] arr = { 1, 2, 3, 8, 5, 9};			
		Assert.assertEquals(0, app.BinSearch(arr, 1));
	}
	
	@Test
	public void notPresentElementInt()
	{
		Integer[] arr = { 1, 2, 3, 8, 5, 9};		
		Assert.assertTrue(0 > app.BinSearch(arr, 10));
	}
	
	
	@Test(expected = NullPointerException.class)
	public void nullArrayByte()
	{
		Byte[] arr = null;		
		Assert.assertEquals(-1, app.BinSearch(arr, (byte)1 ));
	}
	
	@Test
	public void emptyArrayByte()
	{
		Byte[] arr = {};	
		Assert.assertEquals(-1, app.BinSearch(arr, (byte)1));
	}
	
	@Test
	public void presentElementByte()
	{
		Byte[] arr = { 1, 2, 3, 8, 5, 9};	
		Assert.assertEquals(0, app.BinSearch(arr, (byte)1));
	}
	
	@Test
	public void notPresentElementByte()
	{
		Byte[] arr = { 1, 2, 3, 8, 5, 9};		
		Assert.assertTrue(0 > app.BinSearch(arr, (byte)10));
	}
	
	@Test(expected = NullPointerException.class)
	public void nullArrayString()
	{
		String[] arr = null;		
		Assert.assertEquals(-1, app.BinSearch(arr, "s" ));
	}
	
	@Test
	public void emptyArrayString()
	{
		String[] arr = {};	
		Assert.assertEquals(-1, app.BinSearch(arr, "s"));
	}
	
	@Test
	public void presentElementString()
	{
		String[] arr = {"s", "v", "c", "e"};		
		Assert.assertEquals(0, app.BinSearch(arr, "c"));
	}
	
	@Test
	public void notPresentElementString()
	{
		String[] arr = {"s", "v", "c", "e"};
		Assert.assertTrue(0 > app.BinSearch(arr, "g"));
	}
}