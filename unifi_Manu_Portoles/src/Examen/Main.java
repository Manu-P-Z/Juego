package Examen;


import Examen.Datos.CsvUtil;
import Examen.gui.VentanaController;
import Examen.gui.Ventana;

import javax.swing.*;

import Examen.Datos.MongoUtil;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());

        // Instanciar Ventana
        Ventana ventana = new Ventana();
        MongoUtil datosMongo = new MongoUtil();
        CsvUtil datosCsv = new CsvUtil();

        VentanaController controlador = new VentanaController(ventana,datosMongo,datosCsv);

    }
}
