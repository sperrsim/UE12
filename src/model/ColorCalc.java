package model;

import model.ColorCode;

import java.util.Scanner;

/**
 * @author Simon Sperr
 * @version 2020.3, 21.1.2021
 */
public class ColorCalc {

    public static void main(String[] args) {
        int select;
        boolean run = true;
        ColorCalc calc = new ColorCalc();

        while (run)
        {
            Scanner s = new Scanner(System.in);
            menu();
            try
            {
                select = Integer.parseInt(s.next());
            }
            catch (Exception e)
            {
                System.out.println("Fehlerhafte Eingabe! Bitte geben Sie eine Zahl ein");
                break;
            }
            switch (select)
            {
                case 1:
                    System.out.println("Geben Sie einen Wert für jeden Farbanteil ein!");
                    try
                    {
                        System.out.println("Rot:");
                        calc.changeColorViaAbsoluteValue(ColorCode.RED, Integer.parseInt(s.next()));
                        System.out.println("Grün:");
                        calc.changeColorViaAbsoluteValue(ColorCode.GREEN, Integer.parseInt(s.next()));
                        System.out.println("Blau:");
                        calc.changeColorViaAbsoluteValue(ColorCode.BLUE, Integer.parseInt(s.next()));
                    }
                    catch (Exception e)
                    {
                        System.out.println("Fehlerhafte Eingabe! Bitte geben Sie eine gültige Zahl ein");
                        break;
                    }
                    System.out.println(calc.toString());
                    break;
                case 2:
                    System.out.println("Geben Sie für jeden Farbanteil einen Wert ein um den dieser verändert werden soll!);
                    try
                    {
                        System.out.println("Rot:");
                        calc.changeColorViaRelativValue(ColorCode.RED, Integer.parseInt(s.next()));
                        System.out.println("Grün:");
                        calc.changeColorViaRelativValue(ColorCode.GREEN, Integer.parseInt(s.next()));
                        System.out.println("Blau:");
                        calc.changeColorViaRelativValue(ColorCode.BLUE, Integer.parseInt(s.next()));
                    }
                    catch (Exception e)
                    {
                        System.out.println("Fehlerhafte Eingabe! Bitte geben Sie eine gültige Zahl ein");
                        break;
                    }
                    break;
                case 3:
                    System.out.println(calc.toString() + "\n Hex: " + calc.getHex());
                    break;
                case 4:
                    System.out.println("Auf Wiedersehen!");
                    run = false;
                    break;
                default:
                    System.out.println("Keine gültige Option!");
                    break;
            }

        }
    }

    private ModularCounter red;
    private ModularCounter green;
    private ModularCounter blue;


    public ColorCalc ()
    {
        red = new ModularCounter(256);
        green = new ModularCounter(256);
        blue = new ModularCounter(256);
    }

    public static void menu()
    {
        System.out.printf("\nMenü:\n" +
                            "1 - Absoluten Farbwert einstellen\n" +
                            "2 - Farbe um bestimmten Wert verändern\n" +
                            "3 - Aktuelle Farbwerte anzeigen\n" +
                            "4 - Verlassen\n");
    }

    public void changeColorViaAbsoluteValue(ColorCode cc, String value)
    {
        int intValue = 0;
        try {
            intValue = Integer.parseInt(value);
            switch (cc) {
                case RED:
                    red.update(intValue - getRed());
                    break;
                case BLUE:
                    blue.update(intValue - getBlue());
                    break;
                case GREEN:
                    green.update(intValue - getGreen());
                    break;
            }
        }
        catch (Exception e)
        {
            System.out.println("Fehler beim Anwenden der letzten Änderung\n");
        }
    }

    public void changeColorViaAbsoluteValue(ColorCode cc, int value)
    {
        switch (cc)
        {
            case RED:
                red.update(value - getRed());
                break;
            case BLUE:
                blue.update(value - getBlue());
                break;
            case GREEN:
                green.update(value - getGreen());
                break;
        }
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
                    break;
                case GREEN:
                    green.update(intValue);
                    break;
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
                break;
            case GREEN:
                green.update(value);
                break;
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
        String hex = "#";
        if (getRed() < 16)
            hex += "0" + Integer.toHexString(getRed());
        else
            hex += Integer.toHexString(getRed());
        if(getGreen() < 16)
            hex += "0" + Integer.toHexString(getGreen());
        else
            hex += Integer.toHexString(getGreen());
        if(getBlue() < 16)
            hex += "0" + Integer.toHexString(getBlue());
        else
            hex += Integer.toHexString(getBlue());
        return hex;
    }

    @Override
    public String toString() {
        return "Aktuelle Farbe: " +
                "\nRot: " + getRed() +
                "\nGrün: " + getGreen() +
                "\nBlau: " + getBlue();
    }
}
