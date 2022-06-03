package p1;

import java.awt.*;

public abstract class Immobile implements SeaCreature,Cloneable {
    protected String name;
    protected int size;
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

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getColorr() {
        return "Green";
    }
    @Override
    abstract public Immobile clone();

    public void update(Immobile immobile){
        this.size=immobile.getSize();
        this.x=immobile.getX();
        this.y=immobile.getY();
    }
}

