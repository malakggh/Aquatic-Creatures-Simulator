package p1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import static p1.AquaFrame.food;

public class AquaPanel extends JPanel implements ActionListener{


    private Image bg;
    private HashSet<Swimmable> swimmableSet;
    private JLabel foodLabel;
    public AquaPanel(){
        swimmableSet=new HashSet<Swimmable>();
        setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        bg=null;
        foodLabel=new JLabel("<html><span style='font-size:25px'>"+"S"+"</span></html>");
        foodLabel.setForeground(Color.red);
        add(foodLabel);
        foodLabel.setVisible(false);
        this.setVisible(true);
    }

    public HashSet<Swimmable> getSwimmableSet(){return swimmableSet;}

    public void setBg(Image bg){
        this.bg=bg;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if(bg!=null){
            g2d.drawImage(bg,0,0,null);
        }
        if (food){
            foodLabel.setBounds(this.getSize().width/2,this.getSize().height/2,50,50);
            foodLabel.setVisible(true);
        }else {
            foodLabel.setVisible(false);
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
