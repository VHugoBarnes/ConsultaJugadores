package com.victorhugo.jugadores.visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Enumeration;

public class MainFrame extends JFrame {

    /**
     * Constructor de la clase.
     * */
    public MainFrame(String title){
        try
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            UIManager.put("TabbedPane.tabsOpaque",true);
            UIManager.put("TabbedPane.selected",tabColor);
            UIManager.put("TabbedPane.shadow",bgColor);
            UIManager.put("TabbedPane.unselectedBackground",bgColor);
            UIManager.put("TabbedPane.unselectedTabBackground",bgColor);
            UIManager.put("TabbedPane.contentAreaColor",tabColor);
        } catch (Exception ee){
            ee.printStackTrace();
        }
        this.title = title;

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(width,height);
        setLocation(0,0);
        setTitle(this.title);

        jTitle = new JLabel(this.title);
        separator = new JSeparator(SwingConstants.HORIZONTAL);
        pestanas = new JTabbedPane();

        //Instances of CRUD's panels.
        Create create = new Create();
        Read read = new Read();
        Update update = new Update();
        Delete delete = new Delete();

        //Add Icons for tabs.
        iCreate = new ImageIcon("src/img/create.png");
        iRead = new ImageIcon("src/img/read.png");
        iUpdate = new ImageIcon("src/img/update.png");
        iDelete = new ImageIcon("src/img/delete.png");

        //Add CRUD panels in the tab class.
        pestanas.addTab(sCreate,iCreate,create,descCreate);
        pestanas.addTab(sRead,iRead,read,descRead);
        pestanas.addTab(sUpdate,iUpdate,update,descUpdate);
        pestanas.addTab(sDelete,iDelete,delete,descDelete);

        //Bounds and Style.

        this.getContentPane().setBackground(bgColor);

        jTitle.setFont(new Font("Segoe UI",Font.BOLD,35));
        jTitle.setForeground(fontColor);

        separator.setBackground(fontColor);

        pestanas.setFont(new Font("Lato",Font.BOLD,18));
        pestanas.setBackground(tabColor);
        pestanas.setForegroundAt(0,fontColor);
        pestanas.setForegroundAt(1,fontColor);
        pestanas.setForegroundAt(2,fontColor);
        pestanas.setForegroundAt(3,fontColor);

        add(jTitle); jTitle.setBounds(32,32,425,47);
        add(separator); separator.setBounds(32,92,960,10);
        add(pestanas); pestanas.setBounds(33,93,962,446);


    }

    //Swing/AWT components.
    private JTabbedPane pestanas;
    private ImageIcon iCreate, iRead, iUpdate, iDelete;
    private JLabel jTitle;
    private JSeparator separator;
    private final Color bgColor = new Color(248,248,241); //sand color.
    private Color tabColor = new Color(236,236,217); //idk color.
    private Color fontColor = new Color(112,112,112); //Grey color.

    //========================================================
    private String title;
    private int width = 1024, height = 600;
    private final String sCreate = "Create", sRead = "Read",
            sUpdate = "Update", sDelete = "Delete";
    private final String descCreate = "Create a new table or field in database.",
            descRead = "Read the information in database.",
            descUpdate = "Update information on a field in database.",
            descDelete = "Delete information on a field in database.";
}
