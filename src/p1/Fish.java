/**
 * Name: Malak Ghrayeb
 * Id: ***REMOVED***
 */
package p1;

import java.awt.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import static p1.AquaFrame.*;

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
    public Fish(int size,int x_front,int y_front,int horSpeed,int verSpeed,int col){
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

    public void setX_front(int x_front) {
        this.x_front = x_front;
    }

    public void setY_front(int y_front) {
        this.y_front = y_front;
    }

    public int getX_front() {
        return x_front;
    }

    public int getY_front() {
        return y_front;
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

    @Override
    public void setSuspend() {

    }

    @Override
    public void setResume() {

    }

    @Override
    public void setBarrier(CyclicBarrier b) {

    }
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
                if (food){
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
        if (!(o instanceof Fish)) return false;
        if (!super.equals(o)) return false;
        Fish fish = (Fish) o;
        return getSize() == fish.getSize() && col == fish.col && getEatCount() == fish.getEatCount() && x_front == fish.x_front && y_front == fish.y_front && x_dir == fish.x_dir && y_dir == fish.y_dir;
    }

    @Override
    public void drawAnimal(Graphics g)
    {
        g.setColor(color);
        if(x_dir==1) // fish swims to right side
        {
            // Body of fish
            g.fillOval(x_front - size, y_front - size/4, size, size/2);

            // Tail of fish
            int[] x_t={x_front-size-size/4,x_front-size-size/4,x_front-size};
            int [] y_t = {y_front - size/4, y_front + size/4, y_front};
            Polygon t = new Polygon(x_t,y_t,3);
            g.fillPolygon(t);

            // Eye of fish
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(new Color(255-color.getRed(),255-color.getGreen(),255- color.getBlue()));
            g2.fillOval(x_front-size/5, y_front-size/10, size/10, size/10);

            // Mouth of fish
            if(size>70)
                g2.setStroke(new BasicStroke(3));
            else if(size>30)
                g2.setStroke(new BasicStroke(2));
            else
                g2.setStroke(new BasicStroke(1));
            g2.drawLine(x_front, y_front, x_front-size/10, y_front+size/10);
            g2.setStroke(new BasicStroke(1));
        }
        else // fish swims to left side
        {
            // Body of fish
            g.fillOval(x_front, y_front - size/4, size, size/2);

            // Tail of fish
            int[] x_t={x_front+size+size/4,x_front+size+size/4,x_front+size};
            int [] y_t = {y_front - size/4, y_front + size/4, y_front};
            Polygon t = new Polygon(x_t,y_t,3);
            g.fillPolygon(t);
            // Eye of fish
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(new Color(255-color.getRed(),255-color.getGreen(),255-color.getBlue()));
            g2.fillOval(x_front+size/10, y_front-size/10, size/10, size/10);

            // Mouth of fish
            if(size>70)
                g2.setStroke(new BasicStroke(3));
            else if(size>30)
                g2.setStroke(new BasicStroke(2));
            else
                g2.setStroke(new BasicStroke(1));
            g2.drawLine(x_front, y_front, x_front+size/10, y_front+size/10);
            g2.setStroke(new BasicStroke(1));
        }
    }


}
