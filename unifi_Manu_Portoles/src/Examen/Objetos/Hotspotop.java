package Examen.Objetos;

import org.bson.types.ObjectId;

public class Hotspotop {
    public static String COLECCION = "hotspotop";
    private ObjectId _id = new ObjectId();
    private String name;
    private String x_password;
    private String site_id = "576d183dd186c7c06901a07d";

    public Hotspotop(){
    }

    public Hotspotop( String name, String x_password) {
        this.name = name;
        this.x_password = x_password;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getX_password() {
        return x_password;
    }

    public void setX_password(String x_password) {
        this.x_password = x_password;
    }

    public String getSite_id() {
        return site_id;
    }

    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }
}
