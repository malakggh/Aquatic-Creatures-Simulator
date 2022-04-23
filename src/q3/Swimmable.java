/**
 * Name: Malak Ghrayeb
 * Id: ***REMOVED***
 */
package q3;
/**
 * Swimmable class
 */
public abstract class Swimmable implements Comparable{
    protected int horSpeed;
    protected int verSpeed;
    /**
     * default constructor
     */
    public Swimmable(){
        this.horSpeed=0;
        this.verSpeed=0;
    }

    /**
     *
     * constructor that gets horSpeed and verSpeed creates a new object
     * @param horSpeed
     * @param verSpeed
     */
    public Swimmable(int horSpeed,int verSpeed){
        this.horSpeed=horSpeed;
        this.verSpeed=verSpeed;
    }

    /**
     * get HorSpeed
     * @return int
     */
    public int getHorSpeed() {
        return horSpeed;
    }
    /**
     * get VerSpeed
     * @return int
     */
    public int getVerSpeed() {
        return verSpeed;
    }

    /**
     * sets new value for horSpeed
     * @param horSpeed
     * @return boolean
     */
    public boolean setHorSpeed(int horSpeed) {
        this.horSpeed = horSpeed;
        return true;
    }
    /**
     * sets new value for verSpeed
     * @param verSpeed
     * @return boolean
     */
    public boolean setVerSpeed(int verSpeed) {
        this.verSpeed = verSpeed;
        return true;
    }
    /**
     * toString function responsible for printing Swimmable object
     * @return String
     */
    @Override
    public String toString() {
        return "Swimmable{" +
                "horSpeed=" + horSpeed +
                ", verSpeed=" + verSpeed +
                '}';
    }
    /**
     * check if equals
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Swimmable)) return false;
        Swimmable swimmable = (Swimmable) o;
        return getHorSpeed() == swimmable.getHorSpeed() && getVerSpeed() == swimmable.getVerSpeed();
    }
    /**
     * if it equals then returns 0
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        if (equals(o))
            return 0;
        return -1;
    }
    public abstract String getAnimalName();
    public abstract int getEatCount();
    public abstract int getSize();
    public abstract String getColor();
    public abstract void earInc();
}
