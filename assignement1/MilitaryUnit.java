package assignement1;

abstract class MilitaryUnit extends Unit {
    private double damage;
    private int range;
    private int armor;

    public MilitaryUnit(Tile position, double hp, int MovingRange, String faction, double damage, int range, int armor){
        super(position, hp, MovingRange, faction);
        this.damage = damage;
        this.range = range;
        this.armor = armor;
    }
    public void takeAction(Tile tile) {
        if(Tile.getDistance(tile, this.getPosition()) < this.range){
            double hp;
            Unit vic =(Unit)tile.selectWeakEnemy(this.getFaction());
            if(tile.isImproved()){
                hp = vic.getHP() - this.damage*1.05;
                if (hp <= 0);{
                    tile.removeUnit(vic);
                }

            }
            else{
                hp = vic.getHP() - this.damage*1.05;
                if (hp <= 0);{
                    tile.removeUnit(vic);
                }

            }
            vic.hp = hp;

        }


    }
    public void receiveDamage(double damage){
        double Damage;
        Damage = damage*(100/(100+this.armor));
        super.recieveDamage(Damage);
    }

}
