package assignement1;

public class Settler extends Unit {
    public Settler(Tile position, double hp, String faction) {
        super(position, hp, 2, faction);
    }

    public void TakeAction(Tile tile) {
        if (this.getPosition() == tile && this.getPosition().isCity() == false) {
            tile.buildCity();
            tile.removeUnit(this);
        }
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}


