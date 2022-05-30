package p1;

import javax.swing.*;

public class Worm {

    static private volatile Worm instance = null;
    private boolean state;
    private Worm(){
        state=false;
    }
    public static Worm getInstance(){
        if (instance == null)
            synchronized(Worm.class){
                if (instance == null)
                    instance = new Worm();
            }
        return instance;
    }
    public boolean getState(){return state;}
    public void setState(boolean x){state=x;}
    public void paintWorm(AquaPanel x ,JLabel foodLabel){
        foodLabel.setBounds(x.getSize().width/2,x.getSize().height/2,50,50);
        foodLabel.setVisible(true);
    }
    public void unpaintWorm(JLabel foodLabel){
        foodLabel.setVisible(false);
    }
}

