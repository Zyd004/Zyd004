package assignement1;

public class Archer extends MilitaryUnit {
    private int arrows;
    public Archer(Tile position, double hp, String faction){
        super(position, hp, 2, faction, 15.0, 2, 0);
        this.arrows = 5;
    }
    public void takeAction(Tile tile){
        if(this.arrows < 1 ){
            this.arrows = 5;
        }
        else{
            super.takeAction(tile);
            this.arrows--;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}