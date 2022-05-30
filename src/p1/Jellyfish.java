/**
 * Student 1 Name: Malak Ghrayeb
 * Id 1: ***REMOVED***
 * Student 2 Name: Saher Samara
 * Id 2: ***REMOVED***
 */
package p1;

import java.awt.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import static p1.AquaFrame.*;
import static p1.AquaFrame.barrier;

/**
 * Jellyfish class
 */
public class Jellyfish extends Swimmable{
    private final int EAT_DISTANCE = 4;
    private int size;
    private int col;
    private int eatCount;
    private int x_front;
    private int y_front;
    private int x_dir;
    private int y_dir;
    private Color color;
    /**
     * constructor that gets prams and creates a new object
     * @param size
     * @param x_front
     * @param y_front
     * @param horSpeed
     * @param verSpeed
     * @param col
     */
    public Jellyfish(int size,int x_front,int y_front,int horSpeed,int verSpeed,int col){
        super(horSpeed,verSpeed);
        eatCount=0;
        y_dir=1;
        x_dir=1;
        this.size = size;
        this.x_front=x_front;
        this.y_front=y_front;
        this.col=col;
        setColor();
    }

    /**
     * default constructor
     */
    public Jellyfish(){
        this(0,0,0,0,0,0);
    }

    public void setX_front(int x_front) {
        this.x_front = x_front;
    }

    /**
     * get color of fish according to number between 1-9
     * @return String
     */



    public void setY_front(int y_front) {
        this.y_front = y_front;
    }

    public int getX_front() {
        return x_front;
    }

    public int getY_front() {
        return y_front;
    }

    @Override
    public void flip_Xdir() {
        x_dir=x_dir*-1;
    }

    @Override
    public void flip_Ydir() {
        y_dir=y_dir*-1;
    }

    @Override
    public int get_Xdir() {
        return x_dir;
    }

    @Override
    public int get_Ydir() {
        return y_dir;
    }

    @Override
    public void run() {
        while (active) {
            synchronized (this) {
                while (sleep) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }


                if (x_front >= mainPanel.getSize().width) {
                    flip_Xdir();
                    x_front = (int) (x_front - size * 1.253452525);
                }
                if (x_front < 0) {
                    flip_Xdir();
                    x_front = ((int) (x_front + size * 1.253452525));
                }

                if (y_front >= mainPanel.getSize().height || y_front < 0) {
                    flip_Ydir();
                }
                if (food.getState()){
                    try {
                        barrier.await();

                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    changeDirToFood();

                }else {
                    x_front = x_front + horSpeed * x_dir;
                    y_front = y_front + verSpeed * y_dir;
                }

                mainPanel.repaint();
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void changeDirToFood(){
        //System.out.println("I changed direction " + currentThread().getName());
        int centerX = mainPanel.getSize().width/2;
        int centerY = mainPanel.getSize().height/2;
        int disX = centerX-x_front;
        int disY = centerY-y_front;
        double dis = Math.pow((disX*disX+disY*disY),0.5);
        double alpha;
        if (dis <= 5 ){
            support.firePropertyChange(currentThread().getName()+" ate food",dis-1,dis);
        }
        if((disX*disX+disY*disY)==0){
            alpha = Math.pow ((double)(horSpeed*horSpeed+verSpeed*verSpeed),0.5);
        }
        else
            alpha = Math.pow (((double)(horSpeed*horSpeed+verSpeed*verSpeed)/ (double)(disX*disX+disY*disY)),0.5);

        if(disX<0 && x_dir==1){
            x_dir=-1;
        }else if(disX > 0 && x_dir==-1){
            x_dir=1;
        }
        x_front += alpha * disX ;
        y_front += alpha * disY ;
    }
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
     * change size of Jellyfish
     * @param size
     */
    public void changeJellyfish(int size){
        this.size=size;
    }
    /**
     * toString function responsible for printing Fish object
     * @return String
     */
    @Override
    public String toString() {
        return "Jellyfish{" +
                "EAT_DISTANCE=" + EAT_DISTANCE +
                ", size=" + size +
                ", col=" + getColor() +
                ", eatCount=" + eatCount +
                ", x_front=" + x_front +
                ", y_front=" + y_front +
                ", x_dir=" + x_dir +
                ", y_dir=" + y_dir +
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
        if (!(o instanceof Jellyfish)) return false;
        if (!super.equals(o)) return false;
        Jellyfish jellyfish = (Jellyfish) o;
        return getSize() == jellyfish.getSize() && col == jellyfish.col && getEatCount() == jellyfish.getEatCount() && x_front == jellyfish.x_front && y_front == jellyfish.y_front && x_dir == jellyfish.x_dir && y_dir == jellyfish.y_dir;
    }

    /**
     * returns Jellyfish
     * @return String
     */
    @Override
    public String getAnimalName() {
        return "Jellyfish";
    }


    @Override
    public void setSuspend() {

    }

    @Override
    public void setResume() {

    }

    @Override
    public void setBarrier(CyclicBarrier b) {

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
     * increase eatCount
     */
    @Override
    public void eatInc() {
        if(this.eatCount+1 < this.size)
            this.eatCount = eatCount+1;
        else {
            this.eatCount=0;
            this.size++;
        }

    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure {@link Integer#signum
     * signum}{@code (x.compareTo(y)) == -signum(y.compareTo(x))} for
     * all {@code x} and {@code y}.  (This implies that {@code
     * x.compareTo(y)} must throw an exception if and only if {@code
     * y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code
     * x.compareTo(y)==0} implies that {@code signum(x.compareTo(z))
     * == signum(y.compareTo(z))}, for all {@code z}.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     * @apiNote It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     */
    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public void setColor(){
        if (col == 1){
            color = new Color(Color.black.getRGB());
        }else if(col == 2){
            color = new Color(Color.red.getRGB());
        }else if(col == 3){
            color = new Color(Color.blue.getRGB());
        }else if(col == 4){
            color = new Color(Color.green.getRGB());
        }else if(col == 5){
            color = new Color(Color.cyan.getRGB());
        }else if(col == 6){
            color = new Color(Color.orange.getRGB());
        }else if(col == 7){
            color = new Color(Color.yellow.getRGB());
        }else if(col == 8){
            color = new Color(Color.magenta.getRGB());
        }else if(col == 9){
            color = new Color(Color.pink.getRGB());
        }
    }

    public void drawAnimal(Graphics g)
    {
        int numLegs;
        if(size<40)
            numLegs = 5;
        else if(size<80)
            numLegs = 9;
        else
            numLegs = 12;

        g.setColor(color);
        g.fillArc(x_front - size/2, y_front - size/4, size, size/2, 0, 180);

        for(int i=0; i<numLegs; i++)
            g.drawLine(x_front - size/2 + size/numLegs + size*i/(numLegs+1), y_front, x_front - size/2 + size/numLegs + size*i/(numLegs+1), y_front+size/3);
    }
    public void drawCreature(Graphics g) {
        drawAnimal(g);
    }

}
