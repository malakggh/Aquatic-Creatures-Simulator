package p1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;

public class AquaFrame extends JFrame implements ActionListener {
    private HashSet<Swimmable> swimmableSet;

    private JButton[] buttons = new JButton[7];
    private String[] buttonNames = {"Add Animal","Sleep","Wake Up","Reset","Food","Info","Exit"};
    private JPanel buttonsPanel;

    private AddAnimalDialog addAnimalDialog;

    private AquaPanel mainPanel;
    private JMenu jMenuFile,jMenuBackground,jMenuHelp;
    private JMenuItem jMenuItemExit,jMenuItemImage,jMenuItemBlue,jMenuItemNone,jMenuItemHelp;
    public AquaFrame(String title){
        super(title);

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

        JMenuBar mb = new JMenuBar();
        mb.add(jMenuFile);
        mb.add(jMenuBackground);
        mb.add(jMenuHelp);
        setJMenuBar(mb);

        jMenuItemExit.addActionListener(this);
        jMenuItemImage.addActionListener(this);
        jMenuItemBlue.addActionListener(this);
        jMenuItemNone.addActionListener(this);
        jMenuItemHelp.addActionListener(this);


        mainPanel = new AquaPanel();
        swimmableSet=mainPanel.getSwimmableSet();
        add(mainPanel);

        buttonsPanel = new JPanel();
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder());
        buttonsPanel.setLayout(new GridLayout(1, 7));
        for (int i = 0; i < 7; i++) {
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
            if(swimmableSet.size()<=5) {
                addAnimalDialog = new AddAnimalDialog(swimmableSet);
                addAnimalDialog.setVisible(true);
            }
        }
        else if(e.getSource()== buttons[1]){

        }
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
        }
    }
    public static void main(String[] args) {
        AquaFrame frame = new AquaFrame("My Aquarium");
        frame.setVisible(true);
    }
}
