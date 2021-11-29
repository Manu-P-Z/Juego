package java;


import javax.swing.*;
import java.Datos.CsvUtil;
import java.Datos.MongoUtil;
import java.gui.VentanaController;
import java.gui.VentanaDatosCsv;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());

        // Instanciar Ventana
        VentanaDatosCsv ventana = new VentanaDatosCsv();
        MongoUtil datosMongo = new MongoUtil();
        CsvUtil datosCsv = new CsvUtil();

        VentanaController controlador = new VentanaController(ventana,datosMongo,datosCsv);

    }
}
