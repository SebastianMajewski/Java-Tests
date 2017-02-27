package main;

import java.util.Arrays;

public class App
{
    /*public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }*/
    
    public <T> int BinSearch(T[] array, T x)
    {
    	Arrays.sort(array);
    	return Arrays.binarySearch(array, x);
    }
}
