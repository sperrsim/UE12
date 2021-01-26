package model;

import model.ColorCode;

/**
 * @author Simon Sperr
 * @version 2020.3, 21.1.2021
 */
public class ColorCalc {

    private ModularCounter red;
    private ModularCounter green;
    private ModularCounter blue;

    public ColorCalc ()
    {
        red = new ModularCounter(0,256);
        green = new ModularCounter(0,256);
        blue = new ModularCounter(0,256);
    }

    public void changeColorViaAbsoluteValue(ColorCode cc, String value)
    {

    }

    public void changeColorViaAbsoluteValue(ColorCode cc, int value)
    {


    }

    public void changeColorViaRelativValue(ColorCode cc, String value)
    {
        int intValue = 0;
        try{
            intValue = Integer.parseInt(value);
            switch (cc)
            {
                case RED:
                    red.update(intValue);
                    break;
                case BLUE:
                    blue.update(intValue);
                case GREEN:
                    green.update(intValue);
            }
        }
        catch (Exception e)
        {
            System.out.println("Fehler beim Anwenden der letzten Änderung");
        }
    }

    public void changeColorViaRelativValue(ColorCode cc, int value)
    {
        switch(cc)
        {
            case RED:
                red.update(value);
                break;
            case BLUE:
                blue.update(value);
            case GREEN:
                green.update(value);
        }
    }

    public int getRed()
    {
        return red.getValue();
    }

    public int getGreen()
    {
        return green.getValue();
    }

    public int getBlue()
    {
        return blue.getValue();
    }

    public String getHex()
    {
        return null;
    }

    @Override
    public String toString() {
        return "Aktuelle Farbe: " +
                "\nRot: " + getRed() +
                "\nGrün: " + getGreen() +
                "\nBlau: " + getBlue();
    }
}
