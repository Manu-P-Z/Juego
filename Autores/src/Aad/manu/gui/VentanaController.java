package Aad.manu.gui;

import Aad.manu.datos.AccesoADatos;
import Aad.manu.objects.Autor;
import org.bson.types.ObjectId;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showMessageDialog;

public class VentanaController implements ActionListener {
    //Variables para la ventana y manejador de datos
    private final Ventana ventana;
    private final AccesoADatos datos;
    //Método para instanciar ventana y datos desde el main

    public VentanaController(Ventana ventana, AccesoADatos datos) {
        this.datos = datos;
        this.ventana = ventana;

        //Muestra los objetos en el campo de texto lateral
        buscarTodos();

        //Añadir todos los actionListeners(Código abajo del todo)
        addEventListeners(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        Autor autor = new Autor();
        System.out.println(accion);
        switch (accion) {
            case "Nuevo":

                //Pone todos los campos en blanco
                resetInput();
                break;
            case "Guardar":
                //Asigna valores a un nuevo objeto


                if (compobarCampos()) {

                    autor = asignarAtributos(autor);

                    datos.addautor(autor);
                    showMessageDialog(null, "Se ha guardado el autor");
                    buscarTodos();
                }
                break;

            case "Modificar":

                //Modifica objeto segun campo
                if (compobarCampos()) {

                    autor = asignarAtributos(autor);
                    datos.modificarautor(autor.getId(), autor);
                    showMessageDialog(null, "Se ha modificado la entrada ");
                }
                break;

            case "Eliminar":

                //elimina el objeto con campo especificado
                if (ventana.textFieldId.getText().isEmpty()) {
                    showMessageDialog(null, "Escriba el id que quiera eliminar en el campo id*");

                } else {
                    try {
                        datos.borrarautor(new ObjectId(String.format("%024d", Long.parseLong(ventana.textFieldId.getText()))));
                        showMessageDialog(null, "Se ha eliminado el autor");

                        buscarTodos();
                        resetInput();
                    } catch(NumberFormatException n) {
                        showMessageDialog(null, "El id especificado es demasiado largo. Introduzca un número entre 0 y " + Long.MAX_VALUE);

                    }

                }
                break;


            case "Buscar":
                // Busca autor en la base de datos segun el id
                if (!ventana.textFieldBuscar.getText().isEmpty()) {

                    try{

                        autor = datos.obtenerautor(new ObjectId(String.format("%024d", Long.parseLong(ventana.textFieldBuscar.getText()))));


                        if (autor != null) {
                            cargar(autor);
                        } else {
                            showMessageDialog(null, "No se ha encontrado ningún autor con este id");
                        }
                    } catch(NumberFormatException n) {
                        showMessageDialog(null, "El id especificado es demasiado largo. Introduzca un número entre 0 y " + Long.MAX_VALUE);
                    }

                } else {
                    showMessageDialog(null, "Escriba el id del autor que quiera buscar en el campo de arriba");

                }

                break;
        }
    }

    private boolean compobarCampos() {
        boolean procesoOk = true;
        if (ventana.textFieldId.getText().isEmpty()) {
            procesoOk = false;
            showMessageDialog(null, "El id del autor no puede estar vacío");

        } else if (ventana.textFieldNombre.getText().isEmpty()) {
            procesoOk = false;
            showMessageDialog(null, "El nombre del autor no puede estar vacío");

        } else if (ventana.textFieldPriApellido.getText().isEmpty()) {
            procesoOk = false;
            showMessageDialog(null, "El primer apellido del autor no puede estar vacío");

        } else if (ventana.textFieldSegAepllido.getText().isEmpty()) {
            procesoOk = false;
            showMessageDialog(null, "El segundo apellido del autor no puede estar vacío");

        } else if (ventana.textFieldFechanac.getText().isEmpty()) {
            procesoOk = false;
            showMessageDialog(null, "la fecha de nacimiento del autor no puede estar vacía");

        }
        System.out.println(procesoOk);
        return procesoOk;
    }

    private void cargar(Autor autor) {

        ventana.textFieldId.setText(autor.getId().toString());
        ventana.textFieldNombre.setText(autor.getNombre());
        ventana.textFieldPriApellido.setText(autor.getApellido1());
        ventana.textFieldSegAepllido.setText(autor.getApellido2());
        ventana.textFieldFechanac.setText(new SimpleDateFormat("dd-MM-yyyy").format(autor.getFechanaci()));
    }

    private Autor asignarAtributos(Autor autor) {
        try  {
            autor.setId(new ObjectId(String.format("%024d", Long.parseLong(ventana.textFieldId.getText()))));
            autor.setNombre(ventana.textFieldNombre.getText());
            autor.setApellido1(ventana.textFieldPriApellido.getText());
            autor.setApellido2(ventana.textFieldSegAepllido.getText());
            try {
                autor.setFechanaci(new Date(new SimpleDateFormat("dd-MM-yyyy").parse(ventana.textFieldFechanac.getText()).getTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }catch(NumberFormatException n) {
            showMessageDialog(null, "El id especificado es demasiado largo. Introduzca un número entre 0 y " + Long.MAX_VALUE);

        }
        return autor;
    }

    private void resetInput() {
        ventana.textFieldId.setText("");
        ventana.textFieldNombre.setText("");
        ventana.textFieldPriApellido.setText("");
        ventana.textFieldSegAepllido.setText("");
        ventana.textFieldFechanac.setText("");
        ventana.textFieldBuscar.setText("");
    }

    private void addEventListeners(ActionListener listener) {

        ventana.nuevoButton.addActionListener(listener);
        ventana.guardarButton.addActionListener(listener);
        ventana.modificarButton.addActionListener(listener);
        ventana.eliminarButton.addActionListener(listener);
        ventana.buscarButton.addActionListener(listener);

    }

    private void buscarTodos() {
        ArrayList<Autor> autores = datos.listaautors();
        ventana.buscarTextPane.setText(null);
        for (Autor autor :
                autores) {
            if (ventana.buscarTextPane.getText().isEmpty()) {
                ventana.buscarTextPane.setText(autor.getId().toString().replaceFirst("^0+(?!$)", "") + " - " + autor.getNombre());
            } else {
                ventana.buscarTextPane.setText(ventana.buscarTextPane.getText() + "\n" + autor.getId() + " - " + autor.getNombre());
            }

        }
    }
}
