public class Display{
    //Játék Start képernyóje
    Input input = new Input();
    Player player = new Player();
    public void StartScreen(){
        /* Írjuk ki a játék nevét, meg, hogy miket lehet választani
        Pl: Új játék, menü, kilépés, toplista */
        System.out.println("Battle Ship\n");
        System.out.println("1. New Game\n2. Toplist\n3. Exit");
        //Az Input most szülő osztálya a Displaynek, így az ott megírt funkciók előhívhatóak
        switch(input.addNumber()) {
            case 1:
                //Hányan játszotok? 
                int number = HowMachPlayerScreen();
                player.CreatPlayer(number);
                //Hajók lerakása
                Battleship battleship = new Battleship();
               // Player[] pirate = battleship.getPlayers();

                int[] c = InstallShipsScreen(battleship.getPlayers()[2]);
                //System.out.println(c[0]+ " és " +c[1]);
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
    //Játék csata kirajzolésa
    public void BattleShipsScreen(){
    }
    //Toplista kirajtolása
    public void ToplistScreen(){
    }
    public int HowMachPlayerScreen(){
        
        int playerNumber = 0;
        while (playerNumber < 2){
            System.out.println("Hányan szertnétek játszani? Minimum 2 játékos kell!");
            playerNumber = input.addNumber();
        }
        return playerNumber;
    }
}
//játék kimenetelének a megjelenítése