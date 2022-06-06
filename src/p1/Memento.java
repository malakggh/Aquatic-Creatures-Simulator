/**
 * Student 1 Name: Malak Ghrayeb
 * Id 1: ***REMOVED***
 * Student 2 Name: Saher Samara
 * Id 2: ***REMOVED***
 */
package p1;

public class Memento {
    private SeaCreature state;
    private SeaCreature creatureReference;

    public Memento(SeaCreature state) {
        if (state instanceof Swimmable) {
            this.state = ((Swimmable) state).clone();
        } else if (state instanceof Immobile) {
            this.state = ((Immobile) state).clone();
        }
        this.creatureReference = state;
    }

    public SeaCreature getState() {
        return state;
    }

    public SeaCreature getCreatureReference() {
        return creatureReference;
    }
}
