/**
 * Student 1 Name: Malak Ghrayeb
 * Id 1: ***REMOVED***
 * Student 2 Name: Saher Samara
 * Id 2: ***REMOVED***
 */
package p1;

import static p1.AquaFrame.food;

public class Satiated implements HungerState {
    @Override
    public void doAction(Swimmable swimmable) {
        swimmable.move();
        if (swimmable.foodCounter != food.getFoodCounter()) {
            swimmable.foodCounter++;
            if (swimmable.hungerCounter < 4) {
                swimmable.setHungerCounter(swimmable.getHungerCounter() + 1);
            } else {
                swimmable.setHungerCounter(0);
                swimmable.setHungerState(new Hungry());
            }

        }

    }
}
