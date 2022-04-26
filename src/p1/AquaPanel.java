package p1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class AquaPanel extends JPanel implements ActionListener{


    private Image bg;
    private HashSet<Swimmable> swimmableSet;
    public AquaPanel(){
        swimmableSet=new HashSet<Swimmable>();
        setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        bg=null;
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
    }
}
