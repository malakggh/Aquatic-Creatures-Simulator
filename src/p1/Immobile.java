package p1;

import java.awt.*;

public abstract class Immobile implements SeaCreature {
    protected String name;
    protected int size;
    protected int col;
    protected int x;
    protected int y;
    protected Color colorr;
    public Immobile(int size,String name,int x,int y){
        this.name=name;
        this.size=size;
        this.x=x;
        this.y=y;
        this.colorr=Color.green;
    }
}

