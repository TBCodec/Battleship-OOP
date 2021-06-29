import java.util.Scanner;

public class Input{
    Scanner input = new Scanner(System.in);

    public int addNumber(){
        return input.nextInt();
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