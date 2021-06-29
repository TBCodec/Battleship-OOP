public class Board {

    private String[][] ocean;
    public Board(int length){
        ocean = new String[length][length];
    }
    public String[][] getOcean(){
        return ocean;
    }
}
//isPlacementOkay függvény ami azonosítja hogy lehetséges-e lerakni a hajót

