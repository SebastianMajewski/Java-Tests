import Enums.Colors;

public class FourSomeEngine implements FoursomeEngineInterface
{
    public boolean CanPut(int column) throws ArrayIndexOutOfBoundsException {
        return false;
    }

    public boolean IsFull() {
        return false;
    }

    public Colors Winner() {
        return null;
    }

    public void Put(Colors color, int column) throws ArrayIndexOutOfBoundsException {

    }
}
