/**
 * Student 1 Name: Malak Ghrayeb
 * Id 1: ***REMOVED***
 * Student 2 Name: Saher Samara
 * Id 2: ***REMOVED***
 */
package p1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static p1.AquaFrame.buttonsPanel;
import static p1.AquaFrame.mainPanel;

public class JPanelDecorator extends JPanel implements ActionListener {

    private DefaultTableModel model;
    private JTable table;

    private JScrollPane sp;

    private JButton changeColor;

    private JButton Close;
    private HashSet<Swimmable> swimmableSet;

    public JPanelDecorator(HashSet<Swimmable> swimmableSet) {
        setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        changeColor = new JButton("Change color");
        Close = new JButton("Close");
        Close.addActionListener(this);
        add(Close, BorderLayout.SOUTH);
        changeColor.addActionListener(this);
        add(changeColor, BorderLayout.SOUTH);
        model = new DefaultTableModel();
        table = new JTable(model);
        model.addColumn("Index");
        model.addColumn("Animal");
        model.addColumn("Color");
        model.addColumn("Size");
        model.addColumn("Hor.speed");
        model.addColumn("Ver.speed");
        model.addColumn("Eat counter");
        sp = new JScrollPane(table);
        add(sp);
        this.swimmableSet = swimmableSet;
        infoUpdate();
    }

    public void infoUpdate() {
        int index = 0;

        int eatTotal = 0;
        for (Swimmable swimmable : swimmableSet) {
            model.insertRow(model.getRowCount(), new Object[] { index, swimmable.getAnimalName(), swimmable.getColor(),
                    String.valueOf((swimmable.getSize())), String.valueOf(swimmable.horSpeed),
                    String.valueOf(swimmable.verSpeed),
                    String.valueOf(swimmable.getEatCount()) });
            index++;
            eatTotal += swimmable.getEatCount();
        }
        model.insertRow(model.getRowCount(),
                new Object[] { "Total", "", " ", " ", " ", " ", String.valueOf(eatTotal) });
        model.insertRow(model.getRowCount(), new Object[] { "", " ", " ", " ", " ", "" });

        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == changeColor) {
            String input = "";
            do {
                do {
                    input = (String) JOptionPane.showInputDialog(this,
                            "Enter Animal Index",
                            "Animal chooser",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            null,
                            "0");
                    if (input == null) {
                        break;
                    }
                } while (!input.matches("^[0-9]*$") || input.length() != 1);
                if (input == null) {
                    break;
                }
            } while (!(Integer.parseInt(input) >= 0 && Integer.parseInt(input) < swimmableSet.size()));
            int counter = 0;
            Swimmable targetFish = null;
            for (Swimmable swimmable : swimmableSet) {
                if (counter == Integer.parseInt(input)) {
                    targetFish = swimmable;
                }
                counter++;
            }
            Color initialcolor = Color.RED;
            Color color = JColorChooser.showDialog(this, "Select a color", initialcolor);
            if (targetFish != null) {
                MarineAnimal targetFish1 = targetFish;
                targetFish1.PaintFish(color);
            }
        } else if (e.getSource() == Close) {
            this.setVisible(false);
            mainPanel.setVisible(true);
            buttonsPanel.setVisible(true);
        }
    }
}
