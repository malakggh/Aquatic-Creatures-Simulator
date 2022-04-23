/**
 * Name: Malak Ghrayeb
 * Id: ***REMOVED***
 */
package q3;

/**
 * Fish class
 */
public class Fish extends Swimmable{
    private final int EAT_DISTANCE = 4;
    private int size;
    private int col;
    private int eatCount;
    private int x_front;
    private int y_front;
    private int x_dir;
    private int y_dir;

    /**
     * constructor that gets prams and creates a new object
     * @param size
     * @param x_front
     * @param y_front
     * @param horSpeed
     * @param verSpeed
     * @param col
     */
    public Fish(int size,int x_front,int y_front,int horSpeed,int verSpeed,int col){
        super(horSpeed,verSpeed);
        eatCount=0;
        y_dir=1;
        x_dir=1;
        this.size = size;
        this.x_front=x_front;
        this.y_front=y_front;
        this.col=col;
    }

    /**
     * default constructor
     */
    public Fish(){
        this(0,0,0,0,0,0);
    }

    /**
     * returns Fish
     * @return String
     */
    @Override
    public String getAnimalName() {
        return "Fish";
    }

    /**
     * returns eatCount
     * @return int
     */
    @Override
    public int getEatCount() {
        return eatCount;
    }

    /**
     * get size
     * @return int
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * get color of fish according to number between 1-9
     * @return String
     */
    @Override
    public String getColor() {
        if (col == 1){
            return "Black";
        }else if(col == 2){
            return "Red";
        }else if(col == 3){
            return "Blue";
        }else if(col == 4){
            return "Green";
        }else if(col == 5){
            return "Cyan";
        }else if(col == 6){
            return "Orange";
        }else if(col == 7){
            return "Yellow";
        }else if(col == 8){
            return "Magenta";
        }else{
            return "Pink";
        }
    }

    /**
     * increase eatCount
     */
    @Override
    public void earInc() {
        if(this.eatCount+1 < this.size)
            this.eatCount = eatCount+1;
        else {
            this.eatCount=0;
            this.size++;
        }

    }

    /**
     * change size of fish
     * @param size
     */
    public void changeFish(int size){
        this.size=size;
    }
    public void changeColor(){
        this.col = (col+1)%9;
    }

    /**
     * toString function responsible for printing Fish object
     * @return String
     */
    @Override
    public String toString() {
        return "Fish{" +
                "EAT_DISTANCE=" + EAT_DISTANCE +
                ", size=" + size +
                ", col=" + col +
                ", eatCount=" + eatCount +
                ", x_front=" + x_front +
                ", y_front=" + y_front +
                ", x_dir=" + x_dir +
                ", y_dir=" + y_dir +
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
        if (!(o instanceof Fish)) return false;
        if (!super.equals(o)) return false;
        Fish fish = (Fish) o;
        return getSize() == fish.getSize() && col == fish.col && getEatCount() == fish.getEatCount() && x_front == fish.x_front && y_front == fish.y_front && x_dir == fish.x_dir && y_dir == fish.y_dir;
    }


}
