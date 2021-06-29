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
        System.out.println("1. New Game\n2. Toplist\n3. Exit");
        //Az Input most szülő osztálya a Displaynek, így az ott megírt funkciók előhívhatóak
        switch(input.addNumber()) {
            case 1:
                //Játékosok létrehozása! Hányan játszotok? Milyen széles legyen a pálya?
                battleship.CreatPlayer(
                    HowMach("Hányan szertnétek játszani? Minimum 2 játékos kell!"),
                    HowMach("Mekkora legyen a pálya?")
                    );
                //Hajók lerakása
                // Player[] pirate = battleship.getPlayers();

                int[] c = InstallShipsScreen(battleship.getPlayers()[0]);
                System.out.println(c[0]+ " és " +c[1]);
                break;
            case 2:
                ToplistScreen();
                break;
            case 3:
                System.exit(0);
                break;
        }
        
    }
    //Hajók elrendezáse
    public int[] InstallShipsScreen(Player player){
        int[] cordinata = new int[2];
        System.out.println("\n X. hajó lerakásához válassz 1 és "+ player.getBoard().getOcean().length +" koordináták közül: ");
        cordinata[0] = input.addNumber();
        System.out.println("\n X. hajó lerakásához válassz A és "+ (char)(64+player.getBoard().getOcean().length) +" koordináták közül: ");
        cordinata[1] = input.addCharacter();
        return cordinata;
    }
    //Játék csata kirajzolása
    public void BattleShipsScreen(){
    }
    //Toplista kirajtolása
    public void ToplistScreen(){
    }
    //itt kérdezi meg, hogy mennyi legyen a játékosok száma, illetve, hogy a térkép mekkora legyen
    public int HowMach(String question){
        int playerNumber = 0;
        while (playerNumber < 2){
            System.out.println(question);
            playerNumber = input.addNumber();
        }
        return playerNumber;
    }
    public void PrintPlayersBoard(Player[] players){
        for (int i = 0; i <= players.length-1; i++){
            System.out.print(" "+players[i].getName()+String.format("%"+(2+(extracted(players, i).length*2)-players[i].getName().length())+"s", " "));
        }
        System.out.println();
        for (int i = 0; i <= players.length-1; i++){
            System.out.print("   ");
            for(int num = 1; num <= extracted(players, i).length; num++) System.out.print(num+" ");
        }
        //ABC és 0-ák kiírása
        System.out.println();
        for(int abc = 0; abc < players[0].getBoard().getOcean().length; abc++) {
            for (int i = 0; i <= players.length-1; i++){
                System.out.print(" "+(char)(65+abc)+" ");
                for (int num = 0; num < extracted(players, i).length; num++){
                    Square s = new Square();
                    players[i].getBoard().getOcean()[abc][num] = s.setValue("display[0]");
                    //display[0];
                    /*
                    if(isBattleMap){
                        if (players[i].getBattleMap()[abc][num] == null) players[i].getBattleMap()[abc][num] = display[0];
                        System.out.print(players[i].getBattleMap()[abc][num]);
                    }else{
                        if (players[i].getPlayerMap()[abc][num] == null) players[i].getPlayerMap()[abc][num] = display[0];
                        System.out.print(players[i].getPlayerMap()[abc][num]);
                    }*/
                }
            }
            System.out.println();
        }
    }
    private Square[][] extracted(Player[] players, int i) {
        return players[i].getBoard().getOcean();
    }
}
//játék kimenetelének a megjelenítése