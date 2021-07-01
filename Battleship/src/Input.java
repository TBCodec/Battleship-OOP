import java.util.Scanner;

public class Input{
    Scanner input = new Scanner(System.in);
    public int addNumber(){
        int yourNumber = 0;
        if(input.hasNextInt())  yourNumber = input.nextInt();
        else yourNumber =0;
        return yourNumber;
    }
    public int addCharacter(){
        return (input.next().toUpperCase().charAt(0)-64);
    }
}

//minden inputot itt kell kezelni és az inputvalidációkat is

//nehézségválasztás

//hány játékos játszik

//board factory inputja

//manual placement


//tryCatch /while implementálása