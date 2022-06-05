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
import java.util.concurrent.CyclicBarrier;

import static p1.AquaFrame.barrier;
import static p1.AquaFrame.mainPanel;

public class AddAnimalDialog extends JDialog implements ActionListener {
    String[] fishTypes = {"Fish","Jellyfish"};
    String[] fishColors = {"Black","Red","Blue","Green","Cyan","Orange","Yellow","Magenta","Pink"};
    JComboBox<String> comboBoxFishType;
    JComboBox<String> comboBoxFishColor;
    String[] labelsText = {"Type: ","Size(20-320): ","Ver Speed(1-10): ","Hor Speed(1-10): ","Color: "};
    JLabel[] labels = new JLabel[5];
    JTextField sizeBox,verBox,horBox;
    JPanel panel;
    JButton addFish;
    HashSet<Swimmable> swimmableSetRef;
    AddAnimalDialog(HashSet<Swimmable> swimmableSet){
        swimmableSetRef=swimmableSet;
        panel=new JPanel();
        panel.setSize(new Dimension(500,300));
        this.setLayout(new FlowLayout(FlowLayout.LEFT,20,25));
        for(int i=0;i<5;i++){
            labels[i] = new JLabel(labelsText[i]);
        }
        comboBoxFishType = new JComboBox<String>(fishTypes);
        comboBoxFishType.addActionListener(this);
        panel.add(labels[0]);
        panel.add(comboBoxFishType);
        panel.add(labels[1]);
        sizeBox = new JTextField("20");
        panel.add(sizeBox);
        panel.add(labels[2]);
        verBox = new JTextField("1");
        panel.add(verBox);
        panel.add(labels[3]);
        horBox = new JTextField("1");
        panel.add(horBox);
        panel.add(labels[4]);
        comboBoxFishColor=new JComboBox<String>(fishColors);
        comboBoxFishColor.addActionListener(this);
        panel.add(comboBoxFishColor);
        add(panel);

        addFish=new JButton("Submit");
        addFish.addActionListener(this);
        add(addFish);

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
        String input="";
        if (e.getSource() == addFish) {
            do {
                input = (String)JOptionPane.showInputDialog(this,
                        "Please enter creature eat frequency:",
                        "EatFreq",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        "3000");
                if (input == null){
                    break;
                }
            } while (!input.matches("^[0-9]*$") );

            AnimalFactory animalFactory=new AnimalFactory(Integer.parseInt(sizeBox.getText()), Integer.parseInt(horBox.getText()),Integer.parseInt(verBox.getText()),comboBoxFishColor.getSelectedIndex() + 1,Integer.parseInt(input));
            Swimmable Creature= (Swimmable) animalFactory.produceSeaCreature(comboBoxFishType.getSelectedItem().toString());
            Creature.addPropertyChangeListener(mainPanel);
            swimmableSetRef.add(Creature);
            Creature.start();


            barrier = new CyclicBarrier(swimmableSetRef.size());
            this.dispose();
        }
    }
}
