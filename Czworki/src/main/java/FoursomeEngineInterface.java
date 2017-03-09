import Enums.Colors;

public interface FoursomeEngineInterface
{
    boolean CanPut(int column) throws ArrayIndexOutOfBoundsException;
    boolean IsFull();
    Colors Winner();
    void Put(Colors color, int column) throws ArrayIndexOutOfBoundsException;
}
