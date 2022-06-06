/**
 * Student 1 Name: Malak Ghrayeb
 * Id 1: ***REMOVED***
 * Student 2 Name: Saher Samara
 * Id 2: ***REMOVED***
 */
package p1;

import java.awt.*;

public class Zostera extends Immobile {

    public Zostera(int size, int x, int y) {
        super(size, "Zostera", x, y);
    }

    @Override
    public void drawCreature(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g2.setColor(colorr);
        g.drawLine(x, y, x, y - size);
        g.drawLine(x - 2, y, x - 10, y - size * 9 / 10);
        g.drawLine(x + 2, y, x + 10, y - size * 9 / 10);
        g.drawLine(x - 4, y, x - 20, y - size * 4 / 5);
        g.drawLine(x + 4, y, x + 20, y - size * 4 / 5);
        g.drawLine(x - 6, y, x - 30, y - size * 7 / 10);
        g.drawLine(x + 6, y, x + 30, y - size * 7 / 10);
        g.drawLine(x - 8, y, x - 40, y - size * 4 / 7);
        g.drawLine(x + 8, y, x + 40, y - size * 4 / 7);
        g2.setStroke(new BasicStroke(1));
    }

    @Override
    public Immobile clone() {
        return new Zostera(size, x, y);
    }
}
