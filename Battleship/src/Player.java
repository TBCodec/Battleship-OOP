import java.util.ArrayList;
import java.util.List;

public class Player{

    //public Player player = new Player();
    public Player[] players;
    public Player[] getPlayers() {
        return players;
    }
    public void setPlayers(Player[] players) {
        this.players = players;
    }

    private String name;
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    //Tábla osztály, ahol a játékos térképe található
    private Board board;
    public Board getBoard(){
        return board;
    }
    public void setBoard(Board tabla){
        board = tabla;
    }
    /*public void setBoardLength(int length){
        Board = new Board(length);
    }*/

    private List<Ship> ships;
    public List<Ship> getShips(){
        return ships;
    }
    public void setShip(List<Ship> ships){
        this.ships = ships;
    }
    //boolean IsAlive amely ellenőrzi hogy nincs-e az összes hajód kilőve (true vagy false értéket ad vissza)
    public boolean IsAlive(){
        boolean IsAlive = true;
        if (ships.isEmpty()) IsAlive = false;
        return IsAlive;
    }

    public void CreatPlayer(int playerNumber, int mapLength){
        if(playerNumber >= 2 ){

            setPlayers(new Player[playerNumber]);
            for (int i = 0; i < playerNumber; i++){
                getPlayers()[i] = new Player();
                //Itt álítjuk be, hogy a játékosnál elmentett board milyen hosszú legyen
                Board tabla = new Board(mapLength);
                getPlayers()[i].setBoard(tabla);
                //Játékos elnevezése
                getPlayers()[i].setName("Player "+(i+1));
                //Hajók csinálása
                List<Ship> ships = new ArrayList<Ship>();
                ships.add(new Ship());
                getPlayers()[i].setShip(ships);
            }
        }
    }
    
}


//teljesen új függvény kell ami a lövést szabályozza

//List<Ship>


