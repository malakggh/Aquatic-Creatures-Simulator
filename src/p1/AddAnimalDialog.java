package p1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class AddAnimalDialog extends JDialog implements ActionListener {
    String[] fishTypes = {"Fish","Jellyfish"};
    String[] fishColors = {"Black","Red","Blue","Green","Cyan","Orange","Yellow","Magenta","Pink"};
    JComboBox<String> comboBoxFishType;
    JComboBox<String> comboBoxFishColor;
    String[] labelsText = {"Type: ","Size(20-320): ","Ver Speed(1-10): ","Hor Speed(1-10): ","Color: "};
    JLabel[] labels = new JLabel[5];
    JTextField sizeBox,verBox,horBox;

    AddAnimalDialog(HashSet<Swimmable> swimmableSet){
        for(int i=0;i<5;i++){
            labels[i] = new JLabel(labelsText[i]);
        }
        comboBoxFishType = new JComboBox<String>(fishTypes);
        comboBoxFishType.setSize(new Dimension(250,100));
        add(labels[0]);
        add(comboBoxFishType);
        add(labels[1]);
        sizeBox = new JTextField();
        add(sizeBox);
        add(labels[2]);
        verBox = new JTextField();
        add(verBox);
        add(labels[3]);
        horBox = new JTextField();
        add(horBox);
        add(labels[4]);
        comboBoxFishColor=new JComboBox<String>(fishColors);
        add(comboBoxFishColor);


        this.setLayout(new GridLayout(5,2,80,80));
        this.setSize(new Dimension(600,800));
        setVisible(true);

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
