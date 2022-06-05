package p1;

import java.awt.Color;

public class MarineAnimalDecorator implements MarineAnimal {
    MarineAnimal marineAnimal;
    public MarineAnimalDecorator(MarineAnimal marineAnimal)
    {
        this.marineAnimal=marineAnimal;
    }
    @Override
    public void PaintFish(Color col){
        marineAnimal.PaintFish(col);
    }
}