import java.util.ArrayList;
import java.util.List;

public class Battleship {
    // Játékosok tömb változóban + get és set
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
}
