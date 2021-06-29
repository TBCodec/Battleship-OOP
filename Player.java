public class Player {
    private String name;
    //public int ship = 2;
    //public int shut = 0;
    //public boolean RealPlayer;
    
    private Board Board;
    //private String[][] PlayerMap;
    //private String[][] BattleMap;

    public String getName(){
        return name;
    }
    public Board getBoard(){
        return Board;
    }
    public void setBoard(int length){
        Board = new Board(length);
    }
    public void CreatPlayer(int playerNumber){
        if(playerNumber >= 2 )
        {   Battleship battleship = new Battleship();
            battleship.setPlayers(new Player[playerNumber]);
            //Battleship.players = new Player[playerNumber];
            for (int i = 0; i < playerNumber; i++){
                battleship.getPlayers()[i] = new Player();
                //Battleship.players[i] = new Player();
                //Itt álítjuk be, hogy a játékosnál elmentett board milyen hosszú legyen
                battleship.getPlayers()[i].setBoard(5);
;                //Battleship.players[i].setBoard(5);


            }
        } 
    }

}


//teljesen új függvény kell ami a lövést szabályozza

//List<Ship>
//boolean IsAlive amely ellenőrzi hogy nincs-e az összes hajód kilőve (true vagy false értéket ad vissza)

