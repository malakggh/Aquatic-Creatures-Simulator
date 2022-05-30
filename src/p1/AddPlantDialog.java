/**
 * Student 1 Name: Malak Ghrayeb
 * Id 1: ***REMOVED***
 * Student 2 Name: Saher Samara
 * Id 2: ***REMOVED***
 */
package p1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import static p1.AquaFrame.mainPanel;

public class AddPlantDialog extends JDialog implements ActionListener {
    String[] plantTypes = {"Zostera","Laminaria"};
    JComboBox<String> comboBoxPlantType;

    String[] labelsText = {"Type: ","Size(100-400): ","X-location: ","Y-location: "};
    JLabel[] labels = new JLabel[4];
    JTextField sizeBox,X_LBox,Y_LBox;
    JPanel panel;
    JButton addPlant;
    HashSet<Immobile> immobileSetRef;
    AddPlantDialog(HashSet<Immobile> immobileSet){
        immobileSetRef=immobileSet;
        panel=new JPanel();
        panel.setSize(new Dimension(500,300));
        this.setLayout(new FlowLayout(FlowLayout.LEFT,20,25));
        for(int i=0;i<4;i++){
            labels[i] = new JLabel(labelsText[i]);
        }
        comboBoxPlantType = new JComboBox<String>(plantTypes);
        comboBoxPlantType.addActionListener(this);
        panel.add(labels[0]);
        panel.add(comboBoxPlantType);
        panel.add(labels[1]);
        sizeBox = new JTextField("20");
        panel.add(sizeBox);
        panel.add(labels[2]);
        X_LBox = new JTextField("1");
        panel.add(X_LBox);
        panel.add(labels[3]);
        Y_LBox = new JTextField("1");
        panel.add(Y_LBox);
        add(panel);

        addPlant=new JButton("Submit");
        addPlant.addActionListener(this);
        add(addPlant);

        panel.setVisible(true);
        panel.setLayout(new GridLayout(5,2,80,80));
        this.setSize(new Dimension(350,600));
        setVisible(true);

    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addPlant) {
            PlantFactory planetFactory = new PlantFactory(Integer.parseInt(sizeBox.getText()), Integer.parseInt(X_LBox.getText()) % mainPanel.getWidth(), Integer.parseInt(Y_LBox.getText()) % mainPanel.getHeight());
            Immobile Creature = (Immobile) planetFactory.produceSeaCreature(comboBoxPlantType.getSelectedItem().toString());
            immobileSetRef.add(Creature);
            mainPanel.repaint();
            this.dispose();
        }
    }
}
