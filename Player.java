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
        if(playerNumber >= 2 ){
            Battleship.players = new Player[playerNumber];
            for (int i = 0; i < playerNumber; i++){
                Battleship.players[i] = new Player();
                //Itt álítjuk be, hogy a játékosnál elmentett board milyen hosszú legyen
                Battleship.players[i].setBoard(5);
            }
        } 
    }

}
