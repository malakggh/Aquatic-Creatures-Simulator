/**
 * Student 1 Name: Malak Ghrayeb
 * Id 1: ***REMOVED***
 * Student 2 Name: Saher Samara
 * Id 2: ***REMOVED***
 */
package p1;

import javax.swing.*;

public class Worm {

    static private volatile Worm instance = null;
    private boolean state;
    private int foodCounter;

    private Worm() {
        foodCounter = 0;
        state = false;
    }

    public static Worm getInstance() {
        if (instance == null)
            synchronized (Worm.class) {
                if (instance == null)
                    instance = new Worm();
            }
        return instance;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean x) {
        if (x != state && x) {
            foodCounter++;
        }
        state = x;
    }

    public int getFoodCounter() {
        return foodCounter;
    }

    public void paintWorm(AquaPanel x, JLabel foodLabel) {
        foodLabel.setBounds(x.getSize().width / 2, x.getSize().height / 2, 50, 50);
        foodLabel.setVisible(true);
    }

    public void unpaintWorm(JLabel foodLabel) {
        foodLabel.setVisible(false);
    }
}
