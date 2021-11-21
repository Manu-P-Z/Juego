package Aad.manu.datos;


import Aad.manu.objects.Autor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

public class AccesoADatos {

    MongoClient mongoClient = new MongoClient();
    MongoDatabase db;

    private void crearConexion() {
        db = mongoClient.getDatabase("Autor");

    }

    private void cerrarSentencia() {
//        mongoClient.close();
    }

    public void addautor(Autor autor) {
        crearConexion();

        Document documento = new Document()
                .append("id", autor.getId())
                .append("nombre", autor.getNombre())
                .append("apellido1", autor.getApellido1())
                .append("apellido2", autor.getApellido2())
                .append("fechanaci", autor.getFechanaci());

        db.getCollection("Autor").insertOne(documento);
        cerrarSentencia();
    }

    public void modificarautor(ObjectId idantiguoautor, Autor nuevoautor) {
        crearConexion();
        db.getCollection("Autor").replaceOne(new Document("id", idantiguoautor),
                new Document()
                        .append("id", nuevoautor.getId())
                        .append("nombre", nuevoautor.getNombre())
                        .append("apellido1", nuevoautor.getApellido1())
                        .append("apellido2", nuevoautor.getApellido2())
                        .append("fechanaci", nuevoautor.getFechanaci()));
        cerrarSentencia();
    }

    public void borrarautor(ObjectId idautor) {
        crearConexion();
        db.getCollection("Autor").deleteOne(new Document("id", idautor));
        cerrarSentencia();
    }


    public ArrayList<Autor> listaautors() {
        crearConexion();
        FindIterable findIterable = db.getCollection("Autor").find();

        ArrayList<Autor> autores = new ArrayList<>();
        Autor autor = null;

        for (Document documento : (Iterable<Document>) findIterable) {
            autor = new Autor();
            autor.setId(documento.getObjectId("id"));
            autor.setNombre(documento.getString("nombre"));
            autor.setApellido1(documento.getString("apellido1"));
            autor.setApellido2(documento.getString("apellido2"));
            autor.setFechanaci(documento.getDate("fechanaci"));
            autores.add(autor);
            cerrarSentencia();
        }


        return autores;
    }

    public Autor obtenerautor(ObjectId idautor) {
        Document documentoAutor = new Document("id", idautor);

        crearConexion();
        FindIterable findIterable = db.getCollection("Autor").find(documentoAutor);


        Autor autor = null;

        for (Document documento : (Iterable<Document>) findIterable) {
            autor = new Autor();
            autor.setId(documento.getObjectId("id"));
            autor.setNombre(documento.getString("nombre"));
            autor.setApellido1(documento.getString("apellido1"));
            autor.setApellido2(documento.getString("apellido2"));
            autor.setFechanaci(documento.getDate("fechanaci"));
        }
        cerrarSentencia();


        return autor;
    }
}
