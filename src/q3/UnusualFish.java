/**
 * Name: Malak Ghrayeb
 * Id: ***REMOVED***
 */
package q3;

/**
 * UnusualFish class
 */
public class UnusualFish extends Fish{
    private int factor;

    /**
     * constructor that gets prams and creates a new object
     * @param size
     * @param x_front
     * @param y_front
     * @param horSpeed
     * @param verSpeed
     * @param col
     * @param factor
     */
    public UnusualFish(int size,int x_front,int y_front,int horSpeed,int verSpeed,int col,int factor){
        super(size,x_front,y_front,horSpeed,verSpeed,col);
        this.factor=factor;
    }
    /**
     * default constructor
     */
    public UnusualFish(){
        super();
        this.factor=0;
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
     * returns UnusualFish
     * @return String
     */
    @Override
    public String getAnimalName() {
        return "UnusualFish";
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
     * get factor
     * @return int
     */
    public int getFactor() {
        return factor;
    }
    /**
     * get size
     * @return int
     */
    @Override
    public int getSize() {
        return super.getSize() * factor;
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
     * sets factor
     * @param factor
     * @return boolean
     */
    public boolean setFactor(int factor) {
        this.factor = factor;
        return true;
    }
    /**
     * toString function responsible for printing Fish object
     * @return String
     */
    @Override
    public String toString() {
        return "UnusualFish{" +
                "verSpeed=" + verSpeed +
                "} " + super.toString();
    }

    /**
     * check if equals
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UnusualFish)) return false;
        if (!super.equals(o)) return false;
        UnusualFish that = (UnusualFish) o;
        return getFactor() == that.getFactor();
    }

}