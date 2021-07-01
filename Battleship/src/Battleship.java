import java.util.ArrayList;
import java.util.List;

public class Battleship {
    // Játékosok tömb változóban + get és set
    public Player player = new Player();
    public Player[] players;
    public Player[] getPlayers() {
        return players;
    }
    public void setPlayers(Player[] players) {
        this.players = players;
    }
    public static void main(String[] args) {
        // A Start képernyő kiírása a Display osztályból
        Display screen = new Display();
        screen.StartScreen();
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
