package p1;

public class Memento {
    private SeaCreature state;
    private SeaCreature creatureReference;
    public Memento(SeaCreature state){
        if (state instanceof Swimmable){
            this.state=((Swimmable) state).clone();
        }else if (state instanceof Immobile){
            this.state=((Immobile) state).clone();
        }
        this.state=state;
    }
    public SeaCreature getState(){return state; }

    public SeaCreature getCreatureReference() {
        return creatureReference;
    }
}
