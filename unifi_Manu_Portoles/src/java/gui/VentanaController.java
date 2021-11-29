package java.gui;


import java.Datos.CsvUtil;
import java.Datos.MongoUtil;
import java.Objetos.Hotspotop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaController implements ActionListener {
    //Variables para la ventana y manejador de datos
    private final VentanaDatosCsv ventana;
    private final CsvUtil datosCsv;
    private final MongoUtil datosMongo;

    public VentanaController(VentanaDatosCsv ventana, MongoUtil datosMongo, CsvUtil datosCsv) {
        this.datosCsv = datosCsv;
        this.datosMongo = datosMongo;
        this.ventana = ventana;

        addEventListeners(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();

        if ("SubirDatos".equals(accion)) {
            List<Hotspotop> listaDatos = datosCsv.listaDatosCsv("datos");
            for (Hotspotop dato: listaDatos) {
                datosMongo.addDatos(dato);
                ventana.textAreaLogs.append(dato.getName());
            }
        }
    }

    private void addEventListeners(ActionListener listener) {
        ventana.btnSubirDatos.addActionListener(listener);
    }

}
