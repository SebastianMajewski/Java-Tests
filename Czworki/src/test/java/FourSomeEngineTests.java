import Enums.Colors;
import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class FourSomeEngineTests
{
    private FoursomeEngineInterface engine;

    @Before
    public void setEngine()
    {
        this.engine = new FourSomeEngine();
    }

    @Test
    public void IsFullReturnFalseWhenEmpty()
    {
        assertThat(engine.IsFull(), equalTo(false));
    }

    @Test
    public void IsFullReturnFalseWhenNotFull()
    {
        for(int i = 0; i < 7; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                engine.Put(Colors.GREEN, i);
            }
        }
        assertThat(engine.IsFull(), equalTo(false));
    }

    @Test
    public void IsFullReturnTrueWhenFull()
    {
        for(int i = 0; i < 7; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                engine.Put(Colors.GREEN, i);
            }
        }
        assertThat(engine.IsFull(), equalTo(true));
    }

    @Test
    public void CanPutReturnTrueWhenColumnEmpty()
    {
        assertThat(engine.CanPut(0), equalTo(true));
    }

    @Test
    public void CanPutReturnTrueWhenColumnNotFull()
    {
        engine.Put(Colors.GREEN, 0);
        engine.Put(Colors.GREEN, 0);
        engine.Put(Colors.GREEN, 0);
        assertThat(engine.CanPut(0), equalTo(true));
    }

    @Test
    public void CanPutReturnFalseWhenColumnFull()
    {
        for (int j = 0; j < 5; j++)
        {
            engine.Put(Colors.GREEN, 0);
        }
        assertThat(engine.CanPut(0), equalTo(false));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void CanPutThrowsArrayIndexOutOfBoundsExceptionWhenIndexTooSmall()
    {
        engine.CanPut(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void CanPutThrowsArrayIndexOutOfBoundsExceptionWhenIndexTooLarge()
    {
        engine.CanPut(7);
    }

    @Test
    public void GetBoardReturns6x7Board()
    {
        Colors[][] board = engine.GetBoard();
        assertThat(board, new Has6x7Size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void PutThrowsArrayIndexOutOfBoundsExceptionWhenIndexTooSmall()
    {
        engine.Put(Colors.GREEN, -1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void PutThrowsArrayIndexOutOfBoundsExceptionWhenIndexTooLarge()
    {
        engine.Put(Colors.GREEN, 7);
    }

    @Test
    public void PutPlacesRight()
    {
        engine.Put(Colors.GREEN, 0);
        engine.Put(Colors.RED, 1);
        engine.Put(Colors.RED, 0);
        assertThat(engine.GetBoard()[0][0], equalTo(Colors.GREEN));
        assertThat(engine.GetBoard()[0][1], equalTo(Colors.RED));
        assertThat(engine.GetBoard()[1][0], equalTo(Colors.RED));
    }

    @Test(expected = InvalidParameterException.class)
    public void PutThrowsInvalidParameterExceptionWhenCanPutFalse()
    {
        for(int i = 0; i < 7; i++)
        {
            engine.Put(Colors.GREEN, 0);
        }
    }

    @Test
    public void WinnerReturnNoneWhenNoOneWin()
    {
        assertThat(engine.Winner(), equalTo(Colors.NONE));
    }

    @Test
    public void WinnerReturnPlayerWhen4Vertical()
    {
        engine.Put(Colors.GREEN, 0);
        engine.Put(Colors.GREEN, 0);
        engine.Put(Colors.GREEN, 0);
        engine.Put(Colors.GREEN, 0);
        assertThat(engine.Winner(), equalTo(Colors.GREEN));
    }

    @Test
    public void WinnerReturnPlayerWhen4Horizontal()
    {
        engine.Put(Colors.GREEN, 0);
        engine.Put(Colors.GREEN, 1);
        engine.Put(Colors.GREEN, 2);
        engine.Put(Colors.GREEN, 3);
        assertThat(engine.Winner(), equalTo(Colors.GREEN));
    }

    @Test
    public void WinnerReturnPlayerWhen4Diagonally()
    {
        engine.Put(Colors.RED, 0);
        engine.Put(Colors.RED, 0);
        engine.Put(Colors.RED, 0);
        engine.Put(Colors.GREEN, 0);
        engine.Put(Colors.RED, 1);
        engine.Put(Colors.RED, 1);
        engine.Put(Colors.GREEN, 1);
        engine.Put(Colors.RED, 2);
        engine.Put(Colors.GREEN, 2);
        engine.Put(Colors.GREEN, 3);
        assertThat(engine.Winner(), equalTo(Colors.GREEN));
    }

    @Test
    public void WinnerReturnPlayerWhen4RDiagonally()
    {
        engine.Put(Colors.GREEN, 0);
        engine.Put(Colors.RED, 1);
        engine.Put(Colors.GREEN, 1);
        engine.Put(Colors.RED, 2);
        engine.Put(Colors.RED, 2);
        engine.Put(Colors.GREEN, 2);
        engine.Put(Colors.RED, 3);
        engine.Put(Colors.RED, 3);
        engine.Put(Colors.RED, 3);
        engine.Put(Colors.GREEN, 3);
        assertThat(engine.Winner(), equalTo(Colors.GREEN));
    }

    @Test
    public void WinnerReturnPlayerWhen4VerticalWithObstacle()
    {
        engine.Put(Colors.GREEN, 0);
        engine.Put(Colors.RED, 0);
        engine.Put(Colors.GREEN, 0);
        engine.Put(Colors.GREEN, 0);
        engine.Put(Colors.GREEN, 0);
        engine.Put(Colors.GREEN, 0);
        assertThat(engine.Winner(), equalTo(Colors.GREEN));
    }

    @Test
    public void WinnerReturnPlayerWhen4HorizontalWithObstacle()
    {
        engine.Put(Colors.GREEN, 0);
        engine.Put(Colors.RED, 1);
        engine.Put(Colors.GREEN, 2);
        engine.Put(Colors.GREEN, 3);
        engine.Put(Colors.GREEN, 4);
        assertThat(engine.Winner(), equalTo(Colors.GREEN));
    }

    @Test
    public void WinnerReturnPlayerWhen4DiagonallyWithObstacle()
    {
        engine.Put(Colors.RED, 0);
        engine.Put(Colors.RED, 0);
        engine.Put(Colors.GREEN, 0);
        engine.Put(Colors.RED, 0);
        engine.Put(Colors.RED, 0);
        engine.Put(Colors.RED, 1);
        engine.Put(Colors.RED, 1);
        engine.Put(Colors.GREEN, 1);
        engine.Put(Colors.GREEN, 1);
        engine.Put(Colors.RED, 2);
        engine.Put(Colors.GREEN, 2);
        engine.Put(Colors.GREEN, 2);
        engine.Put(Colors.GREEN, 3);
        engine.Put(Colors.GREEN, 3);
        engine.Put(Colors.GREEN, 4);
        assertThat(engine.Winner(), equalTo(Colors.GREEN));
    }

    @Test
    public void WinnerReturnPlayerWhen4RDiagonallyWithObstacle()
    {
        engine.Put(Colors.RED, 0);
        engine.Put(Colors.GREEN, 1);
        engine.Put(Colors.GREEN, 1);
        engine.Put(Colors.RED, 2);
        engine.Put(Colors.GREEN, 2);
        engine.Put(Colors.GREEN, 2);
        engine.Put(Colors.GREEN, 3);
        engine.Put(Colors.RED, 3);
        engine.Put(Colors.RED, 3);
        engine.Put(Colors.GREEN, 3);
        engine.Put(Colors.GREEN, 4);
        engine.Put(Colors.RED, 4);
        engine.Put(Colors.RED, 4);
        engine.Put(Colors.GREEN, 4);
        engine.Put(Colors.GREEN, 4);
        assertThat(engine.Winner(), equalTo(Colors.GREEN));
    }
}
