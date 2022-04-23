/**
 * Name: Malak Ghrayeb
 * Id: ***REMOVED***
 */
package p1;

/**
 * UnusualFish class
 */
public class MultiColorFish extends Fish{
    /**
     * constructor that gets prams and creates a new object
     * @param size
     * @param x_front
     * @param y_front
     * @param horSpeed
     * @param verSpeed
     * @param col
     */
    public MultiColorFish(int size,int x_front,int y_front,int horSpeed,int verSpeed,int col){
        super(size,x_front,y_front,horSpeed,verSpeed,col);
    }

    /**
     * default constructor
     */
    public MultiColorFish(){
        super();
    }
    /**
     * toString function responsible for printing Fish object
     * @return String
     */
    @Override
    public String toString() {
        return super.toString();
    }
    /**
     * check if equals
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
    /**
     * get eat count
     * @return int
     */
    @Override
    public int getEatCount() {
        return super.getEatCount();
    }

    /**
     * get horspeed
     * @return int
     */
    @Override
    public int getHorSpeed() {
        return super.getHorSpeed();
    }

    /**
     * get verspeed
     * @return int
     */
    @Override
    public int getVerSpeed() {
        return super.getVerSpeed();
    }
    /**
     * returns MultiColorFish
     * @return String
     */
    @Override
    public String getAnimalName() {
        return "MultiColorFish";
    }
    /**
     * get color of fish according to number between 1-9
     * @return String
     */
    @Override
    public String getColor() {
        return super.getColor();
    }
    /**
     * get size
     * @return int
     */
    @Override
    public int getSize() {
        return super.getSize();
    }

    /**
     * set horspeed
     * @param horSpeed
     * @return boolean
     */
    @Override
    public boolean setHorSpeed(int horSpeed) {
        return super.setHorSpeed(horSpeed);
    }

    /**
     * set varspeed
     * @param verSpeed
     * @return boolean
     */
    @Override
    public boolean setVerSpeed(int verSpeed) {
        return super.setVerSpeed(verSpeed);
    }

    /**
     * increase counter
     * changes fish color
     */
    @Override
    public void eatInc() {
        int currentSize = getSize();
        super.eatInc();
        if(getSize()!=currentSize)
            changeColor();
    }
}