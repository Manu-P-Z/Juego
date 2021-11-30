package Examen.Datos;

import Examen.Objetos.Hotspotop;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoUtil {
    MongoClient mongoClient = new MongoClient("172.21.130.3:27017");
    MongoDatabase db;

    private void crearConexion() {
        db = mongoClient.getDatabase("datos");
    }

    public void addDatos(Hotspotop datos) {
        crearConexion();

        Document documento = new Document()
                .append("id", datos.get_id())
                .append("nombre", datos.getName())
                .append("passwd", datos.getX_password())
                .append("site_id", datos.getSite_id());

        db.getCollection("Datos").insertOne(documento);
    }

}
