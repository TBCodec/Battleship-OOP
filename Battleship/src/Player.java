import java.util.List;

public class Player{
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
    
}


//teljesen új függvény kell ami a lövést szabályozza

//List<Ship>


