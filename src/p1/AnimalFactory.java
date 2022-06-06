/**
 * Student 1 Name: Malak Ghrayeb
 * Id 1: ***REMOVED***
 * Student 2 Name: Saher Samara
 * Id 2: ***REMOVED***
 */
package p1;

import java.awt.Color;

public class AnimalFactory implements AbstractSeaFactory {

    private int size, horSpeed, verSpeed, eatFreq;
    private int col;

    public AnimalFactory(int size, int horSpeed, int verSpeed, int col, int eatFreq) {
        this.size = size;
        this.horSpeed = horSpeed;
        this.verSpeed = verSpeed;
        this.col = col;
        this.eatFreq = eatFreq;
    }

    @Override
    public SeaCreature produceSeaCreature(String type) {
        if (type.equalsIgnoreCase("Fish")) {
            return new Fish(size, 0, 0, horSpeed, verSpeed, col, eatFreq);
        }

        else if (type.equalsIgnoreCase("Jellyfish"))
            return new Jellyfish(size, 0, 0, horSpeed, verSpeed, col, eatFreq);

        return null;
    }

}
