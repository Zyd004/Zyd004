package assignement1;

public class Tile {
    private int x;
    private int y;
    private boolean city;
    private boolean improve;
    public Unit[] ListOfUnits;


    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.city = false;
        this.improve = false;
        this.ListOfUnits = new Unit[10];

    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean isCity() {
        return city;
    }

    public boolean isImproved() {
        return improve;
    }

    public void buildCity() {
        this.city = true;
    }

    public void buildImprovement() {
        this.improve = true;
    }
    public boolean addUnit(Unit unit){
        if(unit instanceof MilitaryUnit){
            for(int i =0; i < ListOfUnits.length; i++){
                if (ListOfUnits[i] instanceof MilitaryUnit){
                    return false;
                }
            }
        }
        Unit[] newArr = new Unit[ListOfUnits.length + 1];
        for (int i = 0; i < ListOfUnits.length; i++) {
                int j = 0;
                (ListOfUnits)[i] = newArr[j];
                j++;
            }
        newArr[newArr.length-1] = unit;
        ListOfUnits = newArr;
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public boolean removeUnit(Unit unit){
        for(int i =0; i< ListOfUnits.length; i++){
            if (ListOfUnits[i].equals(unit)){
                Unit[] newArr = new Unit[ListOfUnits.length - 1];
                for(int k =0; k< ListOfUnits.length; k++){
                    if (!(ListOfUnits[k].equals(unit))){
                        int j = 0;
                        newArr[j] = (ListOfUnits[i]);
                        j++;
                    }
                }
                ListOfUnits = newArr;
                return true;
            }

        }
        return false;
    }

    public Unit selectWeakEnemy(String faction) {
        Unit[] EnmUnits = new Unit[100];
        int j = 0;
        for (int i = 0; i < ListOfUnits.length; i++) {
            if (ListOfUnits[i].getFaction() != faction && ListOfUnits[i] != null) {
                EnmUnits[j] = ListOfUnits[i];
            }
        }
        return findMin(EnmUnits);
    }
    public Unit  findMin(Unit[]arr){
        double min = arr[0].getHP();
        Unit goal = arr[0] ;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].getHP() < min) {
                min = arr[i].getHP();
                goal = arr[i];
            }
        }
        return goal;
    }




    public static double getDistance(Tile Tile1, Tile Tile2){
        double distance;
        distance = Math.sqrt(Math.pow((Tile1.x-Tile2.x),2)-(Math.pow((Tile1.y-Tile2.y),2)));
        return distance;
    }
}


