package p1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class AquaPanel extends JPanel implements ActionListener{

    Timer timer;
    private Image bg;
    private HashSet<Swimmable> swimmableSet;
    public AquaPanel(){
        swimmableSet=new HashSet<Swimmable>();
        setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        bg=null;
        timer=new Timer(10,this);
        timer.start();
        this.setVisible(true);
    }

    public HashSet<Swimmable> getSwimmableSet(){return swimmableSet;}

    public void setBg(Image bg){
        this.bg=bg;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(bg!=null){
            g.drawImage(bg,0,0,null);
        }
        for (Swimmable swimmable : swimmableSet) {
            if(swimmable.getX_front()>=this.getSize().width){
                swimmable.flip_Xdir();
                swimmable.setX_front((int) (swimmable.getX_front()-swimmable.getSize()*1.253452525));
            }
            if(swimmable.getX_front()<0){
                swimmable.flip_Xdir();
                swimmable.setX_front((int) (swimmable.getX_front()+swimmable.getSize()*1.253452525));
            }

            if(swimmable.getY_front()>=this.getSize().height||swimmable.getY_front()<0){
                swimmable.flip_Ydir();
            }
            swimmable.setX_front(swimmable.getX_front()+swimmable.getHorSpeed()*swimmable.get_Xdir());
            swimmable.setY_front(swimmable.getY_front()+swimmable.getVerSpeed()*swimmable.get_Ydir());
            swimmable.drawAnimal(g);
        }
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        repaint();
    }
}
