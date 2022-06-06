/**
 * Student 1 Name: Malak Ghrayeb
 * Id 1: ***REMOVED***
 * Student 2 Name: Saher Samara
 * Id 2: ***REMOVED***
 */
package p1;

import java.awt.Color;

public class MarineAnimalDecorator implements MarineAnimal {
    MarineAnimal marineAnimal;

    public MarineAnimalDecorator(MarineAnimal marineAnimal) {
        this.marineAnimal = marineAnimal;
    }

    @Override
    public void PaintFish(Color col) {
        marineAnimal.PaintFish(col);
    }
}