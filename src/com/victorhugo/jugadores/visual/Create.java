package com.victorhugo.jugadores.visual;

import com.victorhugo.jugadores.dao.CreateDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Class prepared for create/add a new register on the database
 * */
public class Create extends JPanel implements CreateDAO {

    public Create(){
        setLayout(null);
        this.setBackground(bgColor);

        nombre = new JLabel("Nombre:");
        campo1 = new JTextField();
        apellidoPaterno = new JLabel("Apellido paterno:");
        campo2 = new JTextField();
        apellidoMaterno = new JLabel("Apellido materno:");
        campo3 = new JTextField();
        fechaNacimiento = new JLabel("Fecha de nacimiento:");
        campo4 = new JTextField();
        campo4.setUI(new JTextFieldHintUI("dd/MM/yyyy",fontColor));
        juegosGanados = new JLabel("Juegos ganados:");
        campo5 = new JTextField();
        codigoJGanado = new JLabel("Código juego ganado:");
        campo6 = new JTextField();
        register = new JButton("Register");
        cancel = new JButton("Cancel");

        //Styles.
        nombre.setFont(textFont);
        nombre.setForeground(fontColor);
        apellidoPaterno.setFont(textFont);
        apellidoPaterno.setForeground(fontColor);
        apellidoMaterno.setFont(textFont);
        apellidoMaterno.setForeground(fontColor);
        fechaNacimiento.setFont(textFont);
        fechaNacimiento.setForeground(fontColor);
        juegosGanados.setFont(textFont);
        juegosGanados.setForeground(fontColor);
        codigoJGanado.setFont(textFont);
        codigoJGanado.setForeground(fontColor);

        campo1.setFont(fieldFont);
        campo1.setBackground(Color.white);
        campo1.setBorder(null);

        campo2.setFont(fieldFont);
        campo2.setBorder(null);
        campo2.setBackground(Color.white);

        campo3.setFont(fieldFont);
        campo3.setBorder(null);
        campo3.setBackground(Color.white);

        campo4.setFont(fieldFont);
        campo4.setBorder(null);
        campo4.setBackground(Color.white);


        campo5.setFont(fieldFont);
        campo5.setBorder(null);
        campo5.setBackground(Color.white);

        campo6.setFont(fieldFont);
        campo6.setBorder(null);
        campo6.setBackground(Color.white);

        register.setFont(new Font("Segoe UI", Font.BOLD,20));
        register.setBorder(null);
        register.setBackground(buttonColor);

        cancel.setFont(new Font("Segoe UI", Font.BOLD,20));
        cancel.setBorder(null);
        cancel.setBackground(buttonColor);

        //Bounds.
        add(nombre); nombre.setBounds(32,32,110,35);
        add(campo1); campo1.setBounds(302, 32, 180, 35);
        add(apellidoPaterno); apellidoPaterno.setBounds(32,80, 213,35);
        add(campo2); campo2.setBounds(302, 80, 180, 35);
        add(apellidoMaterno); apellidoMaterno.setBounds(32,128, 221, 35);
        add(campo3); campo3.setBounds(302,128, 180, 35);
        add(fechaNacimiento); fechaNacimiento.setBounds(32, 176,258,35);
        add(campo4); campo4.setBounds(302, 176, 180, 35);

        add(juegosGanados); juegosGanados.setBounds(562,32,202,35);
        add(campo5); campo5.setBounds(848,32,94,35);
        add(codigoJGanado); codigoJGanado.setBounds(562,80,270,35);
        add(campo6); campo6.setBounds(848,80,94,35);

        add(register); register.setBounds(593,355,140,39);
        add(cancel); cancel.setBounds(789,355,140,39);

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = (String) campo1.getText();
                String lastNameP = (String) campo2.getText();
                String lastNameM = (String) campo3.getText();
                String birthday = (String) campo4.getText();
                int gamesWon = Integer.valueOf(campo5.getText());
                int gameCodeWon = Integer.valueOf(campo6.getText());

                java.util.Date bd = null;
                try {
                    bd = new SimpleDateFormat("dd/MM/yyyy").parse(birthday);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

                java.sql.Date sql = new java.sql.Date(bd.getTime());

                Create c = new Create();

                c.setField(name,lastNameP,lastNameM,sql,gamesWon,gameCodeWon);

            }
        });

    }

   //Swing/AWT components
    private JLabel nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, juegosGanados, codigoJGanado;
    private JTextField campo1, campo2, campo3, campo4, campo5, campo6;
    private JButton register, cancel;
    private Font textFont = new Font("Segoe UI",Font.BOLD,26);
    private Font fieldFont = new Font("Segoe UI",Font.PLAIN,20);

    //Colors
    private Color fontColor = new Color(112,112,112); //Grey color.
    private final Color bgColor = new Color(236,236,217);
    private final Color buttonColor = new Color(201,193,193);
}
