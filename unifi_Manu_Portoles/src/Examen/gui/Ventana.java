package Examen.gui;

import javax.swing.*;

public class Ventana {
    public JButton btnSubirDatos;
    private JPanel panel1;
    public JTextArea textAreaLogs;

    public Ventana(){
        JFrame frame = new JFrame("Integra");
        frame.setContentPane(panel1);
        frame.setBounds(100, 100, 600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

    }
}
