import Enums.Colors;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

public class Has6x7Size extends BaseMatcher
{
    private String why;
    public boolean matches(Object array)
    {
        if(array.getClass() != Colors[][].class)
        {
            why = "Argument is'n array class.";
            return false;
        }
        else
        {
            Colors[][] a = (Colors[][])array;
            if(a.length == 6 && a[0].length == 7)
            {
                return true;
            }
            else
            {
                why = "Array is not 6x7 int array";
                return false;
            }
        }
    }

    public void describeTo(Description description)
    {
        description.appendText(why);
    }
}
