import Enums.Colors;

import java.security.InvalidParameterException;

public class FourSomeEngine implements FoursomeEngineInterface
{
    private Colors[][] board;

    public FourSomeEngine()
    {
        board = new Colors[6][7];
        for(int i = 0; i < 7; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                board[j][i] = Colors.NONE;
            }
        }
    }

    public boolean CanPut(int column) throws ArrayIndexOutOfBoundsException
    {
        if(column < 0 || column > 6)
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        else return board[0][column] == Colors.NONE;
    }

    public boolean IsFull()
    {
        boolean result = true;
        for(int i = 0; i < 7; i++)
        {
            result = !CanPut(i);
        }
        return result;
    }

    public Colors Winner()
    {
        Colors horizontal = WinnerHorizontal();
        if(horizontal != Colors.NONE)
        {
            return horizontal;
        }
        Colors vertical = WinnerVertical();
        if(vertical != Colors.NONE)
        {
            return vertical;
        }
        Colors diagonally = WinnerDiagonally();
        if(diagonally != Colors.NONE)
        {
            return diagonally;
        }
        Colors rDiagonally = WinnerRDiagonally();
        if(rDiagonally != Colors.NONE)
        {
            return rDiagonally;
        }
        return Colors.NONE;
    }

    private Colors WinnerHorizontal()
    {
        for (int i = 5; i >= 0; i--)
        {
            Colors actualColor = Colors.NONE;
            int actualCount = 0;
            for(int j = 0; j < 7; j++)
            {
                if(actualColor == board[i][j] && actualColor != Colors.NONE)
                {
                    actualCount++;
                }
                else
                {
                    actualColor = board[i][j];
                    actualCount = 1;
                }
                if(actualCount >= 4)
                {
                    return actualColor;
                }
            }
        }
        return Colors.NONE;
    }

    private Colors WinnerVertical()
    {
        for (int i = 0; i < 7; i++)
        {
            Colors actualColor = Colors.NONE;
            int actualCount = 0;
            for(int j = 5; j >= 0; j--)
            {
                if(actualColor == board[j][i] && actualColor != Colors.NONE)
                {
                    actualCount++;
                }
                else {
                    actualColor = board[j][i];
                    actualCount = 1;
                }
                if(actualCount >= 4) { return actualColor; }
            }
        }
        return Colors.NONE;
    }

    private Colors WinnerDiagonally()
    {
        int[][] toCheck = new int[][] { {2,0},{1,0},{0,0},{0,1},{0,2},{0,3} };
        for(int[] tc : toCheck)
        {
            Colors actualColor = Colors.NONE;
            int actualCount = 0;
            int col = tc[1];
            int row = tc[0];
            do
            {
                if(actualColor == board[row][col] && actualColor != Colors.NONE) { actualCount++; }
                else {
                    actualColor = board[row][col];
                    actualCount = 1;
                }
                if(actualCount >= 4) { return actualColor; }
                row++;
                col++;
            }
            while (row <= 5 && col <= 6);
        }
        return Colors.NONE;
    }

    private Colors WinnerRDiagonally()
    {
        int[][] toCheck = new int[][] { {3,0},{4,0},{5,0},{5,1},{5,2},{5,3} };
        for(int[] tc : toCheck)
        {
            Colors actualColor = Colors.NONE;
            int actualCount = 0;
            int col = tc[1];
            int row = tc[0];
            do {
                if(actualColor == board[row][col] && actualColor != Colors.NONE) { actualCount++; }
                else {
                    actualColor = board[row][col];
                    actualCount = 1;
                }
                if(actualCount >= 4)
                {
                    return actualColor;
                }
                row--;
                col++;
            }
            while (row >= 0 && col <= 6);
        }
        return Colors.NONE;
    }

    public void Put(Colors color, int column) throws ArrayIndexOutOfBoundsException, InvalidParameterException
    {
        if(column < 0 || column > 6)
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        else if(!CanPut(column))
        {
            throw new InvalidParameterException();
        }

        for(int i = 5; i >= 0; i--)
        {
            if(board[i][column] == Colors.NONE)
            {
                board[i][column] = color;
                break;
            }
        }
    }

    public Colors[][] GetBoard()
    {
        return board;
    }
}
