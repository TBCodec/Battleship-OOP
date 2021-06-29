public class Battleship {
    // Játékosok tömb változóban + get és set
    private Player[] players;
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

        /*
         * Az osztálynak Battleshipvannak olyan mezői Display, Inputamelyeket az egész
         * program használ. Az osztálynak Battleshipvan egy hurka, amelyben a program
         * fut. Az osztály Battleshipmegmutatja a főmenüt, és lehetővé teszi a
         * felhasználó számára, hogy új játékot indítson, bemutassa a toplistákat és
         * kilépjen.
         */
    }
    public void CreatPlayer(int playerNumber, int mapLength){
        if(playerNumber >= 2 ){
            
            setPlayers(new Player[playerNumber]);
            for (int i = 0; i < playerNumber; i++){
                getPlayers()[i] = new Player();
                //Itt álítjuk be, hogy a játékosnál elmentett board milyen hosszú legyen
                Board tabla = new Board(mapLength);
                getPlayers()[i].setBoard(tabla);
                getPlayers()[i].setName("Player "+i);

            }
        } 
    }
}
