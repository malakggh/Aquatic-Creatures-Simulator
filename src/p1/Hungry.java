/**
 * Student 1 Name: Malak Ghrayeb
 * Id 1: ***REMOVED***
 * Student 2 Name: Saher Samara
 * Id 2: ***REMOVED***
 */
package p1;

public class Hungry implements HungerState {
    @Override
    public void doAction(Swimmable swimmable) {
        swimmable.changeDirToFood();
    }
}
