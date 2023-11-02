package assignement1;

public class Worker extends Unit {
    private int jobs;

    public Worker(Tile position, double hp, String faction){
        super(position, hp, 2, faction) ;
        this.jobs = 0 ;
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    public void TakeAction(Tile tile){
        if(this.getPosition() == tile && this.getPosition().isImproved() == false){
            tile.buildImprovement();
            this.jobs++;
            if(this.jobs > 10){
                tile.removeUnit(this);
            }
        }
    }

}
