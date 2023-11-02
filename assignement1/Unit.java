package assignement1;

abstract class Unit {
    private Tile position;
    public double hp;
    private int MovingRange;
    private String faction;

    public Unit(Tile position, double hp, int MovingRange, String faction) {
        this.position = position;
        this.hp = hp;
        this.MovingRange = MovingRange;
        this.faction = faction;
        position.addUnit(this);



    }

    public final Tile getPosition() {
        return this.position;
    }

    public final double getHP() {
        return this.hp;
    }

    public final String getFaction() {
        return this.faction;
    }
    public boolean moveTo(Tile tile){
        if(Tile.getDistance(tile, this.getPosition()) < this.MovingRange){
            if(this instanceof MilitaryUnit){
                for(int i=0; i< tile.ListOfUnits.length; i++){
                    if ((tile.ListOfUnits)[i] instanceof MilitaryUnit){
                        return false;
                    }
                }
            }
        (this.position).removeUnit(this);
        this.position = tile;
        return true;

        }
        return false;



    }
    public void recieveDamage(double damage){
        if (damage > 0){
            if((this.position).isCity() == true){
                this.hp =this.hp - damage*0.90;
                if(this.hp <= 0)
                    (this.position).removeUnit(this);
            }
            else{
                this.hp =this.hp - damage;
                if(this.hp <= 0){
                    (this.position).removeUnit(this);
                }

            }
        }
        return;

    }
    
    @Override
    public boolean equals(Object obj) {
        Unit objj =(Unit) obj;
        boolean boole;
        boole =(((this.getPosition() == objj.getPosition()) &&
                (this.getFaction() == objj.getFaction()) &&
                Math.pow(((this.getHP() - objj.getHP())), 2)<0.001 &&
                this.getClass() == objj.getClass()));
        ;
        if (boole){
            return true;
        }
        return false;
    }

}



