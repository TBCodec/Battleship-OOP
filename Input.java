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
