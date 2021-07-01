public class Board {

    private String[][] ocean;
    private String[][] shut;
    public Board(int length){
        ocean = new String[length][length];
        shut = new String[length][length];
    }
    public String[][] getOcean(){
        return ocean;
    }
    public String[][] getShut(){
        return shut;
    }
}
//isPlacementOkay függvény ami azonosítja hogy lehetséges-e lerakni a hajót

