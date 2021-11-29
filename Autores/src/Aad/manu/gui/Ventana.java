package Aad.manu.gui;

import com.toedter.calendar.JTextFieldDateEditor;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ventana {

    //Elementos de la ventana(swing)

    private JPanel panel1;


    private JLabel textId;
    private JLabel textNombre;
    private JLabel textPriApellido;
    private JLabel textSegApellido;
    private JLabel textFechaNac;

    public JTextField textFieldId;
    public JTextField textFieldNombre;
    public JTextField textFieldPriApellido;
    public JTextField textFieldSegAepllido;
    public JTextField textFieldFechanac;
    public JTextField textFieldBuscar;

    public JButton nuevoButton;
    public JButton guardarButton;
    public JButton modificarButton;
    public JButton eliminarButton;
    public JButton eliminarTodosButton;
    public JButton buscarButton;

    public JTextPane buscarTextPane;

    public Ventana() {
        JFrame frame = new JFrame("Autores");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        textFieldId.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });

    }

}
