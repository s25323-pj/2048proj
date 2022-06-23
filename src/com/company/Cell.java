package com.company;

import java.awt.Color;

//Tworzymy klasę komórka, poniżej ustawiamy jej kolory dla odpowiednich wartości w grze,
//aby zwiększyć przejrzystość i ulepszyć wygląd
public class Cell
{
    int value;

    Color cellColor;

    public Cell()
    {
        value = 0;
    }

    public Cell( int number )
    {
        value = number;
    }

    public int getValue()
    {
        return value;
    }


    public void setValue( int value )
    {
        this.value = value;
    }


    public String toString()
    {
        return "" + value;
    }

    public void setColor()
    {
        if ( this.getValue() == 2 )
        {
            cellColor = new Color( 238, 228, 218 );
        }
        else if ( this.getValue() == 4 )
        {
            cellColor = new Color( 237, 224, 200 );
        }
        else if ( this.getValue() == 8 )
        {
            cellColor = new Color( 242, 177, 121 );
        }
        else if ( this.getValue() == 16 )
        {
            cellColor = new Color( 245, 149, 99 );
        }
        else if ( this.getValue() == 32 )
        {
            cellColor = new Color( 246, 124, 95 );
        }
        else if ( this.getValue() == 64 )
        {
            cellColor = new Color( 237, 207, 114 );
        }
        else if ( this.getValue() == 128 )
        {
            cellColor = new Color( 237, 204, 97);
        }
        else if ( this.getValue() == 256 )
        {
            cellColor = new Color( 237, 200, 80 );
        }
        else if ( this.getValue() == 512 )
        {
            cellColor = new Color( 237, 197, 63 );
        }
        else if ( this.getValue() == 1024 )
        {
            cellColor = new Color( 246, 94, 59 );
        }
        else
        {
            cellColor = new Color( 246, 94, 59 );
        }
    }
    public Color getColor()
    {
        this.setColor();
        return cellColor;
    }

}