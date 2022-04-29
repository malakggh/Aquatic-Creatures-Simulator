package p1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashSet;

import static p1.AquaFrame.food;

public class AquaPanel extends JPanel implements PropertyChangeListener {


    private Image bg;
    private HashSet<Swimmable> swimmableSet;
    private JLabel foodLabel;
    private DefaultTableModel model;
    private JTable table;

    private JScrollPane sp;

    private int eatTotal;

    private int infoCounter;
    public AquaPanel(){
        infoCounter=1;
        eatTotal=0;
        swimmableSet=new HashSet<Swimmable>();
        setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        bg=null;
        foodLabel=new JLabel("<html><span style='font-size:25px'>"+"S"+"</span></html>");
        foodLabel.setForeground(Color.red);

        model = new DefaultTableModel();
        table = new JTable(model);
        model.addColumn("Animal");
        model.addColumn("Color");
        model.addColumn("Size");
        model.addColumn("Hor.speed");
        model.addColumn("Ver.speed");
        model.addColumn("Eat counter");
        sp=new JScrollPane(table);
        add(sp);
        table.setVisible(false);
        sp.setVisible(false);

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
        sp.setSize(new Dimension(this.getSize().width,this.getSize().height));
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
    public void infoUpdate() {

        if (infoCounter % 2 == 1) {
            infoCounter++;
            for (Swimmable swimmable : swimmableSet) {
                model.insertRow(model.getRowCount(), new Object[]{swimmable.getAnimalName(), swimmable.getColor(),
                        String.valueOf((swimmable.getSize())), String.valueOf(swimmable.horSpeed), String.valueOf(swimmable.verSpeed),
                        String.valueOf(swimmable.getEatCount())});
            }
            model.insertRow(model.getRowCount(),new Object[]{"Total"," "," "," "," ",String.valueOf(eatTotal)});
            table.setVisible(true);
            sp.setVisible(true);
        }
        else{
            model.setRowCount(0);
            table.setVisible(false);
            sp.setVisible(false);
            infoCounter++;
        }
        this.repaint();
    }


    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        synchronized (this) {
            ((Swimmable) evt.getSource()).eatInc();
            eatTotal++;
            food = false;
        }

    }
    public void resetCounter(){
        eatTotal=0;
    }
}
