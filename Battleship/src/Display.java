import java.util.Arrays;
import java.util.InputMismatchException;

public class Display{

    /* 0 (üres terület), X (hajo), H (találat), S (elsüllyedt), M (mellé) */
    private static String[] display = {"0 ", "X ", "H ", "S ", "M "};
    private Input input = new Input();
    //private Player player = new Player();
    Battleship battleship = new Battleship();

    //Játék Start képernyóje
    public void StartScreen(){
        /* Írjuk ki a játék nevét, meg, hogy miket lehet választani
        Pl: Új játék, menü, kilépés, toplista */
        System.out.println("Battle Ship\n");
        //Az Input most szülő osztálya a Displaynek, így az ott megírt funkciók előhívhatóak
        int numberInput = HowMach("1. New Game\n2. Toplist\n3. Exit", 1);
        while (numberInput < 1 || numberInput > 3){
            numberInput = HowMach("1. New Game\n2. Toplist\n3. Exit", 1);
        }

        switch(numberInput) {
            case 1:
                StartGame();
                break;
            case 2:
                try {
                    ToplistScreen(battleship.getPlayers());
                }
                catch (NullPointerException e){
                    System.out.println("Még nincs toplista!");
                }
                break;
            case 3:
                System.exit(0);
                break;
        }
        
    }
    //Új játék indítása képernyő
    public void StartGame(){
        //Játékosok létrehozása! Hányan játszotok? Milyen széles legyen a pálya?
        battleship.CreatPlayer(HowMach("Hányan szertnétek játszani? Minimum 2 játékos kell!", 2),
        HowMach("Mekkora legyen a pálya? (Minimum 5-ös)", 5));
        //Rajzolunk
        PrintPlayersBoard(battleship.getPlayers(), "ocean");
        //Hajók lerakása az összes játékos lerakja a hajóit
        InstallShipsScreen(battleship.getPlayers());
        //Csata
        BattleShipsScreen(battleship.getPlayers());
        //End game toplisat kiírása
        ToplistScreen(battleship.getPlayers());
    }
    //Hajók elrendezáse
    public void InstallShipsScreen(Player[] players){
        int abc, num = 0;
        int NumMaps = players[0].getBoard().getOcean().length;
        Player[] one = new Player[1];
        for (int i = 0; i <= players.length-1; i++){
            one[0] = players[i];
            PrintPlayersBoard(one, "ocean");
            for (int s = 1; s <= players[i].getShips().size();) {
                num = HowMach("\n"+ s + ". hajó lerakásához válassz 1 és "+ NumMaps +" koordináták közül: ", 1)-1;
                System.out.print(s + ". hajó lerakásához válassz A és "+ (char)(64+NumMaps) +" koordináták közül: ");
                abc = input.addCharacter()-1;
                if((abc >= 0 && abc < NumMaps) && (num >= 0 && num < NumMaps) && (players[i].getBoard().getOcean()[abc][num] == display[0])){
                    players[i].getBoard().getOcean()[abc][num] = display[1];
                    s++;
                    PrintPlayersBoard(one, "ocean");
                }
                else if((abc >= 0 && abc < NumMaps) && (num >= 0 && num < NumMaps) && players[i].getBoard().getOcean()[abc][num] == display[1])
                    System.out.println("Ide már raktál!");
                else if((abc < 0 || abc >= NumMaps) || (num < 0 || num >= NumMaps))
                    System.out.println("Nem rakhatsz hajókat a " + NumMaps + " és " + (char)(64+NumMaps) + " kívülre!");
            }
        }
    }

    //Játék csata kirajzolása
    public void BattleShipsScreen(Player[] players){
        int NumMaps = players[0].getBoard().getOcean().length;
        do {
            for (int me = 0; me <= players.length-1; me++){
                PrintPlayersBoard(players, "Kristóf :D (shut)");
                int abc, num;
                do {
                    //System.out.print(players[me].getName()+": Live?:"+ players[me].IsAlive()+" Ship size: "+players[me].getShips().size()+" Vége a játéknak?"+endBattleCheck(players)+"\n");
                    num = HowMach("Válassz 1 és "+ NumMaps + " koordináták közül: ", 1)-1;
                    System.out.print("Válassz A és "+ (char)(64+NumMaps) +" koordináták közül: ");
                    abc = input.addCharacter()-1;
                    //valós területre
                    if ((abc >= 0 && abc < NumMaps) && (num >= 0 && num < NumMaps)){
                        //csak az ellenséget támadjuk, de egyszerre mindenkit
                        for (int enemy = 0; enemy <= players.length-1; enemy++){
                            if ( getPlayerOcean(players, enemy)[abc][num].equals(display[1]) && (me != enemy) ) {
                                System.out.println(players[enemy].getName()+": Bumm! Elsüllyesztetted a hajót!");
                                getPlayerOcean(players, enemy)[abc][num] = display[3];
                                players[me].getBoard().getShut()[abc][num] = display[2];
                                // Az ucsó hajot töröljük
                                players[enemy].getShips().remove(players[enemy].getShips().size()-1);
                            }
                            else if (me != enemy) {
                                System.out.println(players[enemy].getName()+": Nem talált.");
                                players[me].getBoard().getShut()[abc][num] = display[4];
                            }
                        }
                    }
                    else if ((abc < 0 || abc > NumMaps) || (num < 0 || num > NumMaps))
                        System.out.println("Nem találsz hajókat a " + NumMaps + " és " + (char)(64+NumMaps) + " kívül!");
                }
                while((abc < 0 || abc >= NumMaps) || (num < 0 || num >= NumMaps));
            }
        }while(endBattleCheck(players));
    }

    public static boolean endBattleCheck(Player[] players){
        boolean noend = true;
        for (int i = 0; i <= players.length-1; i++){
            if (players[i].IsAlive()) noend = false;
        }
        return noend;
    }
    //Toplista kirajtolása
    public void ToplistScreen(Player[] players){
        PrintPlayersBoard(players, "ocean");
        PrintPlayersBoard(players, "");
        boolean haveWinner = true;
        Player winner = players[0];
        for (int i = 0; i <= players.length-1; i++){
            System.out.println(players[i].getName()+"| Hajója: " + players[i].getShips().size() );
            // A győztes
            if (players[i].getShips().size() >= winner.getShips().size()) winner = players[i];
        }
        // Vagy döntetlen?
        for (int j = 0; j <= players.length-1; j++){
            if (winner.getShips().size() == players[j].getShips().size() && !winner.getName().equals(players[j].getName())) haveWinner = false;
        }
        if(haveWinner) System.out.println(winner.getName()+" a győztes!");
        else System.out.println("Dönetlen az eredmény!");
    }
    //Kérdés és minimum szám érték adása
    public int HowMach(String question, int minimum){
        int value = 0;
        while (value < minimum){
            System.out.println(question);
            value = input.addNumber();
        }
        return value;
    }

    public void PrintPlayersBoard(Player[] players, String mapname){
        for (int i = 0; i <= players.length-1; i++){
            System.out.print(" "+players[i].getName()+String.format("%"+(2+(getPlayerOcean(players, i).length*2)-players[i].getName().length())+"s", " "));
        }
        System.out.println();
        for (int i = 0; i <= players.length-1; i++){
            System.out.print("   ");
            for(int num = 1; num <= getPlayerOcean(players, i).length; num++) System.out.print(num+" ");
        }
        //ABC és 0-ák kiírása
        System.out.println();
        for(int abc = 0; abc < getPlayerOcean(players, 0).length; abc++) {
            for (int i = 0; i <= players.length-1; i++){
                System.out.print(" "+(char)(65+abc)+" ");
                for (int num = 0; num < getPlayerOcean(players, i).length; num++){
                    if(mapname=="ocean"){
                        if (getPlayerOcean(players, i)[abc][num] == null) getPlayerOcean(players, i)[abc][num] = display[0];
                        System.out.print(players[i].getBoard().getOcean()[abc][num]);
                    }else{
                        if (players[i].getBoard().getShut()[abc][num] == null) players[i].getBoard().getShut()[abc][num] = display[0];
                        System.out.print(players[i].getBoard().getShut()[abc][num]);
                    }
                }
            }
            System.out.println();
        }
    }
    private String[][] getPlayerOcean(Player[] players, int i) {
        return players[i].getBoard().getOcean();
    }
}
//játék kimenetelének a megjelenítése



