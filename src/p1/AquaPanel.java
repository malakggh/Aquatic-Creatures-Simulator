package p1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class AquaPanel extends JPanel implements ActionListener{

    private HashSet<Swimmable> swimmableSet;
    public AquaPanel(){
        swimmableSet=new HashSet<Swimmable>();
        setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        this.setVisible(true);
    }

    public HashSet<Swimmable> getSwimmableSet(){return swimmableSet;}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Swimmable swimmable : swimmableSet) {
            System.out.println(swimmable);
            swimmable.setX_front(swimmable.getX_front()+swimmable.getHorSpeed());
            swimmable.setY_front(swimmable.getY_front()+swimmable.getVerSpeed());
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
