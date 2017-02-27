
public class NWD 
{
	public int nwd(int a, int b)
	{
		if(a == 0 || b == 0) return 0;
		int c;                    
	    while(b != 0)             
	    {
	        c = a % b;
	        a = b;
	        b = c;
	    }
	    return a; 
	}
}
