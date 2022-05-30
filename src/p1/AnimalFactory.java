package p1;

import java.awt.Color;


public class AnimalFactory implements AbstractSeaFactory {

    private int size,horSpeed,verSpeed;
    private int col;
    public AnimalFactory(int size,int horSpeed,int verSpeed,int col)
    {
        this.size=size;
        this.horSpeed=horSpeed;
        this.verSpeed=verSpeed;
        this.col=col;
    }




    @Override
    public SeaCreature produceSeaCreature(String type){
        if(type.equalsIgnoreCase("Fish")){
            return new Fish(size,0,0,horSpeed,verSpeed,col);
        }

        else if(type.equalsIgnoreCase("Jellyfish"))
            return new Jellyfish(size,0,0,horSpeed,verSpeed,col);

        return null;
    }


}
