package assignement1;

public class ListOfUnits {
    private Unit[] ListOfUnits;
    private int size;

    public ListOfUnits() {
        this.ListOfUnits = new Unit[10];
        this.size = 0;
    }

    public int getSize() {
        for (int i = 0; i < ListOfUnits.length; i++) {
            if (ListOfUnits[i] instanceof Unit && ListOfUnits[i] != null) {
                size++;
            }
        }
        return size;
    }

    public Unit[] getList() {
        int j = 0;
        Unit[] newArray = new Unit[size];
        for (int i = 0; i < size; i++) {
            if (ListOfUnits[i] != null) {
                newArray[j] = ListOfUnits[i] ;
                j++;
            }
        }
        return newArray;
    }
    public Unit getUnit(int index){
        if(index < 0 && index > this.getList().length){
            throw new IndexOutOfBoundsException();
        }
        return this.getList()[index];
    }
    public void addUnit(Unit unit) {
        Unit[] newArr = new Unit[(this.getList()).length + 1];
        for (int i = 0; i < (this.getList()).length; i++) {
            if ((this.getList())[i] != null) {
                int j = 0;
                newArr[j] = this.getList()[i] ;
                j++;
            }
            newArr[newArr.length-1] = unit;
            ListOfUnits = newArr;
        }
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    public int indexOf(Unit unit) {
        for (int i = 0; i < ListOfUnits.length; i++) {
            if (ListOfUnits[i].equals(unit)) {
                return i;
            }
        }
        return -1;
    }
    public boolean removeUnit(Unit unit) {
        int ind = indexOf(unit);
        if (ind == -1) {
            return false;
        }
        Unit[] newArr = new Unit[(this.getList()).length - 1];
        for (int i = 0; i < (this.getList()).length; i++) {
            if (i != ind) {
                int j = 0;
                newArr[j] = (this.getList())[i];
                j++;
            }
        }
        ListOfUnits = newArr;
        return true;
    }


        public MilitaryUnit[] getArmy () {
            int j = 0;
            Unit[] newArr = new Unit[ListOfUnits.length];
            for (int i = 0; i < ListOfUnits.length; i++) {
                if (ListOfUnits[i] instanceof MilitaryUnit) {
                    newArr[j] = ListOfUnits[i];
                    j++;

                }

            }

            MilitaryUnit[] MilitaryArray = new MilitaryUnit[j];//all units
            for (int o = 0; 0 < newArr.length; o++) {
                int h = 0;
                MilitaryArray[h] = (MilitaryUnit) newArr[o];
                h++;
            }
            return MilitaryArray;
        }


}        // eliminating null elements

