/**
 * Created by GSun12 on 20.02.2017.
 */
public class NWD {
	
	public int a;
	public int b;
	
    public int nwd(int a,int b){
    	if(a <= 0 || b <= 0 ){
			throw new IllegalArgumentException();
		}
        a=Math.abs(a);
        b=Math.abs(b);
        do
        {
            if(a>b) a=a-b;
            else b=b-a;
        }
        while(a!=b);
        return a;
    }
    
    public int nwd()
    {
    	return this.nwd(a,b);
    }
}
