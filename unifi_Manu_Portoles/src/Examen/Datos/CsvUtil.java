package Examen.Datos;

import Examen.Objetos.Hotspotop;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvUtil {
    
    public List<Hotspotop> listaDatosCsv(String fileName) {
        List<Hotspotop> listaDatos = new ArrayList<>();
        Path ruta = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(ruta)) {
            String linea = br.readLine();

            while (linea != null) {

                String[] campos = linea.split(",");

                String nombre = campos[2];
                String passwd = campos[6];

                Hotspotop datos =  new Hotspotop(nombre,passwd);

                listaDatos.add(datos);

                linea = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaDatos;
    }


}
