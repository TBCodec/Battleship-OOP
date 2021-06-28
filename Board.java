public class Board {
    private Square[][] ocean;
    public Board(int length){
        ocean = new Square[length][length];
    }
    public Square[][] getOcean(){
        return ocean;
    }
}
