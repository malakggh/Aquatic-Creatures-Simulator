/**
 * Student 1 Name: Malak Ghrayeb
 * Id 1: ***REMOVED***
 * Student 2 Name: Saher Samara
 * Id 2: ***REMOVED***
 */
package p1;

import javax.naming.directory.SearchControls;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CyclicBarrier;

public class AquaFrame extends JFrame implements ActionListener {
    private HashSet<Swimmable> swimmableSet;
    private HashSet<Immobile> immobileSet;
    private JButton[] buttons;
    private String[] buttonNames = {"Add Animal","Sleep","Wake Up","Reset","Food","Info","Exit","Add Plant","Duplicate Animal","Decorator"};
    public static JPanel buttonsPanel;
    private AddAnimalDialog addAnimalDialog;
    private AddPlantDialog addPlantDialog;
    public static AquaPanel mainPanel;

    private JPanelDecorator jPanelDecorator;
    private JMenu jMenuFile,jMenuBackground,jMenuHelp,jMenuMemento;
    private JMenuItem jMenuItemExit,jMenuItemImage,jMenuItemBlue,jMenuItemNone,jMenuItemHelp,jMenuItemSave,jMenuItemRestore;
    public static boolean sleep;
    public static Worm food;
    public static CyclicBarrier barrier;
    private Memento memento;

    public AquaFrame(String title){
        super(title);
        buttons = new JButton[buttonNames.length];
        sleep=false;
        food=Worm.getInstance();
        memento=null;
        jMenuFile = new JMenu("File");
        jMenuItemExit = new JMenuItem("Exit");
        jMenuFile.add(jMenuItemExit);

        jMenuBackground = new JMenu("Background");
        jMenuItemImage = new JMenuItem("Image");
        jMenuItemBlue = new JMenuItem("Blue");
        jMenuItemNone = new JMenuItem("None");
        jMenuBackground.add(jMenuItemImage);
        jMenuBackground.add(jMenuItemBlue);
        jMenuBackground.add(jMenuItemNone);

        jMenuHelp = new JMenu("Help");
        jMenuItemHelp = new JMenuItem("Help");
        jMenuHelp.add(jMenuItemHelp);

        jMenuMemento = new JMenu("Memento");
        jMenuItemSave = new JMenuItem("Save Object State");
        jMenuItemRestore = new JMenuItem("Restore Object State");
        jMenuMemento.add(jMenuItemSave);
        jMenuMemento.add(jMenuItemRestore);

        JMenuBar mb = new JMenuBar();
        mb.add(jMenuFile);
        mb.add(jMenuBackground);
        mb.add(jMenuHelp);
        mb.add(jMenuMemento);
        setJMenuBar(mb);

        jMenuItemExit.addActionListener(this);
        jMenuItemImage.addActionListener(this);
        jMenuItemBlue.addActionListener(this);
        jMenuItemNone.addActionListener(this);
        jMenuItemHelp.addActionListener(this);
        jMenuItemSave.addActionListener(this);
        jMenuItemRestore.addActionListener(this);


        mainPanel = new AquaPanel();
        swimmableSet=mainPanel.getSwimmableSet();
        immobileSet=mainPanel.getImmobileSet();
        add(mainPanel);

        buttonsPanel = new JPanel();
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder());
        buttonsPanel.setLayout(new GridLayout(1, buttonNames.length));
        for (int i = 0; i < buttonNames.length; i++) {
            buttons[i]=new JButton(buttonNames[i]);
            buttonsPanel.add(buttons[i]);
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        buttonsPanel.setPreferredSize(new Dimension(50,50));
        add(buttonsPanel,BorderLayout.SOUTH);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200,800);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jMenuItemExit || e.getSource() == buttons[6]){
            System.exit(0);
        }else if(e.getSource()==jMenuItemImage){
            addBgImage();
        }else if(e.getSource()==jMenuItemBlue){
            mainPanel.setBackground(Color.blue);
            mainPanel.setBg(null);
        }else if(e.getSource()==jMenuItemNone){
            mainPanel.setBackground(Color.white);
            mainPanel.setBg(null);
        }else if(e.getSource()==jMenuItemHelp){
            JOptionPane.showMessageDialog(null, "Home Work 3\nGUI @ Threads", "Message", JOptionPane.INFORMATION_MESSAGE);
        }else if(e.getSource()== buttons[0]){
            if(swimmableSet.size()<5) {
                addAnimalDialog = new AddAnimalDialog(swimmableSet);

            }
        }
        else if(e.getSource()== buttons[1]){
            sleep=true;
        }else if(e.getSource()== buttons[2]){
            synchronized (this) {
                if (sleep){
                    sleep = false;

                    for (Swimmable swimmable:swimmableSet){
                        swimmable.wakeUp();
                    }
                }

            }
        }else if(e.getSource()==buttons[3]){
            for (Swimmable swimmable:swimmableSet){
                swimmable.Active(false);
            }
            swimmableSet.clear();
            immobileSet.clear();
            memento=null;
            food.setState(false);
            mainPanel.repaint();
            mainPanel.resetCounter();

        }else if(e.getSource()==buttons[4]){
            if (swimmableSet.size()!=0){
                food.setState(true);

            }
        }
        else if(e.getSource()==buttons[5]){
            mainPanel.infoUpdate();
        }
        else if(e.getSource()==buttons[7]){
            if(immobileSet.size()<5) {
                addPlantDialog = new AddPlantDialog(immobileSet);
            }
        }else if(e.getSource()== buttons[8]){
            if(swimmableSet.size()<5 && swimmableSet.size() > 0) {
                int input = pickAnimalOrPlant("Please enter animal index from table", "Duplicate Animal",swimmableSet.size());
                assert input != -1;
                Swimmable targetFish=null;
                int counter=0;
                for (Swimmable swimmable : swimmableSet){
                    if (counter==input){
                        targetFish=swimmable;
                    }
                    counter++;
                }
                assert targetFish != null;
                Swimmable clonedFish= targetFish.clone();
                clonedFish.upgrade();
                clonedFish.addPropertyChangeListener(mainPanel);
                swimmableSet.add(clonedFish);
                clonedFish.start();
            }
        }else if (e.getSource() == jMenuItemSave){
            if(swimmableSet.size() > 0 || immobileSet.size() > 0) {
                int input = pickAnimalOrPlant("Please pick index from table","Pick Index", swimmableSet.size()+immobileSet.size());
                assert input != -1;
                SeaCreature seaCreature =null;
                int counter=0;
                for (Swimmable swimmable : swimmableSet){
                    if (counter==input){
                        seaCreature=swimmable;
                    }
                    counter++;
                }
                for (Immobile immobile : immobileSet){
                    if (counter==input){
                        seaCreature=immobile;
                    }
                    counter++;
                }
                if (seaCreature!=null) {
                    memento = new Memento(seaCreature);
                }
            }
        }else if (e.getSource() == jMenuItemRestore){
            if (memento!=null){
                SeaCreature seaCreature = memento.getState();
                if (seaCreature instanceof Swimmable){
                    Swimmable swimmable = (Swimmable) memento.getCreatureReference();
                    swimmable.update((Swimmable) seaCreature);
                }else if (seaCreature instanceof Immobile){
                    Immobile immobile = (Immobile) memento.getCreatureReference();
                    immobile.update((Immobile) seaCreature);
                }
            }
        }
        else if(e.getSource()== buttons[9]){
            if(swimmableSet!=null) {
                jPanelDecorator = new JPanelDecorator(swimmableSet);
                add(jPanelDecorator);
                jPanelDecorator.setVisible(true);
                mainPanel.setVisible(false);
                buttonsPanel.setVisible(false);
            }
        }

    }



    private int pickAnimalOrPlant(String message,String title,int len){
        String input="";
        mainPanel.infoUpdate();
        do {
            do {
                input = (String)JOptionPane.showInputDialog(this,
                        message,
                        title,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        "0");
                if (input == null){
                    break;
                }
            } while (!input.matches("^[0-9]*$") || input.length() != 1) ;
            if (input == null){
                break;
            }
        }while (!(Integer.parseInt(input) >= 0 && Integer.parseInt(input) < len));
        mainPanel.infoUpdate();
        if (input == null){
            return -1;
        }
        return Integer.parseInt(input);
    }

    private void addBgImage(){
//        String url = (String)JOptionPane.showInputDialog(this,
//                "Please enter image path",
//                "Image Background",
//                JOptionPane.PLAIN_MESSAGE,
//                null,
//                null,
//                "bg1.png");
        JFileChooser fileChooser = new JFileChooser();
        int res = fileChooser.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION){
            File url = new File(fileChooser.getSelectedFile().getAbsolutePath()) ;
            mainPanel.setBackground(Color.white);
            mainPanel.setBg(new ImageIcon(url.toString()).getImage());
            mainPanel.repaint();
        }
    }
    public static void main(String[] args) {
        AquaFrame frame = new AquaFrame("My Aquarium");
        frame.setVisible(true);
    }
}
