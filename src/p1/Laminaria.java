package p1;

import java.awt.*;

public class Laminaria extends Immobile{

    public Laminaria(int size,int x,int y) {
        super(size,"Laminaria",x,y);
    }
    @Override
    public void drawCreature(Graphics g) {
        g.setColor(colorr);
        g.fillArc(x-size/20, y-size, size/10, size*4/5,0, 360);
        g.fillArc(x-size*3/20, y-size*13/15, size/10, size*2/3,0, 360);
        g.fillArc(x+size/20,y-size*13/15,size/10, size*2/3, 0, 360);
        g.drawLine(x, y, x, y-size/5);
        g.drawLine(x,y,x-size/10,y-size/5);
        g.drawLine(x, y, x+size/10, y-size/5);
    }
}
