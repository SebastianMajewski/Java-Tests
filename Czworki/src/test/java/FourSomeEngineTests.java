import Enums.Colors;
import org.junit.Before;
import org.junit.Test;

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
}
